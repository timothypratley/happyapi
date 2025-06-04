(ns happyapi.oauth2.client
  (:require [clojure.string :as str]
            [happyapi.middleware :as middleware]
            [happyapi.oauth2.capture-redirect :as capture-redirect]
            [happyapi.oauth2.credentials :as credentials]))

(def required-config [:provider :client_id :client_secret :auth_uri :token_uri :redirect_uri])

(defn missing-config [config]
  (seq (for [k required-config
             :when (not (get config k))]
         k)))

(defmulti endpoints identity)
(defmethod endpoints :default [_] nil)
(defmethod endpoints :google [_]
  {:auth_uri              "https://accounts.google.com/o/oauth2/auth"
   :token_uri             "https://oauth2.googleapis.com/token"
   ;; port 0 selects a random port
   :redirect_uri          "http://localhost:0/redirect"
   :authorization_options {:access_type            "offline"
                           :prompt                 "consent"
                           :include_granted_scopes true}})
(defmethod endpoints :github [_]
  {:auth_uri     "https://github.com/login/oauth/authorize"
   :token_uri    "https://github.com/login/oauth/access_token"
   ;; port 0 selects a random port
   :redirect_uri "http://localhost:0/redirect"})
(defmethod endpoints :twitter [_]
  {:auth_uri              "https://twitter.com/i/oauth2/authorize"
   :token_uri             "https://api.twitter.com/2/oauth2/token"
   :redirect_uri          "http://localhost:8080/redirect"
   :authorization_options {:code_challenge_method "plain"}})

(defn with-endpoints
  "The only configuration required is to know the provider (for endpoints),
  the client-id and the client-secret.
  This helper adds the endpoints for a given provider."
  [{:as config :keys [provider]}]
  (if provider
    (merge (endpoints provider) config)
    config))

(defn oauth2
  "Performs a http-request that includes oauth2 credentials.
  Will obtain fresh credentials prior to the request if necessary.
  See https://developers.google.com/identity/protocols/oauth2 for more information."
  [request args config]
  (let [{:keys [provider fns]} config
        {:keys [read-credentials
                update-credentials
                save-credentials]} fns
        {:keys [user scopes] :or {user "user" scopes (:scopes config)}} args
        credentials (read-credentials provider user)
        credentials (update-credentials request config credentials scopes)
        {:keys [access_token]} credentials]
    (save-credentials provider user credentials)
    (if access_token
      (request (middleware/bearer-header args access_token))
      (throw (ex-info (str "Failed to obtain credentials for " user)
                      {:id     ::failed-credentials
                       :user   user
                       :scopes scopes})))))

(defn oauth2-async
  "Only the http request is asynchronous; reading, updating, or writing credentials is done synchronously.
  Asynchronously obtaining credentials is challenging because it may rely on waiting for a redirect back.
  This compromise allows for convenient usage, but means that calls may block while authorizing before
  the http request is made."
  [request args config respond raise]
  (let [{:keys [provider fns]} config
        {:keys [read-credentials
                update-credentials
                save-credentials]} fns
        {:keys [user scopes] :or {user "user" scopes (:scopes config)}} args
        credentials (read-credentials provider user)
        credentials (update-credentials request config credentials scopes)
        {:keys [access_token]} credentials]
    (save-credentials provider user credentials)
    (if access_token
      (request (middleware/apikey-param args access_token) respond raise)
      (raise (ex-info (str "Async failed to obtain credentials for " user)
                      {:id     ::async-failed-credentials
                       :user   user
                       :scopes scopes})))))

(defn check [config]
  (when-let [ks (missing-config config)]
    (throw (ex-info (str "Invalid oauth2 config: missing " (str/join "," ks))
                    {:id      ::invalid-config
                     :missing (vec ks)
                     :config  config})))
  config)

(defn with-credential-fns [config]
  (update config :fns
          (fn merge-left [fns]
            (merge {:read-credentials   credentials/read-credentials
                    :update-credentials capture-redirect/update-credentials
                    :save-credentials   credentials/save-credentials}
                   fns))))

(defn wrap-oauth2
  "Wraps an http-request function that uses keys user and scopes from args to authorize according to config."
  [request config]
  (let [config (-> (with-endpoints config)
                   (with-credential-fns))]
    (when-let [ks (missing-config config)]
      (throw (ex-info (str "Invalid config: missing " (str/join "," ks))
                      {:id      ::invalid-config
                       :missing (vec ks)
                       :config  config})))
    (when-not (middleware/fn-or-var? request)
      (throw (ex-info "request must be a function or var"
                      {:id           ::request-must-be-a-function
                       :request      request
                       :request-type (type request)})))
    (fn
      ([args]
       (oauth2 request args config))
      ([args respond raise]
       (oauth2-async request args config respond raise)))))

(defn make-client
  "Given a config map

  {#{:client_id :client_secret}  <string>
   :provider                     #{:google :amazon :github :twitter ...}
   #{:auth_uri :token_uri}       <string>
   :fns                          {#{:request :query-string :encode :decode} <fn-or-var>}
   :keywordize-keys              <boolean>}

  Returns a wrapped request function.

  If `provider` is known, then auth_uri and token_uri endpoints will be added to the config,
  otherwise expects `auth_uri` and `token_uri`.
  `provider` is required to namespace tokens, but is not restricted to known providers.
  Dependencies are passed as functions in `fns`."
  [{:as config :keys [keywordize-keys] {:keys [request]} :fns}]
  (when-not (middleware/fn-or-var? request)
    (throw (ex-info "request must be a function or var"
                    {:id      ::request-must-be-a-function
                     :request request
                     :config  config})))
  (-> request
      (middleware/wrap-cookie-policy-standard)
      (middleware/wrap-informative-exceptions)
      (middleware/wrap-json config)
      (wrap-oauth2 config)
      (middleware/wrap-uri-template)
      (middleware/wrap-paging)
      (middleware/wrap-extract-result)
      (middleware/wrap-keywordize-keys keywordize-keys)))
