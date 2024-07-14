(ns happyapi.deps.httpkit
  "Do not load compile or use this namespace directly,
  it is a target for happyapi.deps when resolving dependencies"
  (:require [org.httpkit.client :as client]
            [org.httpkit.server :as server]))

(defn request
  ([args] @(client/request args))
  ([args respond raise]
   (client/request args (fn callback [response]
                          ;; httpkit doesn't raise, it just puts errors in the response
                          (if (contains? response :error)
                            (raise (ex-info "ERROR in response"
                                            {:id   ::error-in-response
                                             :resp response}))
                            (respond response))))))

(defn run-server [handler config]
  (let [server (server/run-server handler (assoc config :legacy-return-value? false))]
    {:port (server/server-port server)
     :stop (fn [] (server/server-stop! server {:timeout 100}))}))
