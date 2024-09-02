(ns happyapi.providers.github-test
  (:require [clojure.test :refer :all]
            [happyapi.providers.github :as github]))

(deftest api-request-test
  (github/setup! nil)
  (is (-> (github/*api-request* {:method :get
                               :url      "https://api.github.com/user"
                               :scopes   ["user" "user:email"]})
          (get "email"))))
