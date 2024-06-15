(ns happy.oauth2.credentials
  "Reference for how to manage credentials.
  For a web app, you should implement something like this but use your database for credential storage.
  secret, scopes, fetch, save have default implementations that you can replace with init!"
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [happy.pluggable :as pluggable]
            [clojure.edn :as edn]))

(set! *warn-on-reflection* true)

;; TODO: this sometimes fails because pluggable doesn't have parse-json resolved...????
;; ... can reload client then pluggable then client and it "fixes" it...?
;; also this sucks as a way to find out... but throwing at load time is just as bad?
(defn read-secret []
  (merge
    ;; If you download secret.json or service.json from your Google Console,
    ;; do not add them to source control.
    (let [secret-file (io/file "secret.json")]
      (when (.exists secret-file)
        (first (vals (pluggable/parse-json (slurp secret-file))))))
    (let [service-file (io/file "service.json")]
      (when (.exists service-file)
        (pluggable/parse-json (slurp service-file))))))

(def *credentials-cache
  (atom nil))

(defn read-credentials [user]
  (or (get @*credentials-cache user)
      (let [credentials-file (io/file "tokens" (str user ".edn"))]
        (when (.exists credentials-file)
          (edn/read-string (slurp credentials-file))))))

(defn delete-credentials [user]
  (swap! *credentials-cache dissoc user)
  (.delete (io/file (io/file "tokens")
                    (str user ".edn"))))

(defn write-credentials [user credentials]
  (swap! *credentials-cache assoc user credentials)
  (spit (io/file (doto (io/file "tokens") (.mkdirs))
                 (str user ".edn"))
        credentials))

(defn save-credentials [user new-credentials]
  (when (not= @*credentials-cache new-credentials)
    (if new-credentials
      (write-credentials user new-credentials)
      (delete-credentials user))))
