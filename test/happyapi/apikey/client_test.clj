(ns happyapi.apikey.client-test
  (:require [clojure.edn :as edn]
            [clojure.test :refer :all]
            [happyapi.apikey.client :as client]
            [happyapi.deps :as deps]))

(deftest make-client-test
  (let [config (-> (edn/read-string (slurp "happyapi.edn"))
                   (:google)
                   (select-keys [:apikey])
                   (assoc :provider :google))
        kit-request (client/make-client (assoc config :fns (deps/choose [:httpkit :cheshire])))
        req {:method       :get
             :url          "https://youtube.googleapis.com/youtube/v3/channels"
             :query-params {:part        "contentDetails,statistics"
                            :forUsername "ClojureTV"}}
        resp (kit-request req)
        [{:strs [kind]}]  resp]
    (is (= kind "youtube#channel"))))
