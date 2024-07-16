(ns happyapi.middleware-test
  (:require [clojure.test :refer [deftest is]]
            [happyapi.middleware :as middleware]
            [happyapi.deps :as deps]))

(deftest success?-test
  (is (middleware/success? {:status 200})))

(defn raise [ex]
  (throw ex))

(deftest wrap-uri-template-test
  (let [request (-> (fn
                      ([args]
                       (is (= (:url args) "fooBARbaz")))
                      ([args respond raise]
                       (is (= (:url args) "fooBARbaz"))))
                    (middleware/wrap-uri-template))
        args {:uri-template      "foo{bar}baz"
              :uri-template-args {:bar "BAR"}}]
    (request args)
    (request args (fn [resp]) raise)))

(deftest wrap-deitemize-test
  (let [request (-> (fn
                      ([args]
                       {:status 200
                        :body   {"items" [1 2 3]}})
                      ([args respond raise]
                       (respond {:status 200
                                 :body   {"items" [4 5 6]}})))
                    (middleware/wrap-extract-result))]
    (is (= (request {}) [1 2 3]))
    (request {}
             (fn [resp]
               (is (= resp [4 5 6])))
             raise)))

(deftest wrap-json-test
  (let [request-stub (fn
                       ([args]
                        {:status  200
                         :headers {:content-type "application/json"}
                         :body    "{\"json\": 1, \"edn\": 0}"})
                       ([args respond raise]
                        (respond {:status  200
                                  :headers {:content-type "application/json"}
                                  :body    "{\"sync\": 1, \"async\": 0}"})))
        json (deps/require-dep :cheshire)
        request (middleware/wrap-json request-stub {:fns json})
        request-keywordized (-> (middleware/wrap-json request-stub {:fns json})
                                (middleware/wrap-keywordize-keys true))]
    (is (= (:body (request {}))
           {"json" 1
            "edn"  0}))
    (is (= (:body (request-keywordized {}))
           {:json 1
            :edn  0}))
    (request {}
             (fn [resp]
               (is (= (:body resp) {"sync"  1
                                    "async" 0})))
             raise)
    (request-keywordized {}
                         (fn [resp]
                           (is (= (:body resp) {:sync  1
                                                :async 0})))
                         raise)))

(deftest wrap-paging-test
  (let [responses [[1 2 3]
                   [4 5 6]
                   [7 8 9]
                   [10 11 12]]
        counter (atom -1)
        request (-> (fn
                      ([args]
                       (let [c (swap! counter inc)]
                         {:status 200
                          :body   {"items"         (get responses c)
                                   "nextPageToken" (when (= c 0)
                                                     "page2")}}))
                      ([args respond raise]
                       (let [c (swap! counter inc)]
                         (respond {:status 200
                                   :body   {"items"         (get responses c)
                                            "nextPageToken" (when (= c 2)
                                                              "page4")}}))))
                    (middleware/wrap-paging)
                    (middleware/wrap-extract-result))]
    (is (= (request {}) [1 2 3 4 5 6]))
    (request {}
             (fn [resp]
               (is (= resp [7 8 9 10 11 12])))
             raise)))

(deftest wrap-informative-exceptions-test
  (let [request (-> (deps/choose [:clj-http :cheshire])
                    (:request)
                    (middleware/wrap-informative-exceptions))]
    (is (thrown? Exception (request {:method :get :url "bad-url.not.a/oh-no"})))
    (is (thrown? Exception (request {:method :get :url "https://bad-url.not.au/oh-no"})))))
