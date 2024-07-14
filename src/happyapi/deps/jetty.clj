(ns happyapi.deps.jetty
  "Do not load compile or use this namespace directly,
  it is a target for happyapi.deps when resolving dependencies"
  (:require [ring.adapter.jetty :as jetty])
  (:import (org.eclipse.jetty.server NetworkConnector Server)))

(set! *warn-on-reflection* true)

(defn get-port [^Server server]
  (-> server .getConnectors ^NetworkConnector first .getLocalPort))

(defn run-server [handler config]
  (let [server (jetty/run-jetty handler (assoc config :join? false))]
    (.setStopTimeout server 100)
    {:port (get-port server)
     :stop (fn stop-jetty []
             (.stop server))}))
