(ns happyapi.oauth2.client-test
  (:require [clojure.edn :as edn]
            [clojure.test :refer [deftest is]]
            [clojure.walk :as walk]
            [happyapi.oauth2.client :as client]
            [happyapi.deps :as deps]))

(deftest auth2-test
  (let [config (-> (edn/read-string (slurp "happyapi.edn"))
                   (:google)
                   (assoc :provider :google))
        clj-request (client/make-client (assoc config :fns (deps/choose [:clj-http :jetty :cheshire])))
        kit-request (client/make-client (assoc config :fns (deps/choose [:httpkit :cheshire])))
        req {:method       :get
             :url          "https://openidconnect.googleapis.com/v1/userinfo"
             :scopes       ["https://www.googleapis.com/auth/userinfo.email"]
             :query-params {}}
        resp1 (clj-request req)
        _ (is (get-in resp1 ["email"]))
        resp2 (kit-request req)
        _ (is (get-in resp2 ["email"]))]))
