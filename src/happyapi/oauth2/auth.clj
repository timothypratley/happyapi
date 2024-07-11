(ns happyapi.oauth2.auth
  "Helpers for getting an OAuth 2.0 token.
  See https://developers.google.com/identity/protocols/OAuth2WebServer"
  (:require [clojure.string :as str]
            [clojure.set :as set]
            [buddy.sign.jwt :as jwt]
            [buddy.core.keys :as keys]
            [happyapi.middleware :as middleware])
  (:import (java.util Date)))

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
  ([{:as config
     :keys [auth_uri client_id redirect_uri redirect_uris]
     {:keys [query-string]} :fns}
    scopes
    optional]
   (let [params (merge {:client_id     client_id
                        :nonce         (str (random-uuid))
                        :response_type "code"
                        :redirect_uri  (or redirect_uri (last redirect_uris))
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
  (assoc credentials
    :expires_at (Date. ^long (+ (* expires_in 1000) (System/currentTimeMillis)))))

(defn exchange-code
  "Step 5: Exchange authorization code for refresh and access tokens.
  When the user is redirected back to your app from Google with a short-lived code,
  exchange the code for a long-lived access token."
  [request
   {:as config :keys [token_uri client_id client_secret redirect_uri redirect_uris]}
   code]
  (let [resp (request {:method      :post
                       :url         token_uri
                       :form-params {:client_id     client_id
                                     :client_secret client_secret
                                     :code          code
                                     :grant_type    "authorization_code"
                                     :redirect_uri  (or redirect_uri (last redirect_uris))}})]
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
                        :refresh_token refresh_token})

          args {:url         token_uri
                :method      :post
                :form-params params}
          resp (request args)]
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
  (request {:method      :post
            :url         (str/replace token_uri #"/token$" "/revoke")
            :form-params {"token" (or access_token
                                      refresh_token
                                      (throw (ex-info "Credentials missing token"
                                                      {:id          ::credentials-missing-token
                                                       :credentials credentials})))}}))

(defn valid? [{:as credentials :keys [expires_at access_token]}]
  (boolean
    (and expires_at access_token
         (neg? (.compareTo (Date.) expires_at)))))

(defn refreshable? [{:as config :keys [private_key]} {:as credentials :keys [refresh_token]}]
  (boolean (or refresh_token private_key)))

(defn credential-scopes [credentials]
  (set (some-> (:scope credentials) (str/split #" "))))

(defn has-scopes? [credentials scopes]
  ;; TODO: scopes have a hierarchy
  (set/subset? (set scopes) (credential-scopes credentials)))
