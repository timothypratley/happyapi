(ns happyapi.providers.twitter-test
  (:require [clojure.edn :as edn]
            [clojure.test :refer :all]
            [happyapi.providers.twitter :as twitter]))

;; TODO: tokens are provider specific!


(deftest api-request-test
  (twitter/setup! (edn/read-string (slurp "happyapi.edn")))
  (twitter/api-request {:method :get
                        :url    "https://api.twitter.com/2/users/me"})
  (twitter/api-request {:method :delete
                        :url    "https://api.twitter.com/2/tweets/1811986925798195513"
                        :scopes ["tweet.read" "tweet.write" "users.read"]})
  ;; let's not post every time I run the tests...
  #_(twitter/api-request {:method :post
                        :url    "https://api.twitter.com/2/tweets"
                        :scopes ["tweet.read" "tweet.write" "users.read"]
                        :body   {:text "This is a test tweet from HappyAPI"}}))
