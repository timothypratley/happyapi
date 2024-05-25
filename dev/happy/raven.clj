(ns happy.raven
  "Tries to figure out the urls for api, resource, and method documentation."
  (:require [clj-http.client :as http]
            [clojure.string :as str]
            [happy.common.common :as mw]))

(defonce pattern-cache& (atom {}))
(defonce redirect-cache& (atom {}))
(defonce dead-link-cache& (atom #{}))

;; fitness is deprecated

(def override-docs
  {"policyanalyzer" ["https://www.google.com" "https://cloud.google.com/policy-intelligence/docs/reference/policyanalyzer/rest/"]})

(def override-pattern
  {"iamcredentials" "https://cloud.google.com/iam/docs/reference/credentials/rest/v1/projects.serviceAccounts/generateAccessToken"
   "sql"            [:documentationLink "mysql" "admin-api" "rest" :version :dot-path]})


(def http-request
  ((comp mw/wrap-report-url-exceptions mw/wrap-cookie-policy-standard)
   http/request))

(def json-request (mw/wrap-json http-request))

(defn get-json [url]
  (json-request {:url url :method :get}))

;; alternatively add to the stack
#_(defn http-request2 [request]
    (http/with-additional-middleware
      [wrap-report-url-exceptions wrap-cookie-policy-standard]
      (http/request request)))
;; these are bad.
;; rebuilds the stack every time (seems silly)
;; also adjust a dynamic binding... which seems even more wrong
;; behaviour differences

;; IDEA: Instead they should provide a way to change the default!
;; (http/wrap http/request http/default-middleware)
;; is this just (apply comp http/default-middleware)
;; returns a new thing (doesn't change the default).
;; IDEA2: Change the default
;; Alter request with a new stack of middleware. Setup root.
;; It doesn't matter, and global is convenient.
;; (http/set-middleware! http/default-middleware)
;; -- alters http/request by calling http/wrap

;; ring middleware set up our "thing"

;; get a request
;; call 1 of 10 other services, and they are all a bit different
;;   * however you might want to handle exceptions the same (logging/metrics)
;; how are they different?
;;   * urls are definitely different
;; (my-http {:method "get" :url "different"})


;; when to use middleware
;;;; want a reusable behavior
;;;; when users may optionally want some behavior
;;;; who wants to adjust the behavior, where is it known...
;;;; if it is known at the call site, the value of middleware is dramatically reduced
;;;; if you don't know, it has to be middleware? (all of our logging this way, all of our metrics, proxy)

;; when to pass config to middleware
;;;;

;; when to just write the code

(defn can-get? [url]
  (mw/success? (http-request {:method "get"
                              :url    url})))

(defn format-url [m pattern]
  (str/join \/ (for [expr pattern]
                 (if (keyword? expr)
                   (get m expr)
                   expr))))

(defn try-pattern!
  "Returns a pattern if a url is successfully discovered."
  [m pattern]
  (and (can-get? (format-url m pattern))
       pattern))

(defn verify-doc-path-pattern!
  "Documentation links are inconsistent
  (try to find out if the url schema pattern is documented).
  Just try them all and take the first one that doesn't 404.

  Examples:
    https://developers.google.com/abusive-experience-report/
    https://developers.google.com/abusive-experience-report/v1/reference/rest/v1/sites/get

    https://developers.google.com/youtube/v3/docs/videos/list
    https://cloud.google.com/dataflow/docs/reference/rest/v1b3/projects.jobs/list
    https://developers.google.com/amp/cache/reference/acceleratedmobilepageurl/rest/v1/ampUrls/batchGet
    https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/getServiceAccount
    https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/create

    https://developers.google.com/maps/documentation/addressvalidation
    https://developers.google.com/maps/documentation/address-validation/reference/rest/v1/TopLevel/validateAddress

    https://developers.google.com/youtube/reporting/v1/reports/
    https://developers.google.com/youtube/reporting/v1/reference/rest/v1/jobs/create

    https://cloud.google.com/orgpolicy/docs/reference/rest/index.html
    https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest

    https://developers.google.com/blogger/docs/3.0/getting_started
    https://developers.google.com/blogger/docs/3.0/reference/blogs/get

    https://developers.google.com/google-apps/calendar/firstapp
    https://developers.google.com/calendar
    https://developers.google.com/calendar/api/v3/reference/calendarList/delete

    https://cloud.google.com/bigquery-transfer/
    https://cloud.google.com/bigquery/
    https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/cancel

    https://cloud.google.com/learnmoreurl (404)
    https://cloud.google.com/assured-workloads/docs/
    https://cloud.google.com/assured-workloads/docs/reference/rest/v1/organizations.locations.operations/get

    https://cloud.google.com/workstations
    https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations/list

    https://developers.google.com/workspace/events
    https://developers.google.com/workspace/events/reference/rest/v1/subscriptions/create

    https://cloud.google.com/workload-manager/docs
    https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations/create

    https://cloud.google.com/batch/
    https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs/get

    https://cloud.google.com/sql/docs
    https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/connect/get

    https://cloud.google.com/bigquery
    https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs/list

    https://developers.google.com/people
    https://developers.google.com/people/api/rest/v1/contactGroups.members/modify

    https://developers.google.com/docs
    https://developers.google.com/docs/api/reference/rest/v1/documents/request

    TODO: versions all messed up. current is 4, discovery is 3, docs is 1beta
    https://developers.google.com/analytics
    https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1beta/accounts/delete

    https://developers.google.com/civic-information
    https://developers.google.com/civic-information/docs/v2/elections/electionQuery

    https://cloud.google.com/vertex-ai/docs/reference/rest/v1/projects.locations.publishers.models/generateContent
    "
  [m]
  (or (try-pattern! m [:documentationLink :version "docs" :path])
      (try-pattern! m [:documentationLink :version "docs" "reference" "rest" :path])
      (try-pattern! m [:documentationLink :version "reference" "rest" :path])
      (try-pattern! m [:documentationLink :version "reference" "rest" :version :path])
      (try-pattern! m [:documentationLink "reference" :name "rest" :version :path])
      (try-pattern! m [:documentationLink "reference" "rest" :version :path])
      (try-pattern! m [:documentationLink "reference" "rest" :version :dot-path])
      (try-pattern! m [:documentationLink "reference" "rest" :version "TopLevel" :path])
      (try-pattern! m [:documentationLink "rest" :version "docs" :path])
      ;; TODO: this is specific to one api... should it be an override instead?
      (try-pattern! m [:documentationLink "mysql" "admin-api" "rest" :version :dot-path])
      ;; TODO: shouldn't this work for spanner? nope, spanner has undocumented methods
      (try-pattern! m [:documentationLink "docs" "reference" "rest" :version :dot-path])
      (try-pattern! m [:documentationLink "docs" "reference" :name "rest" :version :dot-path])
      (try-pattern! m [:documentationLink "docs" :version :path])
      (try-pattern! m [:documentationLink "api" "rest" :version :dot-path])
      (try-pattern! m [:documentationLink "api" "reference" "rest" :version :path])
      (try-pattern! m [:documentationLink :version :dot-path])
      (try-pattern! m [:documentationLink-1 "reference" "rest" :version :dot-path])

      (do (println "No doc path pattern detected (please suggest one):"
                   (:name m)
                   (:documentationLink m)
                   (:dot-path m)
                   (:documentationLink-1 m))
          [:documentationLink])))

(defn pattern-for
  "Returns the doc link pattern for an api, will update a cache if not found."
  [m]
  (let [api-name (:name m)]
    (or (get @pattern-cache& api-name)
        (doto (verify-doc-path-pattern! m)
          (->> (swap! pattern-cache& assoc api-name))))))

(defn doc-path
  "Google doc pages mostly follow a naming convention that aligns with a method id,
  but method ids start with the api-name, which is redundant in the documentationLink."
  [method-id]
  (when method-id
    (->> (str/split method-id #"\.")
         (rest)
         (str/join \/))))

(defn doc-dot-path
  "Google doc pages sometimes use resource.child/method instead of resource/child/method."
  [method-id]
  (when method-id
    (let [[_ & tail] (str/split method-id #"\.")]
      (str/join \/ [(str/join \. (butlast tail))
                    (last tail)]))))

(defn maybe-redirected'
  "The documentationLink is sometimes redirected to a different url
   (I wish they would give us the correct url in the first place).
   Some, like https://cloud.google.com/learnmoreurl, are 404 dead links."
  [url]
  (let [response (http-request url)]
    (if (mw/success? response)
      (let [{:keys [trace-redirects]} response
            redirect (last trace-redirects)]
        (if redirect
          (do (println "REDIRECTED:" url redirect)
              (swap! redirect-cache& assoc url redirect)
              redirect)
          url))
      (do (println "DEAD LINK:" (:status response) url)
          (swap! dead-link-cache& conj url)
          url))))

(def maybe-redirected
  (memoize maybe-redirected'))

(defn doc-link-maybe-override [{:keys [name documentationLink]}]
  (let [[prev override] (get override-docs name)]
    (if override
      (if (= prev documentationLink)
        override
        (do (println "EXPIRED OVERRIDE:" name)
            documentationLink))
      documentationLink)))

(defn remove-trailing-slash [s]
  (str/replace s #"/$" ""))

(defn url-butlast
  "Removes the last path element of a url, if it has one."
  [url]
  (str/replace url #"^(https://.+)/[^/]+/?$" "$1"))

(comment
  (url-butlast "https://www.google.com/")
  (url-butlast "https://www.google.com/foo/bar")
  (url-butlast "www.foo.bar/baz/booz"))

(defn doc-link
  "Formats a direct link to resource or method documentation."
  [api method]
  (let [method-id (:id method)
        doc (-> (doc-link-maybe-override api)
                (maybe-redirected)
                (remove-trailing-slash))
        m (merge method
                 (assoc api :documentationLink doc)
                 {:path                (doc-path method-id)
                  ;; TODO: path and dot-path can overlap, causing an incorrect match
                  :dot-path            (doc-dot-path method-id)
                  :documentationLink-1 (url-butlast doc)})
        pattern (pattern-for m)]
    (format-url m pattern)))

(comment
  (swap! pattern-cache& dissoc "spanner"))
