(ns happyapi.deps-test
  (:require [clojure.test :refer [deftest is]]
            [com.grzm.uri-template :as uri-template]
            [happyapi.deps :as deps]))

(deftest dependencies-resolved-test
  (is (deps/choose [:httpkit :jsonista]))
  (is (deps/present))
  (is (deps/possible))
  (is (thrown? Exception (deps/choose [:bad-key]))))

(deftest get-url-test
  (is (= "BASE/a/B/c"
         (uri-template/expand "BASE/a/{b}/c" {:b "B"})))
  (is (= "BASE/a/B/c"
         (uri-template/expand "BASE/a/{+b}/c" {:b "B"}))))
