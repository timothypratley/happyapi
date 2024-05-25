(ns happy.common)

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

(defn request-pages-async [http request respond raise items]
  (http request
        (fn [resp]
          (let [resp (update resp :items #(into items %))
                {:keys [nextPage items]} resp]
            (if nextPage
              (request-pages-async http (assoc-in request [:query-params :nextPage] nextPage) respond raise items)
              (respond resp))))
        raise))

(defn request-pages [http request]
  ;; TODO: these code paths should be identical, but doing so would *require* http to support async
  #_(let [p (promise)]
      (paging request
              (fn [x]
                (deliver p x))
              (fn [ex]
                (throw ex)))
      @p)

  (loop [page nil
         all-items []]
    (let [request (if page
                    (assoc-in request [:query-params :nextPage] page)
                    request)
          resp (http request)
          resp (update resp :items #(into all-items %))
          {:keys [nextPage items]} resp]
      (if nextPage
        (recur nextPage items)
        resp))))

;; TODO: should there be a way to stop looping? Maybe http itself could be pausable?
(defn wrap-paging [http]
  (fn paging
    ([request]
     (request-pages http request))
    ([request respond raise]
     (request-pages-async http request respond raise []))))
