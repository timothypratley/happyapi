(ns happyapi.oauth2.credentials
  "Reference for how to manage credentials.
  For a web app, you should implement something like this but use your database for credential storage.
  secret, scopes, fetch, save have default implementations that you can replace with init!"
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(set! *warn-on-reflection* true)

;; TODO: Nope, this needs to be provider specific (at least!)

(def *credentials-cache
  (atom nil))

;; TODO: provider is required now...
(defn read-credentials [provider user]
  (or (get-in @*credentials-cache [provider user])
      (let [credentials-file (io/file "tokens" provider (str user ".edn"))]
        (when (.exists credentials-file)
          (edn/read-string (slurp credentials-file))))))

(defn delete-credentials [provider user]
  (swap! *credentials-cache update provider dissoc user)
  (.delete (io/file (io/file provider "tokens")
                    (str user ".edn"))))

(defn write-credentials [provider user credentials]
  (swap! *credentials-cache assoc-in [provider user] credentials)
  (spit (io/file (doto (io/file provider "tokens") (.mkdirs))
                 (str user ".edn"))
        credentials))

(defn save-credentials [provider user new-credentials]
  (when (not= (get-in @*credentials-cache [provider user]) new-credentials)
    (if new-credentials
      (write-credentials provider user new-credentials)
      (delete-credentials provider user))))
