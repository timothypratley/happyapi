(ns happyapi.setup
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [happyapi.apikey.client :as apikey.client]
            [happyapi.deps :as deps]
            [happyapi.oauth2.client :as oauth2.client]))

(def default-deps [:clj-http :cheshire])

;; A standard way to search for config
;; check environment variables, files, anything else?
;; should the logic be provider specific?
;; IDEA: The redirect server can request the client_secret, allowing you to use a password manager.
(defn find-config
  "Looks for HAPPYAPI_GOOGLE_CONFIG in the environment, then a file google-secret.json"
  [provider]
  (or (System/getenv (str "HAPPYAPI_"
                          (when provider (str (str/upper-case (name provider)) "_"))
                          "CONFIG"))
      (slurp (str (when provider (str (name provider) "-"))
                  "secret.json"))))

(defn as-map
  "If a string, will coerce as json. Doing so will require and use cheshire.
  If given a map, will return it unchanged."
  [config]
  (cond (map? config) config
        (string? config) (let [{:keys [decode]} (deps/require-dep :cheshire)]
                           (walk/keywordize-keys (decode config)))
        :else (throw (ex-info "Unexpected configuration type"
                              {:id          ::unexpected-configuration-type
                               :config-type (type config)
                               :config      config}))))

(defn with-deps
  "Allows selection of implementation functions for http and json.
  If no deps requested, will use defaults."
  [{:as config :keys [deps]}]
  (if (contains? config :fns)
    ;; already has dependencies
    config
    (assoc config :fns (if deps
                         ;; requested dependencies
                         (deps/choose deps)
                         ;; default dependencies
                         (deps/choose default-deps)))))

(defn make-client
  "Creates a provider specific client.

  {:provider      :google
   :deps          [:clj-http :cheshire]
   :fns           {}
   :client_id     MY_ID
   :client_secret MY_SECRET
   :apikey        MY_API_KEY}"
  ([config] (make-client config nil))
  ([config provider]
   (let [config (if (nil? config)
                  (find-config provider)
                  config)
         config (-> config as-map with-deps)
         config (if provider
                  (assoc config :provider provider)
                  config)]
     (cond (:client-id config) (oauth2.client/make-client config)
           (:apikey config) (apikey.client/make-client config)
           :else (throw (ex-info "Missing config, expected `:client-id` or `:apikey`"
                                 {:id     ::missing-config
                                  :config config}))))))
