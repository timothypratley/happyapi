(ns happy.gapi.core)


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
