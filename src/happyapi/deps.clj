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
  {:request      (resolve-fn 'happyapi.deps.httpkit/request)
   :query-string (resolve-fn 'org.httpkit.client/query-string)
   :run-server   (resolve-fn 'happyapi.deps.httpkit/run-server)})
(defmethod require-dep :jetty [_]
  {:run-server (resolve-fn 'happyapi.deps.jetty/run-server)})
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
