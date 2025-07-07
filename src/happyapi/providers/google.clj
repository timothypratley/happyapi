(ns happyapi.providers.google
  "The happyapi.providers.google namespace contains convenience helpers
  to make getting started with happyapi easier.

  You can absolutely go without them and directly use
  `setup/make-client`, if it better suits your use case."
  (:require [happyapi.setup :as setup]))

; At any time, the api-request var contains the currently configured
; google client function.
(declare api-request)

(defn set-request! [client]
  (alter-var-root #'api-request (constantly client)))

(defn setup!
  "Changes the `api-request` to be a configured client.
  The config is provider specific. It should contain `:client_id` and
  `:client_secret` for OAuth2, or `:apikey`.  See `setup/make-client`
  for more options."
  [config] (set-request! (setup/make-client (when config {:google config}) :google)))

(defn api-request
  "The default definition of the `api-request` var.

  `api-request` is meant to be overridden by a real implementation.
  The simplest way is calling `setup!`. This default definition is
  just a convenience helper.

  It will attempt to configure itself by calling `setup!`, if
  `api-request` is not already configured.
  
  If your requirements are more complex, you may want to call
  `setup/make-client` directly or create your own client from scratch.

  Since the generated functions from `happyapi.google` just create
  requests-as-data, you can also work completely without the global
  `happyapi.providers.google/api-request` function and use your client
  function directly. Depending on your use case you will even have to
  -- e.g. when you need multiple different google API clients
  simultaneously."
  ([args]
   (setup! nil)
   (api-request args))
  ([args respond raise]
   (try
     (setup! nil)
     (api-request args respond raise)
     (catch Throwable ex
       (raise ex)))))
