(ns happy.common.middleware)

;; TODO: not happy with the ns name

(defn success?
  [{:keys [status]}]
  (<= 200 status 299))

(defn wrap-cookie-policy-standard [http]
  (fn
    ([request]
     (http (assoc request :cookie-policy :standard)))
    ([request respond raise]
     (http (assoc request :cookie-policy :standard) respond raise))))

(defn wrap-report-url-exceptions [http]
  (fn
    ([request]
     (try
       (http request)
       (catch Exception ex
         (throw (ex-info (str "FAILED: " (:method request) " " (:url request))
                         {:id      ::request-exception
                          :request request}
                         ex)))))
    ([request respond raise]
     (http request respond
           (fn [ex]
             (raise (ex-info (str "FAILED: " (:method request) " " (:url request))
                             {:id      ::request-exception
                              :request request}
                             ex)))))))

(defn wrap-exception-handler [http on-error]
  (fn
    ([request]
     (try
       (http request)
       (catch Exception ex
         (on-error ex))))
    ([request respond raise]
     ;; TODO: does this make sense?? why not just pass a better raise?
     (http request respond (fn [ex]
                             (on-error ex)
                             (raise ex))))))

(defn wrap-json [http]
  (fn
    ([request]
     (let [response (http (assoc request :accept :json :as :json))]
       (when (success? response)
         (:body response))))
    ([request respond raise]
     (http (assoc request :accept :json :as :json)
           (fn [x]
             (respond (when (success? x) x)))
           raise))))
