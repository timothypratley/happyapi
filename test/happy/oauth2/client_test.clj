(ns happy.oauth2.client-test
  (:require [clojure.test :refer [deftest is]]
            [happy.oauth2.client :as client]
            [happy.oauth2.credentials :as credentials]
            [clj-http.client :as clj-http]
            [org.httpkit.client :as httpkit]))

(deftest auth2-test
  (let [config (credentials/read-secret)
        clj-request (client/wrap-api clj-http/request config)
        kit-request (client/wrap-api (comp deref httpkit/request) config)
        req {:method       :get
             :url          "https://openidconnect.googleapis.com/v1/userinfo"
             :scopes       ["https://www.googleapis.com/auth/userinfo.email"]
             :query-params {}}
        resp1 (clj-request req)
        _ (is (get-in resp1 [:email]))
        resp2 (kit-request req)
        _ (is (get-in resp2 [:email]))]))
