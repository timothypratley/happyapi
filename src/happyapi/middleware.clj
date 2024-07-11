(ns happyapi.middleware
  "Wrapping facilitates an abstract http-request rather than a specific implementation,
  and allows for configuration of cross-cutting concerns."
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [com.grzm.uri-template :as uri-template]))

(defn success?
  [{:keys [status]}]
  (and (number? status)
       (<= 200 status 299)))

(defn fn-or-var?
  [f]
  (or (fn? f) (var? f)))

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

;; TODO: when http clients throw, do they include the response?
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
                   nextPageToken (get-in resp [:body :nextPageToken])]
               (if nextPageToken
                 (request-pages-async request (assoc-in args [:query-params :pageToken] nextPageToken) respond raise items)
                 (respond resp))))
           raise))

(defn request-pages [request args]
  (loop [page nil
         items []]
    (let [args (if page
                 (assoc-in args [:query-params :pageToken] page)
                 args)
          resp (request args)
          items (into items (get-in resp [:body :items]))
          resp (assoc-in resp [:body :items] items)
          nextPageToken (get-in resp [:body :nextPageToken])]
      (if nextPageToken
        (if (= page nextPageToken)
          (throw (ex-info "nextPageToken did not change while paging"
                          {:id            ::invalid-nextPageToken
                           :nextPageToken nextPageToken}))
          (recur nextPageToken items))
        resp))))

;; TODO: should there be a way to monitor progress and perhaps stop looping?
;; TODO: would it be interesting to provide a lazy iteration version? probably not, seems like a bad idea
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

(defn maybe-update [args k f & more]
  (if (contains? args k)
    (apply update args k f more)
    args))

(defn keywordize-body [resp]
  (maybe-update resp :body walk/keywordize-keys))

(defn wrap-keywordize-keys [request]
  (fn
    ([args]
     (keywordize-body (request args)))
    ([args respond raise]
     (request args (comp respond keywordize-body) raise))))

(defn wrap-json
  "Converts the body of responses to a data structure.
  Pluggable json implementations resolved from dependencies, or can be passed as an argument.
  Keywordization defaults to true if not specified.
  Keywordization can be disabled with :keywordize-keys false.\n

  Error responses don't throw exceptions when parsing fails.
  Success responses that fail to parse are rethrown with the response and request as context."
  [request {:as                     config
            :keys                   [keywordize-keys]
            :or                     {keywordize-keys true}
            {:keys [encode decode]} :fns}]
  (when-not (and (fn-or-var? encode)
                 (fn-or-var? decode))
    (throw (ex-info "JSON dependency invalid"
                    {:id     ::json-dependency-invalid
                     :encode encode
                     :decode decode
                     :config config})))
  (cond->
    (fn
      ([args]
       (let [args (maybe-update args :body encode)
             resp (request args)]
         (try
           (maybe-update resp :body decode)
           (catch Throwable ex
             (if (success? resp)
               (throw (ex-info "Failed to json decode the body of a successful response"
                               {:id       ::parse-json-failed
                                :response resp
                                :args     args}
                               ex))
               ;; errors often have non-json bodies, presumably users want to handle those if we got here
               resp)))))
      ([args respond raise]
       (request (maybe-update args :body encode)
                (fn [resp]
                  (try
                    (-> (maybe-update resp :body decode)
                        (respond))
                    (catch Throwable ex
                      (if (success? resp)
                        (raise (ex-info "Failed to json decode the body of a successful async response"
                                        {:id       ::parse-json-failed-async
                                         :response resp
                                         :args     args}
                                        ex))
                        ;; errors often have non-json bodies, presumably users want to handle those if we got here
                        (respond resp)))))
                raise)))
    keywordize-keys (wrap-keywordize-keys)))

;; TODO: surely there are other cases to consider?
(defn extract-result [{:keys [body]}]
  (cond (and (map? body) (seq (get body :items))) (get body :items)
        (and (map? body) (seq (get body "items"))) (get body "items")
        :else body))

(defn wrap-extract-result
  "When we call an API, we want the logical result of the call, not the map containing body, and status.
  We also don't need to preserve the type of arrays, so we can remove that layer of indirection (:items is unnecessary).
  When using this middleware, you should also use a client or middleware that throws when status indicates failure,
  to prevent logical results when there is an error."
  [request]
  (fn
    ([args]
     (extract-result (request args)))
    ([args respond raise]
     (request args
              (fn [resp]
                (respond (extract-result resp)))
              raise))))

(defn uri-from-template [{:as args :keys [uri-template uri-template-args]}]
  (if uri-template
    (assoc args :url (uri-template/expand uri-template uri-template-args))
    args))

(defn wrap-uri-template
  "Arguments to APIs may appear in the url path, query-string, or body of a request.
  This middleware assists with the correct application of path arguments.
  When :uri-template is present, it adds :url which is the application of the template with :uri-template-args.
  See https://datatracker.ietf.org/doc/html/rfc6570 for more information about uri-templates."
  [request]
  (fn
    ([args] (request (uri-from-template args)))
    ([args respond raise] (request (uri-from-template args) respond raise))))

;; TODO: paging should save progress? or is it ok with informative exceptions?
;; TODO: metering? Seeing as this is a pass through wrapper, just recommend that library right?!

(defn auth-header
  "Given credentials, returns a header suitable for merging into a request."
  [args bearer]
  (merge-with merge args {:headers {"Authorization" (str "Bearer " bearer)}}))

(defn wrap-apikey-auth [request apikey]
  {:pre [(string? apikey)]}
  (fn
    ([args]
     (request (auth-header args apikey)))
    ([args respond raise]
     (request (auth-header args apikey) respond raise))))
