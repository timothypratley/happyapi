(ns happyapi.oauth2.client
  (:require [happyapi.middleware :as middleware]
            [happyapi.oauth2.capture-redirect :as capture-redirect]
            [happyapi.oauth2.credentials :as credentials]))

(defn config-valid? [{:keys [auth_uri token_uri client_id client_secret redirect_uri redirect_uris]}]
  (and auth_uri token_uri client_id client_secret (or redirect_uri redirect_uris)))

(defmulti endpoints identity)
(defmethod endpoints :default [_] nil)
(defmethod endpoints :google [_]
  {:auth_uri  "https://accounts.google.com/o/oauth2/auth"
   :token_uri "https://oauth2.googleapis.com/token"})
(defmethod endpoints :github [_]
  {:auth_uri  "https://github.com/login/oauth/authorize"
   :token_uri "https://github.com/login/oauth/access_token"})
(defmethod endpoints :twitter [_]
  {:auth_uri  "https://twitter.com/i/oauth2/authorize"
   :token_uri "https://api.twitter.com/oauth2/token"})

(defn with-endpoints
  "The only configuration required is to know the provider (for endpoints),
  the client-id and the client-secret.
  This helper adds the endpoints for a given provider."
  [{:as config :keys [provider]}]
  (if provider
    (merge (endpoints provider)
           {:redirect_uri "https://localhost/redirect"}
           config)
    config))

(defn oauth2
  "Performs a http-request that includes oauth2 credentials.
  Will obtain fresh credentials prior to the request if necessary.
  See https://developers.google.com/identity/protocols/oauth2 for more information."
  [request args config]
  (let [{:keys [user scopes] :or {user "user" scopes (:scopes config)}} args
        credentials (credentials/read-credentials user)
        credentials (capture-redirect/update-credentials request config credentials scopes)
        {:keys [access_token]} credentials]
    (credentials/save-credentials user credentials)
    (if access_token
      (request (middleware/auth-header args access_token))
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
  (let [{:keys [user scopes] :or {user "user" scopes (:scopes config)}} args
        credentials (credentials/read-credentials user)
        credentials (capture-redirect/update-credentials request config credentials scopes)
        {:keys [access_token]} credentials]
    (credentials/save-credentials user credentials)
    (if access_token
      (request (middleware/auth-header args access_token) respond raise)
      (raise (ex-info (str "Async failed to obtain credentials for " user)
                      {:id     ::async-failed-credentials
                       :user   user
                       :scopes scopes})))))

(defn wrap-oauth2
  "Wraps a http-request function that uses keys user and scopes from args to authorize according to config."
  [request config]
  (let [config (with-endpoints config)]
    (when-not (config-valid? config)
      ;; TODO: which one?
      (throw (ex-info "Invalid config: missing required key"
                      {:id     ::invalid-config
                       :config config})))
    (when-not (middleware/fn-or-var? request)
      (throw (ex-info "request must be a function or var"
                      {:id           ::request-must-be-a-function
                       :request      request
                       :request-type (type request)})))
    (when-not (middleware/fn-or-var? (get-in config [:fns :query-string]))
      (throw (ex-info "query-string must be provided in config :fns :query-string as a function or var"
                      {:id     ::query-string-must-be-a-function
                       :config config})))
    (fn
      ([args]
       (oauth2 request args config))
      ([args respond raise]
       (oauth2-async request args config respond raise)))))

(defn make-client
  "Given a config map

  {#{:client_id :client_secret}     <string>
   (or [:provider                   #{:google :amazon :github :twitter}]
       [#{:auth_uri :token_uri}     <string>])
   :fns                             {#{:request :query-string :encode :decode} <fn-or-var>}
   :keywordize-keys                 <boolean>}

  returns a wrapped request function.

  If `provider` is supplied then auth and token endpoints will be added to the config,
  otherwise expects `auth_uri` and `token_uri`.
  Dependencies are passed as functions in `fns`."
  [{:as config {:keys [request]} :fns}]
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
      (middleware/wrap-extract-result)))
