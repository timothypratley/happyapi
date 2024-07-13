(ns happyapi.oauth2.capture-redirect
  "Reference for receiving a token in a redirect from the oauth provider.
  If you are making a web app, implement a route in your app that captures the code parameter.
  If you use this namespace, add ring as a dependency in your project."
  (:require [clojure.java.browse :as browse]
            [clojure.set :as set]
            [happyapi.middleware :as middleware]
            [happyapi.oauth2.auth :as oauth2]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.params :as params])
  (:import (org.eclipse.jetty.server NetworkConnector Server)))

(set! *warn-on-reflection* true)

(defn get-port [^Server server]
  (-> server .getConnectors ^NetworkConnector first .getLocalPort))

(def login-timeout
  "If the user doesn't log in after 2 minutes, stop waiting."
  (* 2 60 1000))

(defn browse-to-provider [config scopes optional]
  (-> (oauth2/provider-login-url config scopes optional)
      (browse/browse-url)))

(defn fresh-credentials
  "Opens a browser to authenticate, waits for a redirect, and returns a code.
  Defaults access_type to offline,
  state to a random uuid which is checked when redirected back,
  and include_granted_scopes true."
  [request {:as config :keys [redirect_uri authorization_options]} scopes]
  ;; TODO: can p be made accessible, stoppable?
  (let [p (promise)
        [match protocol host _ port path] (re-find #"^(http://)(localhost|127.0.0.1)(:(\d+))?(/.*)?$" redirect_uri)
        _ (when-not match
            (throw (ex-info "redirect_uri should match http://localhost"
                            {:id           ::bad-redirect-uri
                             :redirect_uri redirect_uri
                             :config       config})))

        ;; port 80 is a privileged port that requires root permissions, which may be problematic for some users
        ;; a random (or specified) port is a natural choice.

        ;; Google allows the redirect_uri port to vary
        ;; From RFC 8242: OAuth 2.0 for Native Apps:
        ; The authorization server MUST allow any port to be specified at the
        ; time of the request for loopback IP redirect URIs, to accommodate
        ; clients that obtain an available ephemeral port from the operating
        ; system at the time of the request.

        ;; Other providers do not allow port to vary

        ;; TODO: it might be better to require a port, and allow port to be 0 for randomization?

        ;; TODO: is there some way to know when using Native App mode?
        port (if port
               (Integer/parseInt port)
               0)
        http-redirect-handler (fn [request]
                                {:status 200
                                 :body   (if (get @(deliver p (get request :params)) "code")
                                           "Code received, authentication successful."
                                           "No code in response")})
        ;; TODO: pluggable httpkit?
        server (jetty/run-jetty (params/wrap-params http-redirect-handler)
                                {:port port :join? false})
        port (get-port server)
        config (assoc config :redirect_uri (str protocol host ":" port path))
        ;; Twitter supports and requires pkce challenge.
        ;; Challenges are for the provider server checking, state is for client checking, we use the same value for both.
        state-and-challenge (str (random-uuid))
        {:keys [code_challenge_method]} authorization_options
        ;; access_type offline and prompt consent together result in a refresh token (that both are necessary is undocumented by Google afaik)
        ;; most web-apps wouldn't do this, it is intended for desktop apps, which is the anticipated usage of this namespace
        optional (merge authorization_options
                        {:state state-and-challenge}
                        (when code_challenge_method
                          {:code_challenge state-and-challenge}))
        ;; send the user to the provider to authenticate and authorize.
        ;; this url includes the redirect_uri as a query param,
        ;; so we must provide port chosen by our local server
        _ (browse-to-provider config scopes optional)
        ;; wait for the user to get redirected to localhost with a code
        {:strs [code state] :as return-params} (deref p login-timeout nil)]
    ;; allow a bit of time to deliver the response before shutting down the server
    (.setStopTimeout server 1000)
    (.stop server)

    (if code
      (do
        (when-not (= state state-and-challenge)
          (throw (ex-info "Redirected state does not match request"
                          {:id            ::redirected-state-mismatch
                           :optional      optional
                           :return-params return-params})))
        ;; exchange the code with the provider for credentials
        ;; (must have the same config as browse, the redirect_uri needs the correct port)
        (oauth2/exchange-code request config code (when code_challenge_method state-and-challenge)))
      (throw (ex-info "Login timeout, no code received."
                      {:id ::login-timeout})))))

(defn update-credentials
  "Use credentials if valid, refresh if necessary, or get new credentials.
  For valid optional params, see https://developers.google.com/identity/protocols/oauth2/web-server#httprest_1"
  ([request config credentials scopes]
   ;; scopes can grow
   (let [scopes (set/union (oauth2/credential-scopes credentials) (set scopes))
         ;; for auth calls we will need the results to be keywordized.
         request (middleware/wrap-keywordize-keys request)]
     ;; merge to retain refresh token
     (merge credentials
            (or
              ;; already have valid credentials
              (and (oauth2/valid? credentials)
                   (oauth2/has-scopes? credentials scopes)
                   credentials)
              ;; try to refresh existing credentials
              (and (oauth2/refreshable? config credentials)
                   (oauth2/has-scopes? credentials scopes)
                   (oauth2/refresh-credentials request config scopes credentials))
              ;; new credentials required
              (fresh-credentials request config scopes))))))
