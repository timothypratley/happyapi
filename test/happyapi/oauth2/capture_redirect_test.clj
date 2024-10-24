(ns happyapi.oauth2.capture-redirect-test
  (:require [clojure.test :refer [deftest is testing]]
            [clojure.string :as str]
            [happyapi.deps :as deps]
            [happyapi.oauth2.capture-redirect :as capture-redirect]
            [happyapi.oauth2.auth :as auth]
            [clj-http.client :as http]))

(deftest wait-for-redirect-test
  (with-redefs [capture-redirect/browse-to-provider (fn browse-to-provider [{:as config :keys [redirect_uri]} scopes optional]
                                                      (http/get (str (str/replace redirect_uri "https" "http")
                                                                     "?code=CODE&state=" (:state optional))))
                auth/exchange-code (fn exhange-code [request config code challenge]
                                     (is (= "CODE" code))
                                     {:access_token "TOKEN"})]
    (let [config {:auth_uri     "TEST"
                  :client_id    "TEST"
                  :redirect_uri "http://localhost"
                  :fns          (deps/require-dep :httpkit)}]
      (is (= {:access_token "TOKEN"}
             (capture-redirect/fresh-credentials http/request
                                                 (assoc config :redirect_uri "http://localhost")
                                                 [])))
      (is (= {:access_token "TOKEN"}
             (capture-redirect/fresh-credentials http/request
                                                 (assoc config :redirect_uri "http://127.0.0.1")
                                                 [])))
      (is (= {:access_token "TOKEN"}
             (capture-redirect/fresh-credentials http/request
                                                 (assoc config :redirect_uri "https://localhost")
                                                 [])))
      (is (= {:access_token "TOKEN"}
             (capture-redirect/fresh-credentials http/request
                                                 (assoc config :redirect_uri "http://localhost:8080/redirect")
                                                 [])))
      (is (thrown? Throwable
                   (capture-redirect/fresh-credentials http/request
                                                       (assoc config :redirect_uri "http://not.localhost")
                                                       []))))))
