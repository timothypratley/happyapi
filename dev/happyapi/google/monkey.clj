(ns happyapi.google.monkey
  "Discovers Google API definitions."
  (:require [happyapi.google.raven :as raven]))

(def discovery-url "https://www.googleapis.com/discovery/v1/apis?preferred=true")

(defn list-apis'
  "Returns a vector of preferred APIs with their discovery URL."
  []
  (raven/get-json discovery-url))

(def list-apis (memoize list-apis'))

(defonce apis (-> (list-apis)
                  (->> (group-by :name))
                  (update-vals first)))

(comment
  (get apis "adexperiencereport"))
