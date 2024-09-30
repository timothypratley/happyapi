(ns happyapi.providers.twitter-test
  (:require [clojure.test :refer :all]
            [happyapi.providers.twitter :as twitter]))

(deftest api-request-test
  (twitter/setup! nil)
  (is (-> (twitter/api-request {:method  :get
                                   :url    "https://api.twitter.com/2/users/me"
                                   :scopes ["tweet.read" "tweet.write" "users.read"]})
          (get "username")))
  (is (-> (twitter/api-request {:method :delete
                                :url      "https://api.twitter.com/2/tweets/1811986925798195513"
                                :scopes   ["tweet.read" "tweet.write" "users.read"]})
          (get "deleted")))
  ;; let's not post every time I run the tests...
  #_(twitter/api-request {:method :post
                          :url      "https://api.twitter.com/2/tweets"
                          :scopes   ["tweet.read" "tweet.write" "users.read"]
                          :body     {:text "This is a test tweet from HappyAPI"}}))
