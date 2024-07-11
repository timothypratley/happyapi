(ns happyapi.providers.twitter
  (:require [happyapi.setup :as setup]))

(declare api-request)

(defn set-request! [client]
  (alter-var-root #'api-request (constantly client)))

(defn setup!
  "Changes `api-request` to be a configured client.
  config should contain `:client_id` and `:client_secret` for oauth2,
  or `:apikey`.
  config may be a map or json string, see config/make-client."
  [config] (set-request! (setup/make-client config :twitter)))

(defn api-request
  "A function to handle API requests.
  Can be configured with `setup!`.
  Will attempt to configure itself if not previously configured.
  May also be replaced by a custom stack of middleware constructed in a different way.
  This is what generated code invokes, which means that customizations here
  will be present in the generated interface."
  ([args]
   (setup! nil)
   (api-request args))
  ([args respond raise]
   (try
     (setup! nil)
     (api-request args respond raise)
     (catch Throwable ex
       (raise ex)))))
