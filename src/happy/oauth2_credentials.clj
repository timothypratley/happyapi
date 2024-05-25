(ns happy.oauth2-credentials
  "Reference for how to manage credentials.
  For a web app, you should implement something like this but use your database for credential storage.
  secret, scopes, fetch, save have default implementations that you can replace with init!"
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [happy.oauth2 :as oauth2]
            [happy.oauth2-capture-redirect :as ocr]
            [clojure.edn :as edn]
            [cheshire.core :as json]))

(set! *warn-on-reflection* true)

(def *secret
  (atom {}))

(def *scopes
  (atom []))

(def *credentials-cache
  (atom nil))

(defn read-credentials [user]
  (or (get @*credentials-cache user)
      (let [credentials-file (io/file "tokens" (str user ".edn"))]
        (when (.exists credentials-file)
          (edn/read-string (slurp credentials-file))))))

;; TODO:
(defn slurp-async [file respond raise]
  (let [path (java.nio.file.Paths/get (file-uri file))
        fileChannel (AsynchronousFileChannel/open path #{StandardOpenOption/READ} asynch-file-executor (make-array FileAttribute 0))
        buffer (ByteBuffer/allocate (.size fileChannel))]

    (.read fileChannel buffer 0 nil
           (proxy [CompletionHandler] []
             (completed [result attachment]
               (.close fileChannel)
               (.flip buffer)
               (respond buffer))
             (failed [ex attachment]
               (.close fileChannel)
               (raise ex))))
    ))

(defn read-credentials-async [user respond raise]
  (if-let [credentials (get @*credentials-cache user)]
    (respond credentials)
    (slurp-async (io/file "tokens" (str user ".edn"))
                 (fn [txt]
                   (respond (edn/read-string txt)))
                 (fn [ex]
                   (respond nil)))))

(defn spit-async
  [file buffer]
  (let [ch (chan)]
    (try
      (let [path (java.nio.file.Paths/get (file-uri file))
            fileChannel (AsynchronousFileChannel/open path #{StandardOpenOption/WRITE} asynch-file-executor (make-array FileAttribute 0))]
        (.write fileChannel buffer 0 nil
                (proxy [CompletionHandler] []
                  (completed [result attachment]
                    (.close fileChannel)
                    (close! ch))
                  (failed [e attachment]
                    (.close fileChannel)
                    (put! ch e)))))
      (catch Throwable t
        (warn t "Failed writing file" file)
        (put! ch t)))
    ch))

(defn write-credentials [user new-credentials]
  (when (not= @*credentials-cache new-credentials)
    (swap! *credentials-cache assoc user new-credentials)
    (spit (io/file (-> (io/file "tokens")
                       (doto (.mkdirs)))
                   (str user ".edn"))
          new-credentials)))

(def *fetch (atom read-credentials))
(def *save (atom write-credentials))

(defn auth!
  ([] (auth! "user"))
  ([user]
   (let [credentials (@*fetch user)
         new-credentials (ocr/maybe-update-credentials http @*secret credentials @*scopes nil)]
     (@*save user new-credentials)
     (oauth2/auth-header new-credentials))))

(defn init!
  ([]
   ;; TODO: shouldn't have these defaults
   (init! ["https://www.googleapis.com/auth/spreadsheets"
           "https://www.googleapis.com/auth/drive"
           "https://www.googleapis.com/auth/youtube"
           "https://www.googleapis.com/auth/cloud-vision"]))
  ([scopes]
   (init! (merge
            ;; If you download secret.json or service.json from your Google Console,
            ;; do not add them to source control.
            (let [secret-file (io/file "secret.json")]
              (when (.exists secret-file)
                (first (vals (json/parse-string (slurp secret-file) true)))))
            (let [service-file (io/file "service.json")]
              (when (.exists service-file)
                (json/parse-string (slurp service-file) true))))
          scopes))
  ([config scopes]
   (init! config scopes read-credentials write-credentials))
  ([config scopes fetch-credentials save-credentials]
   (reset! *secret config)
   (reset! *scopes scopes)
   (reset! *fetch fetch-credentials)
   (reset! *save save-credentials)))

(defn oauth2-async
  [http request respond raise config]
  (let [{:keys [user scopes]} request
        ;; TODO: read-credentials is blocking...
        ]
    (read-credentials-async user
                      (fn [previous-credentials]
                        (ocr/maybe-update-credentials-async
                          http
                          config previous-credentials scopes nil
                          (fn [credentials]
                            (when (not= credentials previous-credentials)
                              (write-credentials-async user credentials))
                            (http
                              (merge-with merge request (oauth2/auth-header credentials))
                              respond
                              raise))
                          raise)
                        (respond))
                      raise)))

(defn oauth2
  "Configure: secret, scopes, read/write credentials"
  [http request config]
  (let [{:keys [user scopes] :or {user "user" scopes (:scopes config)}} request
        credentials (read-credentials user)
        new-credentials (ocr/maybe-update-credentials http config credentials scopes nil)]
    (write-credentials user new-credentials)
    (http (merge-with merge request (oauth2/auth-header new-credentials)))))

;; Middleware!!!

(defn wrap-oauth2
  "Special keys: user and scopes"
  [http config]
  (fn
    ([request]
     (oauth2 http request config))
    ([request respond raise]
     (oauth2-async http request respond raise config))))
