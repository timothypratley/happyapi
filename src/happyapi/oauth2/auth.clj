(ns happyapi.oauth2.auth
  "Helpers for getting an OAuth 2.0 token.
  See https://developers.google.com/identity/protocols/OAuth2WebServer"
  (:require [clojure.string :as str]
            [clojure.set :as set]
            [buddy.sign.jwt :as jwt]
            [buddy.core.keys :as keys]
            [happyapi.middleware :as middleware])
  (:import (java.util Date)
           (java.util Base64)))

(set! *warn-on-reflection* true)

(defn provider-login-url
  "Step 1: Set authorization parameters.
  Builds the URL to send the user to for them to authorize your app.
  For local testing you can paste this URL into your browser,
  or call (clojure.java.browse/browse-url (provider-login-url my-config scopes optional)).
  In your app you need to send your user to this URL, usually with a redirect response.
  For valid optional params, see https://developers.google.com/identity/protocols/oauth2/web-server#httprest_1,
  noting that `state` is strongly recommended."
  ([config scopes] (provider-login-url config scopes nil))
  ([{:as                    config
     :keys                  [auth_uri client_id redirect_uri]
     {:keys [query-string]} :fns}
    scopes
    optional]
   (let [params (merge {:client_id     client_id
                        :response_type "code"
                        :redirect_uri  redirect_uri
                        :scope         (str/join " " scopes)}
                       optional)]
     (str auth_uri "?" (query-string params)))))

;; Step 2: Redirect to Google's OAuth 2.0 server.

;; Step 3: Google prompts user for consent.
;; Sit back and wait.
;; There should be a route in your app to handle the redirect from Google (see step 4).
;; happyapioauth2-capture-redirect shows how you could do this,
;; and is useful if you don't want to run a server.

;; Step 4: Handle the OAuth 2.0 server response

(defn with-timestamp
  "The server won't give us the time of day, so let's check our clock."
  [{:as credentials :keys [expires_in]}]
  (if expires_in
    (assoc credentials
      :expires_at (Date. ^long (+ (* expires_in 1000) (System/currentTimeMillis))))
    credentials))

(defn base64 [^String to-encode]
  (.encodeToString (Base64/getEncoder) (.getBytes to-encode)))

(defn exchange-code
  "Step 5: Exchange authorization code for refresh and access tokens.
  When the user is redirected back to your app from Google with a short-lived code,
  exchange the code for a long-lived access token."
  [request
   {:as config :keys [token_uri client_id client_secret redirect_uri]}
   code
   code_verifier]
  (let [resp (request {:method          :post
                       :url             token_uri
                       ;; Google documentation says client_id and client_secret should be parameters,
                       ;; but accepts them in the Basic Auth header (undocumented).
                       ;; Other providers require them as Basic Auth header.
                       :headers         {"Authorization" (str "Basic " (base64 (str client_id ":" client_secret)))}
                       ;; RFC 6749: form encoded params
                       :form-params     (cond-> {:code         code
                                                 :grant_type   "authorization_code"
                                                 :redirect_uri redirect_uri}
                                                code_verifier (assoc :code_verifier code_verifier))
                       :keywordize-keys true})]
    (when (middleware/success? resp)
      (with-timestamp (:body resp)))))

(defn refresh-credentials
  "Given a config map, and a credentials map containing either a refresh_token or private_key,
  fetches a new access token.
  Returns credentials if successful (a map containing an access token).
  Refresh tokens eventually expire, and attempts to refresh will fail with 401.
  Therefore, calls that could cause a refresh should catch 401 exceptions,
  call set-authorization-parameters and redirect."
  [request
   {:as config :keys [token_uri client_id client_secret client_email private_key]}
   scopes
   {:as credentials :keys [refresh_token]}]
  (try
    (let [now (quot (.getTime (Date.)) 1000)
          params (cond private_key
                       {:grant_type "urn:ietf:params:oauth:grant-type:jwt-bearer"
                        :assertion  (jwt/sign
                                      {:iss   client_email,
                                       :scope (str/join " " scopes),
                                       :aud   token_uri
                                       :exp   (+ now 3600)
                                       :iat   now}
                                      (keys/str->private-key private_key)
                                      {:alg    :rs256
                                       :header {:alg "RS256"
                                                :typ "JWT"}})}

                       refresh_token
                       {:client_id     client_id
                        :client_secret client_secret
                        :grant_type    "refresh_token"
                        :refresh_token refresh_token}

                       :else (throw (ex-info "Refresh missing token"
                                             {:id ::refresh-missing-token})))
          resp (request {:url             token_uri
                         :method          :post
                         :form-params     params
                         :keywordize-keys true})]
      (when (middleware/success? resp)
        (with-timestamp (:body resp))))
    (catch Exception ex
      ;; TODO: should probably only swallow 401?
      )))

(defn revoke-token
  "Given a credentials map containing either an access token or refresh token, revokes it."
  [request
   {:as config :keys [token_uri]}
   {:as credentials :keys [access_token refresh_token]}]
  (request {:method          :post
            :url             (str/replace token_uri #"/token$" "/revoke")
            ;; may be form-params or json body
            :body            {"token" (or access_token
                                          refresh_token
                                          (throw (ex-info "Credentials missing token"
                                                          {:id          ::credentials-missing-token
                                                           :credentials credentials})))}
            :keywordize-keys true}))

(defn valid? [{:as credentials :keys [expires_at access_token]}]
  (boolean
    (and access_token
         (or (not expires_at)
             (neg? (.compareTo (Date.) expires_at))))))

(defn refreshable? [{:as config :keys [private_key]} {:as credentials :keys [refresh_token]}]
  (boolean (or refresh_token private_key)))

(defn credential-scopes [credentials]
  (set (some-> credentials
               :scope
               (str/split #" "))))

(defn has-some-scope?
  "Test if any of the sufficient scopes is present in the token.

  While scopes in APIs can have a hierarchy,
  all sufficient scopes for an API need to be listed explicitly.

  E.g. Google's discovery docs follow that rule and list all possible scopes.
  whenever you see a https://www.googleapis.com/auth/spreadsheets.readonly scope,
  the more powerful https://www.googleapis.com/auth/spreadsheets scope will be listed, too."
  [credentials scopes]
  (not (empty? (set/intersection (set scopes)
                                 (credential-scopes credentials)))))
