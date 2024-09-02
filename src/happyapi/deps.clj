(ns happyapi.deps
  "Presents an interface to performing http requests and json encoding/decoding.
  Allows easy selection of and migration between libraries that provide these features
  and avoids pulling in unnecessary dependencies.
  Dependencies are required upon selection.")

(defn resolve-fn
  "Requires, resolves, and derefs to a function identified by sym, will throw on failure"
  [sym]
  (try (require (symbol (namespace sym)))
       (catch Throwable ex
         (throw (ex-info (str "Failed to require " sym " - are you missing a dependency?")
                         {:id  ::dependency-ns-not-found
                          :sym sym}
                         ex))))
  (or (some-> (ns-resolve *ns* sym)
              (deref))
      (throw (ex-info (str "Failed to find " sym " in " (namespace sym))
                      {:id  ::dependency-fn-not-found
                       :sym sym}))))

(defmulti require-dep "Resolves a provider keyword to the functions it provides" identity)

(defmethod require-dep :httpkit [_]
  {:request      (let [httpkit-request (resolve-fn 'org.httpkit.client/request)]
                   (fn request
                     ([args] @(httpkit-request args))
                     ([args respond raise]
                      (httpkit-request args (fn callback [response]
                                              ;; httpkit doesn't raise, it just puts errors in the response
                                              (if (contains? response :error)
                                                (raise (ex-info "ERROR in response"
                                                                {:id   ::error-in-response
                                                                 :resp response}))
                                                (respond response)))))))
   :query-string (resolve-fn 'org.httpkit.client/query-string)
   :run-server   (let [run (resolve-fn 'org.httpkit.server/run-server)
                       port (resolve-fn 'org.httpkit.server/server-port)
                       stop! (resolve-fn 'org.httpkit.server/server-stop!)]
                   (fn httpkit-run-server [handler config]
                     (let [server (run handler (assoc config :legacy-return-value? false))]
                       {:port (port server)
                        :stop (fn [] (stop! server {:timeout 100}))})))})
(defmethod require-dep :jetty [_]
  {:run-server (let [run (resolve-fn 'ring.adapter.jetty/run-jetty)]
                 (fn jetty-run-server [handler config]
                   (let [server (run handler (assoc config :join? false))]
                     (.setStopTimeout server 100)
                     {:port (-> server .getConnectors first .getLocalPort)
                      :stop (fn stop-jetty []
                              (.stop server))})))})
(defmethod require-dep :clj-http [_]
  {:request      (resolve-fn 'clj-http.client/request)
   :query-string (resolve-fn 'clj-http.client/generate-query-string)})
(defmethod require-dep :clj-http.lite [_]
  {:request      (resolve-fn 'clj-http.lite.client/request)
   :query-string (resolve-fn 'clj-http.lite.client/generate-query-string)})

(defmethod require-dep :cheshire [_]
  {:encode (resolve-fn 'cheshire.core/generate-string)
   :decode (resolve-fn 'cheshire.core/parse-string)})
(defmethod require-dep :jsonista [_]
  {:encode (resolve-fn 'jsonista.core/write-value-as-string)
   :decode (resolve-fn 'jsonista.core/read-value)})
(defmethod require-dep :data.json [_]
  {:encode (resolve-fn 'clojure.data.json/write-str)
   :decode (resolve-fn 'clojure.data.json/read-str)})
(defmethod require-dep :charred [_]
  {:encode (resolve-fn 'charred.api/read-json)
   :decode (resolve-fn 'charred.api/write-json-str)})

(defn possible
  "Returns the valid keys for `choose` and `require-deps`."
  []
  (set (keys (methods require-dep))))

(defn choose
  "Requires dependency providers, and returns a map containing functions.
  See `possible-providers` for valid inputs."
  ([ks] (apply merge (map require-dep ks))))

(defn present
  "For informative purposes only.
  Shows what dependencies are available.
  Will attempt to require all possible dependency providers."
  []
  (into {}
        (for [[k f] (methods require-dep)]
          [k (try (f k) (catch Throwable ex))])))
