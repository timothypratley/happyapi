(ns happyapi.setup
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.walk :as walk]
            [happyapi.apikey.client :as apikey.client]
            [happyapi.deps :as deps]
            [happyapi.middleware :as middleware]
            [happyapi.oauth2.client :as oauth2.client]))

(defn as-map
  "If a string, will coerce as edn.
  If given a map, will return it unchanged."
  [config]
  (cond (map? config) config
        (string? config) (let [{:keys [decode]} (deps/require-dep :cheshire)]
                           (walk/keywordize-keys (decode config)))
        (nil? config) config
        :else (throw (ex-info "Unexpected configuration type"
                              {:id          ::unexpected-configuration-type
                               :config-type (type config)
                               :config      config}))))

(defn read-edn [s source]
  (try
    (edn/read-string s)
    (catch Throwable ex
      (throw (ex-info (str "Unreadable config, not EDN read from " (name source))
                      {:id     ::config-not-edn
                       :source source
                       :config s})))))

;; A standard way to search for config
;; check environment variables, files, anything else?
;; should the logic be provider specific?
;; IDEA: The redirect server can request the client_secret, allowing you to use a password manager.
(defn find-config
  "Looks for HAPPYAPI_CONFIG in the environment, then a file happyapi.edn"
  []
  (or (some-> (System/getenv "HAPPYAPI_CONFIG") (read-edn :environment))
      (let [f (io/file "happyapi.edn")]
        (when (.exists f)
          (-> (slurp f)
              (read-edn :file))))))

(defn with-deps
  "Selection of implementation functions for http and json,
  based on either the :deps or :fns of the config."
  [{:as config :keys [deps fns]}]
  (if deps
    (update config :fns #(merge (deps/choose deps) %))
    (when-not fns
      (throw (ex-info "Client configuration requires :deps like [:clj-http :cheshire] or :fns to be supplied"
                      {:id     ::config-missing-deps
                       :config config})))))

(defn resolve-fns
  [config]
  (update config :fns (fn [fns]
                        (into fns (for [[k f] fns
                                        :when (qualified-symbol? f)]
                                    [k (deps/resolve-fn f)])))))

(defn prepare-config
  "Prepares configuration by resolving dependencies.
  Checks that the necessary configuration is present, throws an exception if not.
  See docstring for make-client for typical configuration inputs."
  [provider config]
  (when-not provider
    (throw (ex-info "Provider is required"
                    {:id       ::provider-required
                     :provider provider
                     :config   config})))
  (let [config (if (nil? config)
                 (find-config)
                 (as-map config))
        config (-> (get config provider)
                   (update :provider #(or % provider))
                   (with-deps)
                   (resolve-fns))
        {:keys [client_id apikey request]} config]
    (when-not (middleware/fn-or-var? request)
      (throw (ex-info "request must be a function or var"
                      {:id           ::request-must-be-a-function
                       :request      request
                       :request-type (type request)})))
    (cond apikey config
          client_id (-> (oauth2.client/with-endpoints config)
                        (oauth2.client/check))
          :else (throw (ex-info "Missing config, expected `:client_id` or `:apikey`"
                                {:id     ::missing-config
                                 :config config})))))

(defn make-client
  "Returns a function that can make requests to an api.

  If `config` is nil, will attempt to find edn config in the environment HAPPYAPI_CONFIG,
  or a file happyapi.edn

  If specified, `config` should be a map:

      {:google {:deps            [:clj-http :cheshire]  ;; see happyapi.deps for alternatives
                :fns             {...}                  ;; if you prefer to provide your own dependencies
                :client_id       \"MY_ID\"              ;; oauth2 client_id of your app
                :client_secret   \"MY_SECRET\"          ;; oauth2 client_secret from your provider
                :apikey          \"MY_API_KEY\"         ;; only when not using oauth2
                :scopes          []                     ;; optional default scopes used when none present in requests
                :keywordize-keys false                  ;; optional, defaults to true
                :provider        :google}}              ;; optional, use another provider urls and settings

  The `provider` argument is required and should match a top level key to use (other configs may be present)."
  [config provider]
  (let [config (prepare-config provider config)
        {:keys [client_id apikey]} config]
    (cond client_id (oauth2.client/make-client config)
          apikey (apikey.client/make-client config))))
