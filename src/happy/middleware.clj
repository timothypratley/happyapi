(ns happy.middleware
  "Wrapping facilitates an abstract http-request rather than a specific implementation,
  and allows for configuration of cross-cutting concerns."
  (:require [clojure.string :as str]
            [happy.pluggable :as pluggable]))

(defn wrap-cookie-policy-standard [request]
  (fn
    ([args]
     (request (assoc args :cookie-policy :standard)))
    ([args respond raise]
     (request (assoc args :cookie-policy :standard) respond raise))))

(defn informative-exception [id ex args]
  (ex-info (str "Failed " (some-> (:method args) (name) (str/upper-case) (str " ")) (:url args)
                " " (ex-message ex))
           {:id   id
            :args args}
           ex))

(defn wrap-informative-exceptions [request]
  (fn
    ([args]
     (try
       (request args)
       (catch Exception ex
         (throw (informative-exception ::request-failed ex args)))))
    ([args respond raise]
     (request args respond
              (fn [ex]
                (raise (informative-exception ::request-failed-async ex args)))))))

(defn request-pages-async [request args respond raise items]
  (request args
           (fn [resp]
             (let [items (into items (get-in resp [:body :items]))
                   resp (assoc-in resp [:body :items] items)
                   {:keys [nextPage]} resp]
               (if nextPage
                 (request-pages-async request (assoc-in args [:query-params :nextPage] nextPage) respond raise items)
                 (respond resp))))
           raise))

(defn request-pages [request args]
  (loop [page nil
         items []]
    (let [resp (request (if page
                          (assoc-in args [:query-params :nextPage] page)
                          args))
          items (into items (get-in resp [:body :items]))
          resp (assoc-in resp [:body :items] items)
          {:keys [nextPage]} resp]
      (if nextPage
        (recur nextPage items)
        resp))))

;; TODO: should there be a way to stop looping? Maybe http itself could be pausable?
;; TODO: iteracts with wrap-deitemize ... badly
(defn wrap-paging
  "When fetching collections, will request all pages.
  This may take a long time.
  `wrap-paging` must come before `wrap-deitemize` when used together"
  [request]
  (fn paging
    ([args]
     (request-pages request args))
    ([args respond raise]
     (request-pages-async request args respond raise []))))

(defn wrap-json
  "Converts the body of responses to a data structure.
  Pluggable json implementations resolved from dependencies, or can be passed as an argument.
  Keywordization behaviour can be configured by passing a parse function.
  Error responses don't throw exceptions when parsing fails.
  Success responses that fail to parse are rethrown with the response and request as context."
  ([request] (wrap-json request pluggable/parse-json))
  ([request parse]
   (when-not parse
     (throw (ex-info "JSON parsing dependency not found"
                     {:id ::json-dependency-not-found})))
   (fn
     ([args]
      (let [resp (request args)]
        (if (contains? resp :body)
          (try
            (update resp :body parse)
            (catch Throwable ex
              (if (pluggable/success? resp)
                (throw (ex-info "Failed to parse response body"
                                {:id       ::parse-json-failed
                                 :response resp
                                 :request  args}
                                ex))
                resp)))
          resp)))
     ([args respond raise]
      (request args
               (fn [resp]
                 (if (contains? resp :body)
                   (try
                     (-> (update resp :body parse)
                         (respond))
                     (catch Throwable ex
                       (if (pluggable/success? resp)
                         (raise (ex-info "Failed to parse response body async"
                                         {:id       ::parse-json-failed-async
                                          :response resp
                                          :request  args}
                                         ex))
                         (respond resp))))
                   (respond resp)))
               raise)))))

;; TODO: unroll :items as vectors

;; TODO: establish whether recursive is necessary, and whether top level body/status should be used
;; TODO: this implementation throws away the non-body response, maybe that's ok but maybe the name isn't
(defn deitemize [{:keys [body]}]
  (if (and (map? body) (contains? body :items))
    (:items body)
    body))

(defn wrap-deitemize [request]
  (fn
    ([args]
     (deitemize (request args)))
    ([args respond raise]
     (request args
              (fn [resp]
                (respond (deitemize resp)))
              raise))))

(defn uri-from-template [{:as args :keys [uri-template uri-template-args]}]
  (assoc args :url (pluggable/uri-template uri-template uri-template-args)))

(defn wrap-uri-template [request]
  (fn
    ([args] (request (uri-from-template args)))
    ([args respond raise] (request (uri-from-template args) respond raise))))

;; TODO: what about retries? (note that most clients automatically retry some stuff)
;; just recommend another library (like again)?
#_(defn try-n-times [f n]
  (if (zero? n)
    (f)
    (try
      (f)
      (catch Throwable _
        (if (retryable?)
          (try-n-times f (dec n))
          ...
          )))))

#_(defn wrap-retry [request]
  (fn request*
    ([args]
     (try-n-times #(request args) 3))
    ([args respond raise]
     (request args respond (fn [ex]
                             (if (retryable?)
                               ;; TODO: is *?
                               (request* args respond raise)
                               (raise)))))))

;; TODO: paging should save progress? or is it ok with informative exceptions?

;; TODO: metering? Seeing as this is a pass through wrapper, just recommend that library right?!

#_(defn wrap-throttle [request]
  (pluggable/throttle-fn request 100 :second))
