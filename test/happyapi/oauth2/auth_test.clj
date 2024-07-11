(ns happyapi.oauth2.auth-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.walk :as walk]
            [happyapi.middleware :as middleware]
            [happyapi.oauth2.auth :as auth]
            [happyapi.oauth2.capture-redirect :as capture-redirect]
            [happyapi.oauth2.credentials :as credentials]
            [happyapi.deps :as deps]))

;; To run the tests you need to download `secret.json` from the Google console.
;; this is an annoying test because it revokes, forcing you to login in again.
(deftest refresh-and-revoke-test
  (let [{:as deps :keys [request decode]} (deps/choose [:clj-http :cheshire])
        request (middleware/wrap-json request {:fns deps})
        ;; TODO: maybe its a function?
        config (:web (walk/keywordize-keys (decode (slurp "secret.json"))))
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
        (and
          (is credentials)
          (is (middleware/success? (auth/revoke-token request config credentials)))
          (credentials/delete-credentials "user"))))))
