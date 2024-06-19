(ns happy.oauth2.auth-test
  (:require [clojure.test :refer [deftest is]]
            [happy.middleware :as middleware]
            [happy.oauth2.auth :as auth]
            [happy.oauth2.capture-redirect :as capture-redirect]
            [happy.oauth2.credentials :as credentials]
            [happy.pluggable :as pluggable]))

(def request (middleware/wrap-json pluggable/http-request))

;; To run the tests you need to download `secret.json` from the Google console.
(deftest refresh-test
  (let [config (credentials/read-secret)
        credentials (credentials/read-credentials "user")
        scopes ["https://www.googleapis.com/auth/userinfo.email"]
        credentials (capture-redirect/update-credentials request config credentials scopes)]
    (credentials/save-credentials "user" credentials)
    (and
      (is credentials)
      (is (auth/refreshable? config credentials))
      (let [credentials (merge (auth/refresh-credentials request config scopes credentials)
                               credentials)]
        (credentials/save-credentials "user" credentials)
        credentials))))

(deftest revoke-test
  (let [credentials (credentials/read-credentials "user")
        config (credentials/read-secret)]
    (and
      (is credentials)
      (is (pluggable/success? (auth/revoke-token request config credentials)))
      (credentials/delete-credentials "user"))))
