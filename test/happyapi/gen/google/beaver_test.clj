(ns happyapi.gen.google.beaver-test
  (:require [clojure.test :refer [deftest is]]
            [happyapi.gen.google.beaver :as beaver]
            [happyapi.gen.google.raven :as raven]
            [meander.epsilon :as m]))

(def sheets-api (raven/get-json "https://sheets.googleapis.com/$discovery/rest?version=v4"))

(defmacro is-match? [x pattern]
  `(is (= (m/match ~x ~pattern 'test/match ~'_else ~x) 'test/match)))

(deftest method-name-test
  (is (= 'bar-baz-booz (beaver/method-sym {"id" "foo.bar.baz.booz"}))))

(deftest extract-method-test
  (let [method (beaver/extract-method
                 [sheets-api {"id"        "sheets.spreadsheet.method"
                              "path"     "path"
                              "parameters" {"spreadsheetId" {"required" true}
                                            "range"         {}}
                              "description" "description"
                              "scopes" ["scope"]
                              "httpMethod" "POST"}])]
    (is (list? method))
    (is-match? method (defn (m/pred symbol? ?fn-name) (m/pred string? ?doc-string) & _))))

(deftest build-nss-test
  (is (seq (beaver/build-api-ns sheets-api))))
