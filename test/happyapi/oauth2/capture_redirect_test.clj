(ns happyapi.oauth2.capture-redirect-test
  (:require [clojure.test :refer [deftest is testing]]
            [happyapi.oauth2.capture-redirect :as capture-redirect]
            [happyapi.oauth2.auth :as auth]
            [clj-http.client :as http]))

(deftest wait-for-redirect-test
  (with-redefs [capture-redirect/browse-to-provider (fn [{:as config :keys [redirect_uri]} scopes optional]
                                                      (http/get (str redirect_uri "?code=CODE&state=" (:state optional))))
                auth/exchange-code (fn [request config code]
                                     (is (= "CODE" code))
                                     {:access_token "TOKEN"})]
    (is (= {:access_token "TOKEN"}
           (capture-redirect/fresh-credentials http/request
                                               {:auth_uri     "TEST"
                                                :client_id    "TEST"
                                                :redirect_uri "http://localhost"}
                                               []
                                               {})))
    (is (= {:access_token "TOKEN"}
           (capture-redirect/fresh-credentials http/request
                                               {:auth_uri     "TEST"
                                                :client_id    "TEST"
                                                :redirect_uri "http://localhost:8080/redirect"}
                                               []
                                               {})))
    (is (thrown? Throwable
                 (capture-redirect/fresh-credentials http/request
                                                     {:auth_uri     "TEST"
                                                      :client_id    "TEST"
                                                      :redirect_uri "http://not.localhost"}
                                                     []
                                                     {})))))
