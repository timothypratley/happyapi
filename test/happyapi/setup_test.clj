(ns happyapi.setup-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.java.io :as io]
            [happyapi.setup :as setup])
  (:import [java.io File]
           [java.util UUID]))

(def config-file-name "happyapi.edn")
(def config-env-name "HAPPYAPI_CONFIG")

(def file-config
  {:test-provider {:auth_uri     "FILE"
                   :client_id    "FILE"
                   :redirect_uri "http://localhost"}})

(deftest find-config-test
  (let [old-file-name config-file-name
        old-file (io/file old-file-name)
        old-file? (.exists old-file)
        helper-fn (fn helper-fn [expected-auth-uri-value]
                    (let [config (setup/find-config)]
                      (is (= expected-auth-uri-value (:auth_uri (:test-provider config))))))
        test-fn (fn test-fn []
                  (when-not (System/getenv config-env-name) ; punt for now if config in env
                    (helper-fn "RESOURCE")
                    (try (spit config-file-name (pr-str file-config))
                         (helper-fn "FILE")
                         (finally (io/delete-file config-file-name)))))]
    ;; We have to check for an existing happyapi.edn since other tests seem to require it.
    (if old-file?
      ;; save and restore any existing happyapi.edn
      (let [parent (.getParentFile old-file)
            saved-config-file (File. (str "happyapi" (UUID/randomUUID) ".saved" parent))
            saved-config-file-name (.getName saved-config-file)]
        (try (io/delete-file saved-config-file-name true) ;renameTo needs a non-existing destination
             (.renameTo old-file saved-config-file)
             (test-fn)
             (finally (io/delete-file old-file true) ;renameTo needs a non-existing destination
                      (.renameTo saved-config-file old-file))))
      (test-fn))))
