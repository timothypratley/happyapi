(ns happyapi.gen.google.lion-test
  (:require [clojure.test :refer [deftest is]]
            [happyapi.gen.google.lion :as lion]))

(deftest pprint-str-test
  (is (= "[1 2 3]\n" (lion/pprint-str [1 2 3]))))

(deftest ns-str-test
  (is (= "foo\n\n\"a\nb\nc\"\n\nbar\n\nbaz\n" (lion/ns-str '(foo "a\nb\nc" bar baz)))))
