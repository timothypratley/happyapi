(ns happyapi.providers.github-test
  (:require [clojure.edn :as edn]
            [clojure.test :refer :all]
            [happyapi.providers.github :as github]))

(deftest api-request-test
  (github/setup! (edn/read-string (slurp "happyapi.edn")))
  (github/api-request {:method       :get
                       :url          "https://api.github.com/user"
                       :scopes       ["user" "user:email"]}))
