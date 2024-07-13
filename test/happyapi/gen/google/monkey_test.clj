(ns happyapi.google.monkey-test
  (:require [clojure.test :refer [deftest testing is]]
            [happyapi.google.monkey :as monkey]
            [happyapi.google.raven :as raven]))

(deftest fetch-test
  (let [api (raven/get-json "https://sheets.googleapis.com/$discovery/rest?version=v4")]
    (is (map? api) "should deserialize")
    (is (seq api) "should contain definition")))

(deftest list-apis-test
  (let [api-list (monkey/list-apis)]
    (is (<= 100 (count api-list) 500)
        "should find a good number of Google APIs")))
