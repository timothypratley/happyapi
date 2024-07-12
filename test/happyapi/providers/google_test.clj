(ns happyapi.providers.google-test
  (:require [clojure.test :refer :all]
            [happyapi.providers.google :as google]))

(deftest api-request-test
  (google/setup! (slurp "secret.json"))
  (google/api-request {:uri "https://youtube.googleapis.com/youtube/v3/channels"
                       :query-params {:part "contentDetails,statistics"
                                      :forUsername "ClojureTV"}
                       :scopes ["https://www.googleapis.com/auth/youtube.readonly"]}))
