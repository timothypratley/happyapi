(ns happy.oauth2.client
  (:require [happy.middleware :as middleware]
            [happy.oauth2.capture-redirect :as capture-redirect]
            [happy.oauth2.auth :as auth]
            [happy.oauth2.credentials :as credentials]
            [happy.pluggable :as pluggable]))

(defn config-valid? [{:keys [auth_uri token_uri client_id client_secret redirect_uri redirect_uris]}]
  (and auth_uri token_uri client_id client_secret (or redirect_uri redirect_uris)))

(defn oauth2
  "Performs a http-request that includes oauth2 credentials.
  Will obtain fresh credentials prior to the request if necessary.
  See https://developers.google.com/identity/protocols/oauth2 for more information."
  [request args config]
  (let [{:keys [user scopes] :or {user "user" scopes (:scopes config)}} args
        credentials (credentials/read-credentials user)
        credentials (capture-redirect/update-credentials request config credentials scopes)]
    (credentials/save-credentials user credentials)
    (if credentials
      (request (merge-with merge args (auth/auth-header credentials)))
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
        credentials (capture-redirect/update-credentials request config credentials scopes)]
    (credentials/save-credentials user credentials)
    (if credentials
      (request (merge-with merge args (auth/auth-header credentials)) respond raise)
      (raise (ex-info (str "Async failed to obtain credentials for " user)
                      {:id     ::async-failed-credentials
                       :user   user
                       :scopes scopes})))))

(defn wrap-oauth2
  "Wraps a http-request function that uses keys user and scopes from args to authorize according to config."
  [request config]
  (when-not (config-valid? config)
    (throw (ex-info "invalid config"
                    {:id     ::invalid-config
                     :config config})))
  (when-not (fn? request)
    (throw (ex-info "request must be a function"
                    {:id      ::request-must-be-a-function
                     :request request})))
  (fn
    ([args]
     (oauth2 request args config))
    ([args respond raise]
     (oauth2-async request args config respond raise))))

(defn wrap-api
  "Wraps a http-request function with middleware necessary for accessing an API."
  [request config]
  (-> request
      (middleware/wrap-cookie-policy-standard)
      (middleware/wrap-informative-exceptions)
      (middleware/wrap-json)
      (wrap-oauth2 config)
      (middleware/wrap-uri-template)
      (middleware/wrap-deitemize)
      ;; TODO: wrap response normalization
      (middleware/wrap-paging)))

(def api-request
  "Makes API requests.
  If you have a http client dependency and secret.json or service.json file,
  `api-request` will be initialized to use them.
  Otherwise, it will throw an exception unless configured with `configure!`."
  (let [config (credentials/read-secret)]
    (if (and pluggable/http-request config)
      (wrap-api pluggable/http-request config)
      (fn uninitialized
        ([args]
         (throw (ex-info (cond config "HTTP client dependency not found"
                               pluggable/http-request "Configuration not found"
                               :else "HTTP client and configuration not found")
                         {:id ::missing-client-or-configuration})))
        ([args respond raise]
         (uninitialized args))))))

(defn configure!
  "Changes `api-request` given a http-request and configuration.
  May be useful if your configuration is not inside a secret.json or service.json file."
  [request config]
  (alter-var-root #'api-request
                  (fn [_prev]
                    (wrap-api request config))))

;; question: how to control arg checking (if at all?), maybe leave that up to users?
;; maybe follow malli convention (or spec)
;; idea:
#_(defn strict! []
  (alter-var-root #'api-request
                  (fn [_prev]
                    #_(wrap-check-args-or-something??))))
