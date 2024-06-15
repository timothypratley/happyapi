(ns happy.pluggable-test
  (:require [clojure.test :refer [deftest is]]
            [happy.pluggable :as pluggable]))

(deftest success?-test
  (is (pluggable/success? {:status 200})))

(deftest dependencies-resolved-test
  (is (fn? pluggable/http-request))
  (is (fn? pluggable/parse-json))
  (is (fn? pluggable/query-string))
  (is (fn? pluggable/uri-template)))

(deftest get-url-test
  (is (= "BASE/a/B/c"
         (pluggable/uri-template "BASE/a/{b}/c" {:b "B"})))
  (is (= "BASE/a/B/c"
         (pluggable/uri-template "BASE/a/{+b}/c" {:b "B"}))))
