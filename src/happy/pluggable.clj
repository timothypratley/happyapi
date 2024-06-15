(ns happy.pluggable
  "Presents an interface to performing http requests and json parsing.
  Existing dependencies are automatically resolved when this ns is required.
  This is done to allow easy selection or migration between libraries that provide these features,
  and to avoid forcing one particular implementation to be required.
  Doing so also allows the possibility of reassigning them to some other (unknown at this time) dependency.
  One downside is that the introduction of new dependencies (even transitively)
  can now result in different code being called."
  (:require [clojure.string :as str]
            [clojure.walk :as walk])
  (:import (java.net URLEncoder)))

(defn resolve-fn [sym]
  (try (require (symbol (namespace sym)))
       (catch Throwable ex))
  (some-> (ns-resolve *ns* sym)
          (deref)))

(def http-request
  (or (resolve-fn 'clj-http.client/request)
      (some->> (resolve-fn 'org.httpkit.client/request)
               (comp deref))))

(defn success?
  [{:keys [status]}]
  (and (number? status)
       (<= 200 status 299)))

(def parse-json
  (some->> (or (resolve-fn 'jsonista.core/read-value)
               (resolve-fn 'cheshire.core/parse-string)
               (resolve-fn 'clojure.data.json/read-str))
           (comp walk/keywordize-keys)))

(defn url-encode [^String s]
  (URLEncoder/encode s "UTF-8"))

(def query-string
  (or (resolve-fn 'org.httpkit.client/query-string)
      (resolve-fn 'clj-http.client/generate-query-string)
      (fn [query-params]
        (str/join "&" (for [[k v] query-params]
                        (str (url-encode (name k)) "=" (url-encode (str v))))))))

;; TODO: this doesn't seem cool, just a required lib?
;; might be cool to support others, or not.
(def uri-template
  (resolve-fn 'com.grzm.uri-template/expand))
