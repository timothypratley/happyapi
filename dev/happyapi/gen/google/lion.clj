(ns happyapi.gen.google.lion
  "Writes to src/happygapi generated namespaces of function wrappers"
  (:require [clojure.edn :as edn]
            [happyapi.gen.google.beaver :as beaver]
            [happyapi.gen.google.monkey :as monkey]
            [happyapi.gen.google.raven :as raven]
            [clojure.java.io :as io]
            [clojure.pprint :as pprint]
            [clojure.string :as str]))

(def discovery-failed& (atom #{}))

(defn pprint-str [x]
  (-> (pprint/pprint x)
      (->> (pprint/with-pprint-dispatch pprint/code-dispatch))
      (with-out-str)
      ;; docstrings shouldn't be escaped
      (str/replace "\\n" "\n")))

(defn ns-str [forms]
  (str/join \newline (map pprint-str forms)))

(defn fetch-and-write [{:strs [name version discoveryRestUrl idx]}]
  (try
    ;; if we have it already just use it.
    (println (str "Building" (when idx (str " " idx " of " (count monkey/apis)))) name)
    (let [target (io/file beaver/out-dir (str name "_" version ".clj"))
          api-file (io/file beaver/resource-dir (str name "_" version ".edn"))
          api (if (.exists api-file)
                (edn/read-string (slurp api-file))
                (doto (raven/get-json discoveryRestUrl)
                  (->> (pr-str) (spit api-file))))]
      (->> (beaver/build-api-ns api)
           (ns-str)
           (spit target))
      (println "Wrote" (str target))
      :done)
    (catch Exception ex
      (swap! discovery-failed& conj discoveryRestUrl)
      (println (ex-message ex))
      (println "To retry/resume, use" (pr-str `(write-one ~name)) "or" (pr-str `(write-all ~name)))
      ex)))

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

(defn write-all
  "Pass an api name to resume generation at a failure"
  ([] (write-all nil))
  ([start]
   (.mkdirs beaver/out-dir)
   (.mkdirs beaver/resource-dir)
   (let [apis (->> (vals monkey/apis)
                   (sort-by #(get % "name"))
                   (map-indexed (fn [idx api]
                                  (assoc api "idx" idx))))
         remaining (cond->> apis
                            start (drop-while #(not= start (get % "name"))))]
     (run! fetch-and-write remaining))
   (report)
   :done))

(defn write-one [api-name]
  (some-> (get monkey/apis api-name)
          (fetch-and-write)))

(comment
  ;; spanner does not match because it has undocumented methods
  ;; TODO: should all method doc links be checked?
  (swap! raven/pattern-cache& dissoc "speech")
  (get monkey/apis "speech")
  (write-one "speech")
  (write-one "datalineage")
  ;; TODO: poly is no more
  (write-all "poly")
  (write-one "youtube"))

(defn -main [& args]
  (write-all))
