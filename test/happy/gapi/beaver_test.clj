(ns happy.gapi.beaver-test
  (:require [clojure.test :refer [deftest testing is]]
            [happy.gapi.beaver :as beaver]
            [happy.gapi.raven :as raven]
            [meander.epsilon :as m]))

(def sheets-api (raven/get-json "https://sheets.googleapis.com/$discovery/rest?version=v4"))
(def spreadsheets-resource (-> sheets-api :resources :spreadsheets))

(defmacro is-match? [x pattern]
  `(is (= (m/match ~x ~pattern 'test/match ~'_else ~x) 'test/match)))

(deftest method-name-test
  (is (= 'bar-baz-booz (beaver/method-sym "foo.bar.baz.booz"))))

(deftest extract-method-test
  (let [method (beaver/extract-method
                 [sheets-api {:id          "sheets.spreadsheet.method"
                              :path        "path"
                              :parameters  {:spreadsheetId {:required true}
                                            :range         {}}
                              :description "description"
                              :scopes      ["scope"]
                              :httpMethod  "POST"}])]
    (is (list? method))
    (is-match? method (defn (m/pred symbol? ?fn-name) (m/pred string? ?doc-string) & _))))

(deftest extract-resource-methods-test
  (let [n-methods (count (beaver/extract-resource-methods [sheets-api spreadsheets-resource]))]
    (is (<= 17 n-methods 20))))

(deftest build-nss-test
  (is (seq (beaver/build-api-ns sheets-api))))
