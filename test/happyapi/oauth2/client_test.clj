(ns happyapi.oauth2.client-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.walk :as walk]
            [happyapi.oauth2.client :as client]
            [happyapi.deps :as deps]))

(deftest auth2-test
  (let [{:keys [decode]} (deps/require-dep :cheshire)
        ;; TODO: bleh, just make a test function
        config (:web (walk/keywordize-keys (decode (slurp "secret.json"))))
        ;; TODO: make all combos? or just check they all work
        clj-request (client/make-client (assoc config :fns (deps/choose [:clj-http :cheshire])))
        kit-request (client/make-client (assoc config :fns (deps/choose [:httpkit :cheshire])))
        req {:method       :get
             :url          "https://openidconnect.googleapis.com/v1/userinfo"
             :scopes       ["https://www.googleapis.com/auth/userinfo.email"]
             :query-params {}}
        resp1 (clj-request req)
        _ (is (get-in resp1 [:email]))
        resp2 (kit-request req)
        _ (is (get-in resp2 [:email]))]))
