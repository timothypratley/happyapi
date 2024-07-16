(ns happyapi.apikey.client
  (:require [happyapi.middleware :as middleware]))

(defn make-client
  "Given a config map

  {:apikey           <string>
   :fns              {#{:request :query-string :encode :decode} <fn-or-var>}
   :keywordize-keys  <boolean>}

  returns a wrapped request function."
  [{:as                     config
    :keys                   [apikey keywordize-keys]
    {:keys [request]} :fns}]
  (when-not (middleware/fn-or-var? request)
    (throw (ex-info "request must be a function or var"
                    {:id      ::request-must-be-a-function
                     :request request
                     :config  config})))
  (-> request
      (middleware/wrap-cookie-policy-standard)
      (middleware/wrap-informative-exceptions)
      (middleware/wrap-json config)
      (middleware/wrap-apikey-auth apikey)
      (middleware/wrap-uri-template)
      (middleware/wrap-paging)
      (middleware/wrap-extract-result)
      (middleware/wrap-keywordize-keys keywordize-keys)))
