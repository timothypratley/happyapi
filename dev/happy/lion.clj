(ns happy.lion
  "Writes to src/happygapi generated namespaces of function wrappers"
  (:require [clojure.pprint :as pp]
            [happy.beaver :as beaver]
            [happy.monkey :as monkey]
            [happy.raven :as raven]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [fipp.clojure :as pprint]))

(def discovery-failed& (atom #{}))

(defn pprint-str [x]
  (with-out-str (pprint/pprint x)))

(defn ns-str [resource-ns]
  (str/replace
    (str/join \newline
              (map pprint-str resource-ns))
    #"\\n"
    "\n  "))

(defn write-api-nss [api]
  (println "Writing" (:name api) (:version api))
  (spit (io/file "resources" (str (:name api) "_schema.edn"))
        (pprint-str (:schemas api)))
  (doseq [[resource-name resource-ns] (beaver/build-nss api)
          :let [dir (io/file "src" beaver/out-ns (:name api))
                resource-name (name resource-name)]]
    (.mkdirs dir)
    (spit (io/file dir (str resource-name ".clj"))
          (ns-str resource-ns)))
  :done)

(defn fetch-and-write [{:keys [name version discoveryRestUrl]}]
  (println "Fetching" name version discoveryRestUrl)
  (some-> (or (raven/get-json discoveryRestUrl)
              (do (swap! discovery-failed& conj discoveryRestUrl)
                  (println "DISCOVERY FAILED:" discoveryRestUrl)))
          (write-api-nss)))

(comment
  (fetch-and-write {:discoveryRestUrl "https://spanner.googleapis.com/$discovery/rest?version=v1"}))

(defn report []
  ;; failed discoveries
  (println "Failed discoveries:" \newline
           (str/join \newline @discovery-failed&))

  ;; dead links
  (println "Dead links:" \newline
           (str/join \newline @raven/dead-link-cache&))

  ;; redirects
  (println "Redirects:" \newline
           (str/join \newline @raven/redirect-cache&))

  ;; unmatched patterns
  (println "Unmatched apis:" \newline
           (str/join \newline
                     (for [[k v] @raven/pattern-cache&
                           :when (= [:documentationLink] v)]
                       k)))

  ;; frequencies
  (println "Frequencies:")
  (println (str/join \newline (reverse (sort-by val (frequencies (vals @raven/pattern-cache&))))))

  ;; a table! or a chart?

  ;; disk cache??

  )

(comment
  (report))

(defn write-all []
  (run! fetch-and-write (vals monkey/apis))
  (report)
  :done)

(defn write-one [api-name]
  (some-> (get monkey/apis api-name)
          (fetch-and-write)))

(comment
  ;; spanner does not match because it has undocumented methods
  ;; TODO: should all method doc links be checked?
  (swap! raven/pattern-cache& dissoc "speech")
  (get monkey/apis "speech")
  (write-one "speech")

  )


(defn -main [& args]
  (write-all))
