(ns happy.oauth2.middleware)

(defn wrap-oauth2
  "Special keys: user and scopes"
  [http config]
  (fn
    ([request]
     (oauth2 http request config))
    ([request respond raise]
     (oauth2-async http request respond raise config))))
