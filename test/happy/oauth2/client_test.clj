(ns happy.oauth2.client-test
  (:require [clojure.test :refer [deftest is]]
            [happy.oauth2.client :as client]
            [happy.oauth2.credentials :as credentials]
            [clj-http.client :as clj-http]
            [org.httpkit.client :as httpkit]))

(deftest auth2-test
  (let [config (credentials/read-secret)
        clj-http (client/wrap-api clj-http/request config)
        kit-http (client/wrap-api (comp deref httpkit/request) config)
        req {:method       :get
             :url          "https://openidconnect.googleapis.com/v1/userinfo"
             :scopes       ["https://www.googleapis.com/auth/userinfo.email"]
             :query-params {}}
        resp1 (clj-http req)
        _ (is (get-in resp1 [:body :email]))
        resp2 (kit-http req)
        _ (is (get-in resp2 [:body :email]))]))
