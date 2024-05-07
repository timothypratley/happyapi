(ns happygapi.aiplatform.projects
  "Vertex AI API: projects.
  Train high-quality custom machine learning models with minimal machine learning expertise and effort.
  See: https://cloud.google.com/vertex-ai/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a NasJob"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a NasJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a NasJob. Starts asynchronous cancellation on the NasJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetNasJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the NasJob is not deleted; instead it becomes a job with a NasJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and NasJob.state is set to `CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :state string,
   :updateTime string,
   :nasJobSpec {:searchSpaceSpec string,
                :multiTrialAlgorithmSpec GoogleCloudAiplatformV1NasJobSpecMultiTrialAlgorithmSpec,
                :resumeNasJobId string},
   :nasJobOutput {:multiTrialJobOutput GoogleCloudAiplatformV1NasJobOutputMultiTrialJobOutput},
   :error {:message string, :code integer, :details [{}]},
   :enableRestrictedImageTraining boolean}
  
  Creates a NasJob"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/nasJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, readMask
  
  Lists NasJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/nasJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-nasTrialDetails-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List top NasTrialDetails of a NasJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/nasTrialDetails"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nasJobs-nasTrialDetails-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a NasTrialDetail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimes-upgrade$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Upgrades a NotebookRuntime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:upgrade"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimes-start$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts a NotebookRuntime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:start"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimes-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a NotebookRuntime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimes-assign$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:notebookRuntimeId string,
   :notebookRuntime {:description string,
                     :serviceAccount string,
                     :labels {},
                     :proxyUri string,
                     :runtimeState string,
                     :expirationTime string,
                     :displayName string,
                     :name string,
                     :runtimeUser string,
                     :createTime string,
                     :isUpgradable boolean,
                     :notebookRuntimeType string,
                     :updateTime string,
                     :reservationAffinity GoogleCloudAiplatformV1NotebookReservationAffinity,
                     :version string,
                     :healthState string,
                     :networkTags [string],
                     :notebookRuntimeTemplateRef GoogleCloudAiplatformV1NotebookRuntimeTemplateRef},
   :notebookRuntimeTemplate string}
  
  Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either returns an existing assignment or generates a new one."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/notebookRuntimes:assign"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimes-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: readMask, filter, pageSize, orderBy, pageToken
  
  Lists NotebookRuntimes in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/notebookRuntimes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimes-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a NotebookRuntime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :savedQueries [{:displayName string,
                   :annotationSpecCount integer,
                   :name string,
                   :createTime string,
                   :etag string,
                   :annotationFilter string,
                   :updateTime string,
                   :supportAutomlTraining boolean,
                   :metadata any,
                   :problemType string}],
   :encryptionSpec {:kmsKeyName string},
   :metadataSchemaUri string,
   :displayName string,
   :name string,
   :createTime string,
   :metadataArtifact string,
   :etag string,
   :dataItemCount string,
   :updateTime string,
   :metadata any}
  
  Updates a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :savedQueries [{:displayName string,
                   :annotationSpecCount integer,
                   :name string,
                   :createTime string,
                   :etag string,
                   :annotationFilter string,
                   :updateTime string,
                   :supportAutomlTraining boolean,
                   :metadata any,
                   :problemType string}],
   :encryptionSpec {:kmsKeyName string},
   :metadataSchemaUri string,
   :displayName string,
   :name string,
   :createTime string,
   :metadataArtifact string,
   :etag string,
   :dataItemCount string,
   :updateTime string,
   :metadata any}
  
  Creates a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/datasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, pageSize, filter, readMask
  
  Lists Datasets in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/datasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-export$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:exportConfig {:filterSplit GoogleCloudAiplatformV1ExportFilterSplit,
                  :exportUse string,
                  :annotationsFilter string,
                  :gcsDestination GoogleCloudAiplatformV1GcsDestination,
                  :fractionSplit GoogleCloudAiplatformV1ExportFractionSplit,
                  :savedQueryId string,
                  :annotationSchemaUri string}}
  
  Exports data from a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:export"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-import$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:importConfigs [{:gcsSource GoogleCloudAiplatformV1GcsSource,
                    :annotationLabels {},
                    :importSchemaUri string,
                    :dataItemLabels {}}]}
  
  Imports data into a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:import"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-searchDataItems$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: dataset
  
  Optional parameters: fieldMask, annotationsLimit, savedQuery, orderByAnnotation.savedQuery, orderByAnnotation.orderBy, dataLabelingJob, annotationsFilter, pageToken, orderByDataItem, pageSize, dataItemFilter, annotationFilters, orderBy
  
  Searches DataItems in a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dataset})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+dataset}:searchDataItems"
     #{:dataset}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Gets a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, orderBy, pageToken, readMask, filter
  
  Lists SavedQueries in a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/savedQueries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a SavedQuery."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-savedQueries-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, readMask, filter, pageSize, pageToken
  
  Lists DataItems in a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/dataItems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-annotations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter, readMask
  
  Lists Annotations belongs to a dataitem"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/annotations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-annotations-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-annotations-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-annotations-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-annotations-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataItems-annotations-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationSpecs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Gets an AnnotationSpec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationSpecs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationSpecs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationSpecs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationSpecs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationSpecs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-datasetVersions-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Gets a Dataset version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-datasetVersions-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Dataset version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-datasetVersions-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, filter, readMask, pageSize
  
  Lists DatasetVersions in a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/datasetVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-datasetVersions-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :createTime string,
   :bigQueryDatasetName string,
   :updateTime string,
   :name string,
   :metadata any,
   :etag string}
  
  Create a version from a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/datasetVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-datasetVersions-restore$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Restores a dataset version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:restore"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-batchDelete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Batch deletes PipelineJobs The Operation is atomic. If it fails, none of the PipelineJobs are deleted. If it succeeds, all of the PipelineJobs are deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/pipelineJobs:batchDelete"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a PipelineJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a PipelineJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, readMask, filter, orderBy, pageToken
  
  Lists PipelineJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/pipelineJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a PipelineJob. Starts asynchronous cancellation on the PipelineJob. The server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can use PipelineService.GetPipelineJob or other methods to check whether the cancellation succeeded or whether the pipeline completed despite cancellation. On successful cancellation, the PipelineJob is not deleted; instead it becomes a pipeline with a PipelineJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and PipelineJob.state is set to `CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pipelineJobId
  
  Body: 
  
  {:serviceAccount string,
   :labels {},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :runtimeConfig {:gcsOutputDirectory string,
                   :parameterValues {},
                   :failurePolicy string,
                   :inputArtifacts {},
                   :parameters {}},
   :name string,
   :templateUri string,
   :endTime string,
   :createTime string,
   :reservedIpRanges [string],
   :state string,
   :updateTime string,
   :jobDetail {:pipelineRunContext GoogleCloudAiplatformV1Context,
               :taskDetails [GoogleCloudAiplatformV1PipelineTaskDetail],
               :pipelineContext GoogleCloudAiplatformV1Context},
   :error {:message string, :code integer, :details [{}]},
   :network string,
   :pipelineSpec {},
   :scheduleName string,
   :templateMetadata {:version string}}
  
  Creates a PipelineJob. A PipelineJob will run immediately when created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/pipelineJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-batchCancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Batch cancel PipelineJobs. Firstly the server will check if all the jobs are in non-terminal states, and skip the jobs that are already terminated. If the operation failed, none of the pipeline jobs are cancelled. The server will poll the states of all the pipeline jobs periodically to check the cancellation status. This operation will return an LRO."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/pipelineJobs:batchCancel"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelineJobs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :startTime string,
   :tunedModel {:endpoint string, :model string},
   :name string,
   :tunedModelDisplayName string,
   :endTime string,
   :createTime string,
   :state string,
   :baseModel string,
   :updateTime string,
   :experiment string,
   :supervisedTuningSpec {:validationDatasetUri string,
                          :trainingDatasetUri string,
                          :hyperParameters GoogleCloudAiplatformV1SupervisedHyperParameters},
   :tuningDataStats {:supervisedTuningDataStats GoogleCloudAiplatformV1SupervisedTuningDataStats},
   :error {:message string, :code integer, :details [{}]}}
  
  Creates a TuningJob. A created TuningJob right away will be attempted to be run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/tuningJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use GenAiTuningService.GetTuningJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it becomes a job with a TuningJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and TuningJob.state is set to `CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TuningJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists TuningJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/tuningJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tuningJobs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists MetadataStores for a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/metadataStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and Contexts)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: metadataStoreId
  
  Body: 
  
  {:updateTime string,
   :encryptionSpec {:kmsKeyName string},
   :createTime string,
   :name string,
   :description string,
   :state {:diskUtilizationBytes string}}
  
  Initializes a MetadataStore, including allocation of resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/metadataStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific Context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: allowMissing, updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :parentContexts [string],
   :metadata {},
   :schemaVersion string}
  
  Updates a stored Context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-addContextChildren$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: context
  
  Optional parameters: none
  
  Body: 
  
  {:childContexts [string]}
  
  Adds a set of Contexts as children to a parent Context. If any of the child Contexts have already been added to the parent Context, they are simply skipped. If this call would create a cycle or cause any Context to have more than 10 parents, the request will fail with an INVALID_ARGUMENT error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:context})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+context}:addContextChildren"
     #{:context}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: contextId
  
  Body: 
  
  {:description string,
   :labels {},
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :parentContexts [string],
   :metadata {},
   :schemaVersion string}
  
  Creates a Context associated with a MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/contexts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-queryContextLineageSubgraph$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: context
  
  Optional parameters: none
  
  Retrieves Artifacts and Executions within the specified Context, connected by Event edges and returned as a LineageSubgraph."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:context})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+context}:queryContextLineageSubgraph"
     #{:context}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: etag, force
  
  Deletes a stored Context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize, orderBy
  
  Lists Contexts on the MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/contexts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-addContextArtifactsAndExecutions$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: context
  
  Optional parameters: none
  
  Body: 
  
  {:artifacts [string], :executions [string]}
  
  Adds a set of Artifacts and Executions to a Context. If any of the Artifacts or Executions have already been added to a Context, they are simply skipped."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:context})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+context}:addContextArtifactsAndExecutions"
     #{:context}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-purge$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:force boolean, :filter string}
  
  Purges Contexts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/contexts:purge"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-removeContextChildren$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: context
  
  Optional parameters: none
  
  Body: 
  
  {:childContexts [string]}
  
  Remove a set of children contexts from a parent Context. If any of the child Contexts were NOT added to the parent Context, they are simply skipped."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:context})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+context}:removeContextChildren"
     #{:context}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-contexts-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-purge$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :force boolean}
  
  Purges Executions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/executions:purge"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: executionId
  
  Body: 
  
  {:description string,
   :labels {},
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :metadata {},
   :schemaVersion string}
  
  Creates an Execution associated with a MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :metadata {},
   :schemaVersion string}
  
  Updates a stored Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes an Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Executions in the MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-queryExecutionInputsAndOutputs$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: execution
  
  Optional parameters: none
  
  Obtains the set of input and output Artifacts for this Execution, in the form of LineageSubgraph that also contains the Execution and connecting Events."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:execution})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+execution}:queryExecutionInputsAndOutputs"
     #{:execution}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-addExecutionEvents$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: execution
  
  Optional parameters: none
  
  Body: 
  
  {:events [{:execution string,
             :artifact string,
             :eventTime string,
             :labels {},
             :type string}]}
  
  Adds Events to the specified Execution. An Event indicates whether an Artifact was used as an input or output for an Execution. If an Event already exists between the Execution and the Artifact, the Event is skipped."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:execution})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+execution}:addExecutionEvents"
     #{:execution}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-executions-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, orderBy, filter
  
  Lists Artifacts in the MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :uri string,
   :metadata {},
   :schemaVersion string}
  
  Updates a stored Artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes an Artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-purge$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:force boolean, :filter string}
  
  Purges Artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/artifacts:purge"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific Artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: artifactId
  
  Body: 
  
  {:description string,
   :labels {},
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :uri string,
   :metadata {},
   :schemaVersion string}
  
  Creates an Artifact associated with a MetadataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-queryArtifactLineageSubgraph$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: artifact
  
  Optional parameters: filter, maxHops
  
  Retrieves lineage of an Artifact represented through Artifacts and Executions connected by Event edges and returned as a LineageSubgraph."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:artifact})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+artifact}:queryArtifactLineageSubgraph"
     #{:artifact}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-artifacts-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-metadataSchemas-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific MetadataSchema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-metadataSchemas-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists MetadataSchemas."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/metadataSchemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-metadataStores-metadataSchemas-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: metadataSchemaId
  
  Body: 
  
  {:description string,
   :createTime string,
   :name string,
   :schemaType string,
   :schema string,
   :schemaVersion string}
  
  Creates a MetadataSchema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/metadataSchemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-queryDeployedModels$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: deploymentResourcePool
  
  Optional parameters: pageToken, pageSize
  
  List DeployedModels that have been deployed on this DeploymentResourcePool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:deploymentResourcePool})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+deploymentResourcePool}:queryDeployedModels"
     #{:deploymentResourcePool}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deploymentResourcePoolId string,
   :deploymentResourcePool {:dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                            :name string,
                            :createTime string}}
  
  Create a DeploymentResourcePool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/deploymentResourcePools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a DeploymentResourcePool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List DeploymentResourcePools in a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/deploymentResourcePools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a DeploymentResourcePool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deploymentResourcePools-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-generateContent$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: model
  
  Optional parameters: none
  
  Body: 
  
  {:generationConfig {:responseMimeType string,
                      :presencePenalty number,
                      :stopSequences [string],
                      :topP number,
                      :maxOutputTokens integer,
                      :frequencyPenalty number,
                      :topK number,
                      :candidateCount integer,
                      :temperature number},
   :tools [{:functionDeclarations [GoogleCloudAiplatformV1FunctionDeclaration],
            :retrieval GoogleCloudAiplatformV1Retrieval}],
   :safetySettings [{:method string,
                     :threshold string,
                     :category string}],
   :contents [{:parts [GoogleCloudAiplatformV1Part], :role string}],
   :systemInstruction {:parts [GoogleCloudAiplatformV1Part],
                       :role string}}
  
  Generate content with multimodal inputs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:model})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+model}:generateContent"
     #{:model}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-serverStreamingPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:parameters {:uintVal [integer],
                :floatVal [number],
                :dtype string,
                :uint64Val [string],
                :boolVal [boolean],
                :listVal [GoogleCloudAiplatformV1Tensor],
                :stringVal [string],
                :int64Val [string],
                :tensorVal string,
                :shape [string],
                :bytesVal [string],
                :intVal [integer],
                :doubleVal [number],
                :structVal {}},
   :inputs [{:uintVal [integer],
             :floatVal [number],
             :dtype string,
             :uint64Val [string],
             :boolVal [boolean],
             :listVal [GoogleCloudAiplatformV1Tensor],
             :stringVal [string],
             :int64Val [string],
             :tensorVal string,
             :shape [string],
             :bytesVal [string],
             :intVal [integer],
             :doubleVal [number],
             :structVal {}}]}
  
  Perform a server-side streaming online prediction request for Vertex LLM streaming."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:serverStreamingPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-streamGenerateContent$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: model
  
  Optional parameters: none
  
  Body: 
  
  {:generationConfig {:responseMimeType string,
                      :presencePenalty number,
                      :stopSequences [string],
                      :topP number,
                      :maxOutputTokens integer,
                      :frequencyPenalty number,
                      :topK number,
                      :candidateCount integer,
                      :temperature number},
   :tools [{:functionDeclarations [GoogleCloudAiplatformV1FunctionDeclaration],
            :retrieval GoogleCloudAiplatformV1Retrieval}],
   :safetySettings [{:method string,
                     :threshold string,
                     :category string}],
   :contents [{:parts [GoogleCloudAiplatformV1Part], :role string}],
   :systemInstruction {:parts [GoogleCloudAiplatformV1Part],
                       :role string}}
  
  Generate content with multimodal inputs with streaming support."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:model})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+model}:streamGenerateContent"
     #{:model}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-streamRawPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:httpBody {:contentType string, :extensions [{}], :data string}}
  
  Perform a streaming online prediction with an arbitrary HTTP payload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:streamRawPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-computeTokens$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:instances [any]}
  
  Return a list of tokens based on the input text."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:computeTokens"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-rawPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:httpBody {:contentType string, :extensions [{}], :data string}}
  
  Perform an online prediction with an arbitrary HTTP payload. The response includes the following HTTP headers: * `X-Vertex-AI-Endpoint-Id`: ID of the Endpoint that served this prediction. * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's DeployedModel that served this prediction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:rawPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-countTokens$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:contents [{:parts [GoogleCloudAiplatformV1Part], :role string}],
   :model string,
   :instances [any]}
  
  Perform a token counting."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:countTokens"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-publishers-models-predict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:instances [any], :parameters any}
  
  Perform an online prediction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:predict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a HyperparameterTuningJob"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a HyperparameterTuningJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a HyperparameterTuningJob. Starts asynchronous cancellation on the HyperparameterTuningJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetHyperparameterTuningJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the HyperparameterTuningJob is not deleted; instead it becomes a job with a HyperparameterTuningJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and HyperparameterTuningJob.state is set to `CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :name string,
   :endTime string,
   :trialJobSpec {:serviceAccount string,
                  :protectedArtifactLocationId string,
                  :enableWebAccess boolean,
                  :scheduling GoogleCloudAiplatformV1Scheduling,
                  :enableDashboardAccess boolean,
                  :experimentRun string,
                  :persistentResourceId string,
                  :tensorboard string,
                  :workerPoolSpecs [GoogleCloudAiplatformV1WorkerPoolSpec],
                  :reservedIpRanges [string],
                  :baseOutputDirectory GoogleCloudAiplatformV1GcsDestination,
                  :experiment string,
                  :models [string],
                  :network string},
   :createTime string,
   :maxFailedTrialCount integer,
   :maxTrialCount integer,
   :state string,
   :studySpec {:algorithm string,
               :measurementSelectionType string,
               :observationNoise string,
               :studyStoppingConfig GoogleCloudAiplatformV1StudySpecStudyStoppingConfig,
               :decayCurveStoppingSpec GoogleCloudAiplatformV1StudySpecDecayCurveAutomatedStoppingSpec,
               :medianAutomatedStoppingSpec GoogleCloudAiplatformV1StudySpecMedianAutomatedStoppingSpec,
               :parameters [GoogleCloudAiplatformV1StudySpecParameterSpec],
               :convexAutomatedStoppingSpec GoogleCloudAiplatformV1StudySpecConvexAutomatedStoppingSpec,
               :metrics [GoogleCloudAiplatformV1StudySpecMetricSpec]},
   :updateTime string,
   :error {:message string, :code integer, :details [{}]},
   :trials [{:clientId string,
             :customJob string,
             :startTime string,
             :measurements [GoogleCloudAiplatformV1Measurement],
             :name string,
             :endTime string,
             :state string,
             :id string,
             :finalMeasurement GoogleCloudAiplatformV1Measurement,
             :infeasibleReason string,
             :webAccessUris {},
             :parameters [GoogleCloudAiplatformV1TrialParameter]}],
   :parallelTrialCount integer}
  
  Creates a HyperparameterTuningJob"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/hyperparameterTuningJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, readMask
  
  Lists HyperparameterTuningJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/hyperparameterTuningJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-hyperparameterTuningJobs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-search$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :pageSize integer, :pageToken string}
  
  Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and ml.googleapis.com that can be migrated to Vertex AI's given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/migratableResources:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-batchMigrate$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:migrateResourceRequests [{:migrateMlEngineModelVersionConfig GoogleCloudAiplatformV1MigrateResourceRequestMigrateMlEngineModelVersionConfig,
                              :migrateDataLabelingDatasetConfig GoogleCloudAiplatformV1MigrateResourceRequestMigrateDataLabelingDatasetConfig,
                              :migrateAutomlModelConfig GoogleCloudAiplatformV1MigrateResourceRequestMigrateAutomlModelConfig,
                              :migrateAutomlDatasetConfig GoogleCloudAiplatformV1MigrateResourceRequestMigrateAutomlDatasetConfig}]}
  
  Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and datalabeling.googleapis.com to Vertex AI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/migratableResources:batchMigrate"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migratableResources-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageSize, pageToken
  
  Lists FeatureGroups in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single FeatureGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: featureGroupId
  
  Body: 
  
  {:etag string,
   :labels {},
   :updateTime string,
   :bigQuery {:entityIdColumns [string],
              :bigQuerySource GoogleCloudAiplatformV1BigQuerySource},
   :createTime string,
   :name string,
   :description string}
  
  Creates a new FeatureGroup in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single FeatureGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:etag string,
   :labels {},
   :updateTime string,
   :bigQuery {:entityIdColumns [string],
              :bigQuerySource GoogleCloudAiplatformV1BigQuerySource},
   :createTime string,
   :name string,
   :description string}
  
  Updates the parameters of a single FeatureGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, readMask, pageSize, pageToken, latestStatsCount
  
  Lists Features in a given FeatureGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/features"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: featureId
  
  Body: 
  
  {:description string,
   :labels {},
   :disableMonitoring boolean,
   :valueType string,
   :versionColumnName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :pointOfContact string,
   :monitoringStatsAnomalies [{:featureStatsAnomaly GoogleCloudAiplatformV1FeatureStatsAnomaly,
                               :objective string}]}
  
  Creates a new Feature in a given FeatureGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/features"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :disableMonitoring boolean,
   :valueType string,
   :versionColumnName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :pointOfContact string,
   :monitoringStatsAnomalies [{:featureStatsAnomaly GoogleCloudAiplatformV1FeatureStatsAnomaly,
                               :objective string}]}
  
  Updates the parameters of a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-operations-listWait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-features-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-operations-listWait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureGroups-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-streamGenerateContent$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: model
  
  Optional parameters: none
  
  Body: 
  
  {:generationConfig {:responseMimeType string,
                      :presencePenalty number,
                      :stopSequences [string],
                      :topP number,
                      :maxOutputTokens integer,
                      :frequencyPenalty number,
                      :topK number,
                      :candidateCount integer,
                      :temperature number},
   :tools [{:functionDeclarations [GoogleCloudAiplatformV1FunctionDeclaration],
            :retrieval GoogleCloudAiplatformV1Retrieval}],
   :safetySettings [{:method string,
                     :threshold string,
                     :category string}],
   :contents [{:parts [GoogleCloudAiplatformV1Part], :role string}],
   :systemInstruction {:parts [GoogleCloudAiplatformV1Part],
                       :role string}}
  
  Generate content with multimodal inputs with streaming support."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:model})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+model}:streamGenerateContent"
     #{:model}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-mutateDeployedModel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :deployedModel {:serviceAccount string,
                   :modelVersionId string,
                   :disableContainerLogging boolean,
                   :automaticResources GoogleCloudAiplatformV1AutomaticResources,
                   :disableExplanations boolean,
                   :displayName string,
                   :explanationSpec GoogleCloudAiplatformV1ExplanationSpec,
                   :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                   :sharedResources string,
                   :createTime string,
                   :enableAccessLogging boolean,
                   :id string,
                   :privateEndpoints GoogleCloudAiplatformV1PrivateEndpoints,
                   :model string}}
  
  Updates an existing deployed model. Updatable fields include `min_replica_count`, `max_replica_count`, `autoscaling_metric_specs`, `disable_container_logging` (v1 only), and `enable_container_logging` (v1beta1 only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:mutateDeployedModel"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-explain$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:instances [any],
   :parameters any,
   :deployedModelId string,
   :explanationSpecOverride {:parameters GoogleCloudAiplatformV1ExplanationParameters,
                             :metadata GoogleCloudAiplatformV1ExplanationMetadataOverride,
                             :examplesOverride GoogleCloudAiplatformV1ExamplesOverride}}
  
  Perform an online explanation. If deployed_model_id is specified, the corresponding DeployModel must have explanation_spec populated. If deployed_model_id is not specified, all DeployedModels must have explanation_spec populated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:explain"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-directPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:parameters {:uintVal [integer],
                :floatVal [number],
                :dtype string,
                :uint64Val [string],
                :boolVal [boolean],
                :listVal [GoogleCloudAiplatformV1Tensor],
                :stringVal [string],
                :int64Val [string],
                :tensorVal string,
                :shape [string],
                :bytesVal [string],
                :intVal [integer],
                :doubleVal [number],
                :structVal {}},
   :inputs [{:uintVal [integer],
             :floatVal [number],
             :dtype string,
             :uint64Val [string],
             :boolVal [boolean],
             :listVal [GoogleCloudAiplatformV1Tensor],
             :stringVal [string],
             :int64Val [string],
             :tensorVal string,
             :shape [string],
             :bytesVal [string],
             :intVal [integer],
             :doubleVal [number],
             :structVal {}}]}
  
  Perform an unary online prediction request to a gRPC model server for Vertex first-party products and frameworks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:directPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-undeployModel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:trafficSplit {}, :deployedModelId string}
  
  Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources it's using."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:undeployModel"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :encryptionSpec {:kmsKeyName string},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :trafficSplit {},
   :updateTime string,
   :predictRequestResponseLoggingConfig {:bigqueryDestination GoogleCloudAiplatformV1BigQueryDestination,
                                         :enabled boolean,
                                         :samplingRate number},
   :enablePrivateServiceConnect boolean,
   :deployedModels [{:serviceAccount string,
                     :modelVersionId string,
                     :disableContainerLogging boolean,
                     :automaticResources GoogleCloudAiplatformV1AutomaticResources,
                     :disableExplanations boolean,
                     :displayName string,
                     :explanationSpec GoogleCloudAiplatformV1ExplanationSpec,
                     :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                     :sharedResources string,
                     :createTime string,
                     :enableAccessLogging boolean,
                     :id string,
                     :privateEndpoints GoogleCloudAiplatformV1PrivateEndpoints,
                     :model string}],
   :modelDeploymentMonitoringJob string,
   :privateServiceConnectConfig {:enablePrivateServiceConnect boolean,
                                 :projectAllowlist [string]},
   :network string}
  
  Updates an Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: endpointId
  
  Body: 
  
  {:description string,
   :labels {},
   :encryptionSpec {:kmsKeyName string},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :trafficSplit {},
   :updateTime string,
   :predictRequestResponseLoggingConfig {:bigqueryDestination GoogleCloudAiplatformV1BigQueryDestination,
                                         :enabled boolean,
                                         :samplingRate number},
   :enablePrivateServiceConnect boolean,
   :deployedModels [{:serviceAccount string,
                     :modelVersionId string,
                     :disableContainerLogging boolean,
                     :automaticResources GoogleCloudAiplatformV1AutomaticResources,
                     :disableExplanations boolean,
                     :displayName string,
                     :explanationSpec GoogleCloudAiplatformV1ExplanationSpec,
                     :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                     :sharedResources string,
                     :createTime string,
                     :enableAccessLogging boolean,
                     :id string,
                     :privateEndpoints GoogleCloudAiplatformV1PrivateEndpoints,
                     :model string}],
   :modelDeploymentMonitoringJob string,
   :privateServiceConnectConfig {:enablePrivateServiceConnect boolean,
                                 :projectAllowlist [string]},
   :network string}
  
  Creates an Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/endpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-computeTokens$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:instances [any]}
  
  Return a list of tokens based on the input text."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:computeTokens"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, readMask, pageToken, pageSize, filter
  
  Lists Endpoints in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/endpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-serverStreamingPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:parameters {:uintVal [integer],
                :floatVal [number],
                :dtype string,
                :uint64Val [string],
                :boolVal [boolean],
                :listVal [GoogleCloudAiplatformV1Tensor],
                :stringVal [string],
                :int64Val [string],
                :tensorVal string,
                :shape [string],
                :bytesVal [string],
                :intVal [integer],
                :doubleVal [number],
                :structVal {}},
   :inputs [{:uintVal [integer],
             :floatVal [number],
             :dtype string,
             :uint64Val [string],
             :boolVal [boolean],
             :listVal [GoogleCloudAiplatformV1Tensor],
             :stringVal [string],
             :int64Val [string],
             :tensorVal string,
             :shape [string],
             :bytesVal [string],
             :intVal [integer],
             :doubleVal [number],
             :structVal {}}]}
  
  Perform a server-side streaming online prediction request for Vertex LLM streaming."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:serverStreamingPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-rawPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:httpBody {:contentType string, :extensions [{}], :data string}}
  
  Perform an online prediction with an arbitrary HTTP payload. The response includes the following HTTP headers: * `X-Vertex-AI-Endpoint-Id`: ID of the Endpoint that served this prediction. * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's DeployedModel that served this prediction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:rawPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-streamRawPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:httpBody {:contentType string, :extensions [{}], :data string}}
  
  Perform a streaming online prediction with an arbitrary HTTP payload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:streamRawPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-predict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:instances [any], :parameters any}
  
  Perform an online prediction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:predict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-countTokens$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:contents [{:parts [GoogleCloudAiplatformV1Part], :role string}],
   :model string,
   :instances [any]}
  
  Perform a token counting."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:countTokens"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-generateContent$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: model
  
  Optional parameters: none
  
  Body: 
  
  {:generationConfig {:responseMimeType string,
                      :presencePenalty number,
                      :stopSequences [string],
                      :topP number,
                      :maxOutputTokens integer,
                      :frequencyPenalty number,
                      :topK number,
                      :candidateCount integer,
                      :temperature number},
   :tools [{:functionDeclarations [GoogleCloudAiplatformV1FunctionDeclaration],
            :retrieval GoogleCloudAiplatformV1Retrieval}],
   :safetySettings [{:method string,
                     :threshold string,
                     :category string}],
   :contents [{:parts [GoogleCloudAiplatformV1Part], :role string}],
   :systemInstruction {:parts [GoogleCloudAiplatformV1Part],
                       :role string}}
  
  Generate content with multimodal inputs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:model})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+model}:generateContent"
     #{:model}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-directRawPredict$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:input string, :methodName string}
  
  Perform an unary online prediction request to a gRPC model server for custom containers."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:directRawPredict"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-deployModel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: endpoint
  
  Optional parameters: none
  
  Body: 
  
  {:deployedModel {:serviceAccount string,
                   :modelVersionId string,
                   :disableContainerLogging boolean,
                   :automaticResources GoogleCloudAiplatformV1AutomaticResources,
                   :disableExplanations boolean,
                   :displayName string,
                   :explanationSpec GoogleCloudAiplatformV1ExplanationSpec,
                   :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                   :sharedResources string,
                   :createTime string,
                   :enableAccessLogging boolean,
                   :id string,
                   :privateEndpoints GoogleCloudAiplatformV1PrivateEndpoints,
                   :model string},
   :trafficSplit {}}
  
  Deploys a Model into this Endpoint, creating a DeployedModel within it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:endpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+endpoint}:deployModel"
     #{:endpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpoints-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TrainingPipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can use PipelineService.GetTrainingPipeline or other methods to check whether the cancellation succeeded or whether the pipeline completed despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead it becomes a pipeline with a TrainingPipeline.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and TrainingPipeline.state is set to `CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TrainingPipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, readMask, pageToken, pageSize
  
  Lists TrainingPipelines in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/trainingPipelines"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :modelToUpload {:description string,
                   :labels {},
                   :versionUpdateTime string,
                   :versionId string,
                   :predictSchemata GoogleCloudAiplatformV1PredictSchemata,
                   :artifactUri string,
                   :pipelineJob string,
                   :versionAliases [string],
                   :supportedOutputStorageFormats [string],
                   :containerSpec GoogleCloudAiplatformV1ModelContainerSpec,
                   :encryptionSpec GoogleCloudAiplatformV1EncryptionSpec,
                   :trainingPipeline string,
                   :metadataSchemaUri string,
                   :displayName string,
                   :explanationSpec GoogleCloudAiplatformV1ExplanationSpec,
                   :versionDescription string,
                   :name string,
                   :createTime string,
                   :metadataArtifact string,
                   :supportedInputStorageFormats [string],
                   :etag string,
                   :modelSourceInfo GoogleCloudAiplatformV1ModelSourceInfo,
                   :updateTime string,
                   :originalModelInfo GoogleCloudAiplatformV1ModelOriginalModelInfo,
                   :dataStats GoogleCloudAiplatformV1ModelDataStats,
                   :deployedModels [GoogleCloudAiplatformV1DeployedModelRef],
                   :supportedDeploymentResourcesTypes [string],
                   :versionCreateTime string,
                   :baseModelSource GoogleCloudAiplatformV1ModelBaseModelSource,
                   :metadata any,
                   :supportedExportFormats [GoogleCloudAiplatformV1ModelExportFormat]},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :name string,
   :trainingTaskMetadata any,
   :endTime string,
   :modelId string,
   :createTime string,
   :state string,
   :parentModel string,
   :updateTime string,
   :trainingTaskDefinition string,
   :inputDataConfig {:annotationSchemaUri string,
                     :timestampSplit GoogleCloudAiplatformV1TimestampSplit,
                     :bigqueryDestination GoogleCloudAiplatformV1BigQueryDestination,
                     :fractionSplit GoogleCloudAiplatformV1FractionSplit,
                     :predefinedSplit GoogleCloudAiplatformV1PredefinedSplit,
                     :annotationsFilter string,
                     :stratifiedSplit GoogleCloudAiplatformV1StratifiedSplit,
                     :datasetId string,
                     :gcsDestination GoogleCloudAiplatformV1GcsDestination,
                     :filterSplit GoogleCloudAiplatformV1FilterSplit,
                     :persistMlUseAssignment boolean,
                     :savedQueryId string},
   :trainingTaskInputs any,
   :error {:message string, :code integer, :details [{}]}}
  
  Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/trainingPipelines"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trainingPipelines-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-updateExplanationDataset$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: model
  
  Optional parameters: none
  
  Body: 
  
  {:examples {:presets GoogleCloudAiplatformV1Presets,
              :exampleGcsSource GoogleCloudAiplatformV1ExamplesExampleGcsSource,
              :neighborCount integer,
              :nearestNeighborSearchConfig any}}
  
  Incrementally update the dataset used for an examples model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:model})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+model}:updateExplanationDataset"
     #{:model}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-copy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encryptionSpec {:kmsKeyName string},
   :modelId string,
   :parentModel string,
   :sourceModel string}
  
  Copies an already existing Vertex AI Model into the specified Location. The source Model must exist in the same Project. When copying custom Models, the users themselves are responsible for Model.metadata content to be region-agnostic, as well as making sure that any resources (e.g. files) it depends on remain accessible."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/models:copy"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-setIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :bindings [GoogleIamV1Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :versionUpdateTime string,
   :versionId string,
   :predictSchemata {:instanceSchemaUri string,
                     :predictionSchemaUri string,
                     :parametersSchemaUri string},
   :artifactUri string,
   :pipelineJob string,
   :versionAliases [string],
   :supportedOutputStorageFormats [string],
   :containerSpec {:args [string],
                   :healthRoute string,
                   :imageUri string,
                   :healthProbe GoogleCloudAiplatformV1Probe,
                   :command [string],
                   :env [GoogleCloudAiplatformV1EnvVar],
                   :deploymentTimeout string,
                   :ports [GoogleCloudAiplatformV1Port],
                   :startupProbe GoogleCloudAiplatformV1Probe,
                   :grpcPorts [GoogleCloudAiplatformV1Port],
                   :sharedMemorySizeMb string,
                   :predictRoute string},
   :encryptionSpec {:kmsKeyName string},
   :trainingPipeline string,
   :metadataSchemaUri string,
   :displayName string,
   :explanationSpec {:metadata GoogleCloudAiplatformV1ExplanationMetadata,
                     :parameters GoogleCloudAiplatformV1ExplanationParameters},
   :versionDescription string,
   :name string,
   :createTime string,
   :metadataArtifact string,
   :supportedInputStorageFormats [string],
   :etag string,
   :modelSourceInfo {:copy boolean, :sourceType string},
   :updateTime string,
   :originalModelInfo {:model string},
   :dataStats {:validationAnnotationsCount string,
               :validationDataItemsCount string,
               :trainingDataItemsCount string,
               :testAnnotationsCount string,
               :trainingAnnotationsCount string,
               :testDataItemsCount string},
   :deployedModels [{:endpoint string, :deployedModelId string}],
   :supportedDeploymentResourcesTypes [string],
   :versionCreateTime string,
   :baseModelSource {:modelGardenSource GoogleCloudAiplatformV1ModelGardenSource,
                     :genieSource GoogleCloudAiplatformV1GenieSource},
   :metadata any,
   :supportedExportFormats [{:id string, :exportableContents [string]}]}
  
  Updates a Model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-testIamPermissions$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: permissions
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Model. A model cannot be deleted if any Endpoint resource has a DeployedModel based on the model in its deployed_models field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-mergeVersionAliases$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:versionAliases [string]}
  
  Merges a set of aliases for a Model version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:mergeVersionAliases"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-export$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:outputConfig {:imageDestination GoogleCloudAiplatformV1ContainerRegistryDestination,
                  :exportFormatId string,
                  :artifactDestination GoogleCloudAiplatformV1GcsDestination}}
  
  Exports a trained, exportable Model to a location specified by the user. A Model is considered to be exportable if it has at least one supported export format."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:export"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-getIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageSize, pageToken, readMask
  
  Lists Models in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/models"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-listVersions$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: readMask, filter, pageSize, orderBy, pageToken
  
  Lists versions of the specified model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:listVersions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-upload$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:modelId string,
   :model {:description string,
           :labels {},
           :versionUpdateTime string,
           :versionId string,
           :predictSchemata GoogleCloudAiplatformV1PredictSchemata,
           :artifactUri string,
           :pipelineJob string,
           :versionAliases [string],
           :supportedOutputStorageFormats [string],
           :containerSpec GoogleCloudAiplatformV1ModelContainerSpec,
           :encryptionSpec GoogleCloudAiplatformV1EncryptionSpec,
           :trainingPipeline string,
           :metadataSchemaUri string,
           :displayName string,
           :explanationSpec GoogleCloudAiplatformV1ExplanationSpec,
           :versionDescription string,
           :name string,
           :createTime string,
           :metadataArtifact string,
           :supportedInputStorageFormats [string],
           :etag string,
           :modelSourceInfo GoogleCloudAiplatformV1ModelSourceInfo,
           :updateTime string,
           :originalModelInfo GoogleCloudAiplatformV1ModelOriginalModelInfo,
           :dataStats GoogleCloudAiplatformV1ModelDataStats,
           :deployedModels [GoogleCloudAiplatformV1DeployedModelRef],
           :supportedDeploymentResourcesTypes [string],
           :versionCreateTime string,
           :baseModelSource GoogleCloudAiplatformV1ModelBaseModelSource,
           :metadata any,
           :supportedExportFormats [GoogleCloudAiplatformV1ModelExportFormat]},
   :parentModel string,
   :serviceAccount string}
  
  Uploads a Model artifact into Vertex AI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/models:upload"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-deleteVersion$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Model version. Model version can only be deleted if there are no DeployedModels created from it. Deleting the only version in the Model is not allowed. Use DeleteModel for deleting the Model instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:deleteVersion"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-import$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:modelEvaluation {:annotationSchemaUri string,
                     :explanationSpecs [GoogleCloudAiplatformV1ModelEvaluationModelEvaluationExplanationSpec],
                     :dataItemSchemaUri string,
                     :sliceDimensions [string],
                     :displayName string,
                     :name string,
                     :createTime string,
                     :metricsSchemaUri string,
                     :modelExplanation GoogleCloudAiplatformV1ModelExplanation,
                     :metadata any,
                     :metrics any}}
  
  Imports an externally generated ModelEvaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/evaluations:import"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, pageSize, filter
  
  Lists ModelEvaluations in a Model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/evaluations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ModelEvaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-slices-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ModelEvaluationSlice."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-slices-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize, readMask
  
  Lists ModelEvaluationSlices in a ModelEvaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/slices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-slices-batchImport$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:evaluatedAnnotations [{:type string,
                           :predictions [any],
                           :dataItemPayload any,
                           :errorAnalysisAnnotations [GoogleCloudAiplatformV1ErrorAnalysisAnnotation],
                           :evaluatedDataItemViewId string,
                           :explanations [GoogleCloudAiplatformV1EvaluatedAnnotationExplanation],
                           :groundTruths [any]}]}
  
  Imports a list of externally generated EvaluatedAnnotations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}:batchImport"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-evaluations-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, readMask, filter, pageToken
  
  Lists CustomJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/customJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a CustomJob. Starts asynchronous cancellation on the CustomJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetCustomJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the CustomJob is not deleted; instead it becomes a job with a CustomJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and CustomJob.state is set to `CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a CustomJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :name string,
   :jobSpec {:serviceAccount string,
             :protectedArtifactLocationId string,
             :enableWebAccess boolean,
             :scheduling GoogleCloudAiplatformV1Scheduling,
             :enableDashboardAccess boolean,
             :experimentRun string,
             :persistentResourceId string,
             :tensorboard string,
             :workerPoolSpecs [GoogleCloudAiplatformV1WorkerPoolSpec],
             :reservedIpRanges [string],
             :baseOutputDirectory GoogleCloudAiplatformV1GcsDestination,
             :experiment string,
             :models [string],
             :network string},
   :endTime string,
   :createTime string,
   :state string,
   :updateTime string,
   :webAccessUris {},
   :error {:message string, :code integer, :details [{}]}}
  
  Creates a CustomJob. A created CustomJob right away will be attempted to be run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/customJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a CustomJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customJobs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, pageSize
  
  Lists SpecialistPools in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/specialistPools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:specialistManagersCount integer,
   :pendingDataLabelingJobs [string],
   :specialistManagerEmails [string],
   :specialistWorkerEmails [string],
   :name string,
   :displayName string}
  
  Creates a SpecialistPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/specialistPools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:specialistManagersCount integer,
   :pendingDataLabelingJobs [string],
   :specialistManagerEmails [string],
   :specialistWorkerEmails [string],
   :name string,
   :displayName string}
  
  Updates a SpecialistPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a SpecialistPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a SpecialistPool as well as all Specialists in the pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-specialistPools-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Study by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inactiveReason string,
   :studySpec {:algorithm string,
               :measurementSelectionType string,
               :observationNoise string,
               :studyStoppingConfig GoogleCloudAiplatformV1StudySpecStudyStoppingConfig,
               :decayCurveStoppingSpec GoogleCloudAiplatformV1StudySpecDecayCurveAutomatedStoppingSpec,
               :medianAutomatedStoppingSpec GoogleCloudAiplatformV1StudySpecMedianAutomatedStoppingSpec,
               :parameters [GoogleCloudAiplatformV1StudySpecParameterSpec],
               :convexAutomatedStoppingSpec GoogleCloudAiplatformV1StudySpecConvexAutomatedStoppingSpec,
               :metrics [GoogleCloudAiplatformV1StudySpecMetricSpec]},
   :createTime string,
   :displayName string,
   :name string,
   :state string}
  
  Creates a Study. A resource name will be generated after creation of the Study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/studies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all the studies in a region for an associated project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/studies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-lookup$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string}
  
  Looks a study up using the user-defined display_name field instead of the fully qualified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/studies:lookup"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:clientId string,
   :customJob string,
   :startTime string,
   :measurements [{:stepCount string,
                   :elapsedDuration string,
                   :metrics [GoogleCloudAiplatformV1MeasurementMetric]}],
   :name string,
   :endTime string,
   :state string,
   :id string,
   :finalMeasurement {:stepCount string,
                      :elapsedDuration string,
                      :metrics [GoogleCloudAiplatformV1MeasurementMetric]},
   :infeasibleReason string,
   :webAccessUris {},
   :parameters [{:value any, :parameterId string}]}
  
  Adds a user provided Trial to a Study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/trials"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-listOptimalTrials$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Lists the pareto-optimal Trials for multi-objective Study or the optimal Trials for single-objective Study. The definition of pareto-optimal can be checked in wiki page. https://en.wikipedia.org/wiki/Pareto_efficiency"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/trials:listOptimalTrials"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-stop$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a Trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:stop"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-suggest$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:clientId string,
   :contexts [{:parameters [GoogleCloudAiplatformV1TrialParameter],
               :description string}],
   :suggestionCount integer}
  
  Adds one or more Trials to a Study, with parameter values suggested by Vertex AI Vizier. Returns a long-running operation associated with the generation of Trial suggestions. When this long-running operation succeeds, it will contain a SuggestTrialsResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/trials:suggest"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the Trials associated with a Study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/trials"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-checkTrialEarlyStoppingState$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: trialName
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Checks whether a Trial should stop or not. Returns a long-running operation. When the operation is successful, it will contain a CheckTrialEarlyStoppingStateResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:trialName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+trialName}:checkTrialEarlyStoppingState"
     #{:trialName}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-complete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:trialInfeasible boolean,
   :infeasibleReason string,
   :finalMeasurement {:stepCount string,
                      :elapsedDuration string,
                      :metrics [GoogleCloudAiplatformV1MeasurementMetric]}}
  
  Marks a Trial as complete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:complete"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-addTrialMeasurement$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: trialName
  
  Optional parameters: none
  
  Body: 
  
  {:measurement {:stepCount string,
                 :elapsedDuration string,
                 :metrics [GoogleCloudAiplatformV1MeasurementMetric]}}
  
  Adds a measurement of the objective metrics to a Trial. This measurement is assumed to have been taken before the Trial is complete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:trialName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+trialName}:addTrialMeasurement"
     #{:trialName}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: readMask, pageSize, filter, pageToken, orderBy
  
  Lists NotebookRuntimeTemplates in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/notebookRuntimeTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-testIamPermissions$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: permissions
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a NotebookRuntimeTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-getIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: notebookRuntimeTemplateId
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :machineSpec {:acceleratorCount integer,
                 :acceleratorType string,
                 :machineType string,
                 :tpuTopology string},
   :labels {},
   :isDefault boolean,
   :idleShutdownConfig {:idleTimeout string,
                        :idleShutdownDisabled boolean},
   :networkSpec {:subnetwork string,
                 :network string,
                 :enableInternetAccess boolean},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :notebookRuntimeType string,
   :updateTime string,
   :dataPersistentDiskSpec {:diskType string, :diskSizeGb string},
   :reservationAffinity {:values [string],
                         :consumeReservationType string,
                         :key string},
   :eucConfig {:bypassActasCheck boolean, :eucDisabled boolean},
   :networkTags [string],
   :shieldedVmConfig {:enableSecureBoot boolean}}
  
  Creates a NotebookRuntimeTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/notebookRuntimeTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a NotebookRuntimeTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notebookRuntimeTemplates-setIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :bindings [GoogleIamV1Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-batchRead$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboard
  
  Optional parameters: timeSeries
  
  Reads multiple TensorboardTimeSeries' data. The data point number limit is 1000 for scalars, 100 for tensors and blob references. If the number of data points stored is less than the limit, all data is returned. Otherwise, the number limit of data points is randomly selected from this time series and returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tensorboard})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboard}:batchRead"
     #{:tensorboard}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-readSize$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboard
  
  Optional parameters: none
  
  Returns the storage size for a given TensorBoard instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tensorboard})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboard}:readSize"
     #{:tensorboard}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :isDefault boolean,
   :runCount integer,
   :encryptionSpec {:kmsKeyName string},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :blobStoragePathPrefix string}
  
  Updates a Tensorboard."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, readMask, filter, pageSize
  
  Lists Tensorboards in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/tensorboards"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Tensorboard."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Tensorboard."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-readUsage$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboard
  
  Optional parameters: none
  
  Returns a list of monthly active users for a given TensorBoard instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tensorboard})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboard}:readUsage"
     #{:tensorboard}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :isDefault boolean,
   :runCount integer,
   :encryptionSpec {:kmsKeyName string},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :blobStoragePathPrefix string}
  
  Creates a Tensorboard."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/tensorboards"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:source string,
   :name string,
   :displayName string,
   :etag string,
   :description string,
   :createTime string,
   :labels {},
   :updateTime string}
  
  Updates a TensorboardExperiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, orderBy, filter, pageToken, readMask
  
  Lists TensorboardExperiments in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/experiments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TensorboardExperiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-batchCreate$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:parent string,
               :tensorboardTimeSeries GoogleCloudAiplatformV1TensorboardTimeSeries,
               :tensorboardTimeSeriesId string}]}
  
  Batch create TensorboardTimeSeries that belong to a TensorboardExperiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}:batchCreate"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-write$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboardExperiment
  
  Optional parameters: none
  
  Body: 
  
  {:writeRunDataRequests [{:tensorboardRun string,
                           :timeSeriesData [GoogleCloudAiplatformV1TimeSeriesData]}]}
  
  Write time series data points of multiple TensorboardTimeSeries in multiple TensorboardRun's. If any data fail to be ingested, an error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tensorboardExperiment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboardExperiment}:write"
     #{:tensorboardExperiment}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: tensorboardExperimentId
  
  Body: 
  
  {:source string,
   :name string,
   :displayName string,
   :etag string,
   :description string,
   :createTime string,
   :labels {},
   :updateTime string}
  
  Creates a TensorboardExperiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/experiments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TensorboardExperiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: tensorboardRunId
  
  Body: 
  
  {:displayName string,
   :labels {},
   :createTime string,
   :etag string,
   :description string,
   :updateTime string,
   :name string}
  
  Creates a TensorboardRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/runs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter, readMask
  
  Lists TensorboardRuns in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/runs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TensorboardRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-batchCreate$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:parent string,
               :tensorboardRun GoogleCloudAiplatformV1TensorboardRun,
               :tensorboardRunId string}]}
  
  Batch create TensorboardRuns."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/runs:batchCreate"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :labels {},
   :createTime string,
   :etag string,
   :description string,
   :updateTime string,
   :name string}
  
  Updates a TensorboardRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TensorboardRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-write$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboardRun
  
  Optional parameters: none
  
  Body: 
  
  {:tensorboardRun string,
   :timeSeriesData [{:tensorboardTimeSeriesId string,
                     :valueType string,
                     :values [GoogleCloudAiplatformV1TimeSeriesDataPoint]}]}
  
  Write time series data points into multiple TensorboardTimeSeries under a TensorboardRun. If any data fail to be ingested, an error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tensorboardRun})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboardRun}:write"
     #{:tensorboardRun}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, filter, orderBy, pageSize
  
  Lists TensorboardTimeSeries in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/timeSeries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-exportTensorboardTimeSeries$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboardTimeSeries
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :pageToken string,
   :pageSize integer,
   :orderBy string}
  
  Exports a TensorboardTimeSeries' data. Data is returned in paginated responses."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tensorboardTimeSeries})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboardTimeSeries}:exportTensorboardTimeSeries"
     #{:tensorboardTimeSeries}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :valueType string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :pluginData string,
   :updateTime string,
   :pluginName string,
   :metadata {:maxBlobSequenceLength string,
              :maxWallTime string,
              :maxStep string}}
  
  Updates a TensorboardTimeSeries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: tensorboardTimeSeriesId
  
  Body: 
  
  {:description string,
   :valueType string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :pluginData string,
   :updateTime string,
   :pluginName string,
   :metadata {:maxBlobSequenceLength string,
              :maxWallTime string,
              :maxStep string}}
  
  Creates a TensorboardTimeSeries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/timeSeries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TensorboardTimeSeries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-read$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: tensorboardTimeSeries
  
  Optional parameters: filter, maxDataPoints
  
  Reads a TensorboardTimeSeries' data. By default, if the number of data points stored is less than 1000, all data is returned. Otherwise, 1000 data points is randomly selected from this time series and returned. This value can be changed by changing max_data_points, which can't be greater than 10k."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tensorboardTimeSeries})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+tensorboardTimeSeries}:read"
     #{:tensorboardTimeSeries}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TensorboardTimeSeries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-readBlobData$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: timeSeries
  
  Optional parameters: blobIds
  
  Gets bytes of TensorboardBlobs. This is to allow reading blob data stored in consumer project's Cloud Storage bucket without users having to obtain Cloud Storage access permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:timeSeries})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+timeSeries}:readBlobData"
     #{:timeSeries}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-timeSeries-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-runs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-experiments-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tensorboards-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, readMask, pageToken
  
  Lists ModelDeploymentMonitoringJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/modelDeploymentMonitoringJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-pause$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses a ModelDeploymentMonitoringJob. If the job is running, the server makes a best effort to cancel the job. Will mark ModelDeploymentMonitoringJob.state to 'PAUSED'."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:pause"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-resume$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resumes a paused ModelDeploymentMonitoringJob. It will start to run from next scheduled time. A deleted ModelDeploymentMonitoringJob can't be resumed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:resume"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:bigqueryTables [{:logSource string,
                     :logType string,
                     :requestResponseLoggingSchemaVersion string,
                     :bigqueryTablePath string}],
   :labels {},
   :statsAnomaliesBaseDirectory {:outputUriPrefix string},
   :modelDeploymentMonitoringObjectiveConfigs [{:deployedModelId string,
                                                :objectiveConfig GoogleCloudAiplatformV1ModelMonitoringObjectiveConfig}],
   :scheduleState string,
   :loggingSamplingStrategy {:randomSampleConfig GoogleCloudAiplatformV1SamplingStrategyRandomSampleConfig},
   :encryptionSpec {:kmsKeyName string},
   :modelDeploymentMonitoringScheduleConfig {:monitorWindow string,
                                             :monitorInterval string},
   :displayName string,
   :predictInstanceSchemaUri string,
   :name string,
   :analysisInstanceSchemaUri string,
   :createTime string,
   :state string,
   :latestMonitoringPipelineMetadata {:status GoogleRpcStatus,
                                      :runTime string},
   :updateTime string,
   :nextScheduleTime string,
   :modelMonitoringAlertConfig {:emailAlertConfig GoogleCloudAiplatformV1ModelMonitoringAlertConfigEmailAlertConfig,
                                :enableLogging boolean,
                                :notificationChannels [string]},
   :error {:message string, :code integer, :details [{}]},
   :logTtl string,
   :samplePredictInstance any,
   :endpoint string,
   :enableMonitoringPipelineLogs boolean}
  
  Updates a ModelDeploymentMonitoringJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ModelDeploymentMonitoringJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bigqueryTables [{:logSource string,
                     :logType string,
                     :requestResponseLoggingSchemaVersion string,
                     :bigqueryTablePath string}],
   :labels {},
   :statsAnomaliesBaseDirectory {:outputUriPrefix string},
   :modelDeploymentMonitoringObjectiveConfigs [{:deployedModelId string,
                                                :objectiveConfig GoogleCloudAiplatformV1ModelMonitoringObjectiveConfig}],
   :scheduleState string,
   :loggingSamplingStrategy {:randomSampleConfig GoogleCloudAiplatformV1SamplingStrategyRandomSampleConfig},
   :encryptionSpec {:kmsKeyName string},
   :modelDeploymentMonitoringScheduleConfig {:monitorWindow string,
                                             :monitorInterval string},
   :displayName string,
   :predictInstanceSchemaUri string,
   :name string,
   :analysisInstanceSchemaUri string,
   :createTime string,
   :state string,
   :latestMonitoringPipelineMetadata {:status GoogleRpcStatus,
                                      :runTime string},
   :updateTime string,
   :nextScheduleTime string,
   :modelMonitoringAlertConfig {:emailAlertConfig GoogleCloudAiplatformV1ModelMonitoringAlertConfigEmailAlertConfig,
                                :enableLogging boolean,
                                :notificationChannels [string]},
   :error {:message string, :code integer, :details [{}]},
   :logTtl string,
   :samplePredictInstance any,
   :endpoint string,
   :enableMonitoringPipelineLogs boolean}
  
  Creates a ModelDeploymentMonitoringJob. It will run periodically on a configured interval."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/modelDeploymentMonitoringJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a ModelDeploymentMonitoringJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-searchModelDeploymentMonitoringStatsAnomalies$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: modelDeploymentMonitoringJob
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer,
   :deployedModelId string,
   :featureDisplayName string,
   :objectives [{:type string, :topFeatureCount integer}],
   :endTime string,
   :startTime string,
   :pageToken string}
  
  Searches Model Monitoring Statistics generated within a given time window."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:modelDeploymentMonitoringJob})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+modelDeploymentMonitoringJob}:searchModelDeploymentMonitoringStatsAnomalies"
     #{:modelDeploymentMonitoringJob}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-modelDeploymentMonitoringJobs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :instructionUri string,
   :datasets [string],
   :encryptionSpec {:kmsKeyName string},
   :activeLearningConfig {:maxDataItemPercentage integer,
                          :maxDataItemCount string,
                          :sampleConfig GoogleCloudAiplatformV1SampleConfig,
                          :trainingConfig GoogleCloudAiplatformV1TrainingConfig},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :inputs any,
   :specialistPools [string],
   :labelerCount integer,
   :error {:message string, :code integer, :details [{}]},
   :inputsSchemaUri string,
   :currentSpend {:nanos integer, :units string, :currencyCode string},
   :annotationLabels {},
   :labelingProgress integer}
  
  Creates a DataLabelingJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/dataLabelingJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize, readMask, orderBy
  
  Lists DataLabelingJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/dataLabelingJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DataLabelingJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DataLabelingJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a DataLabelingJob. Success of cancellation is not guaranteed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataLabelingJobs-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-resume$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:catchUp boolean}
  
  Resumes a paused Schedule to start scheduling new runs. Will mark Schedule.state to 'ACTIVE'. Only paused Schedule can be resumed. When the Schedule is resumed, new runs will be scheduled starting from the next execution time after the current time based on the time_specification in the Schedule. If Schedule.catchUp is set up true, all missed runs will be scheduled for backfill first."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:resume"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:nextRunTime string,
   :startTime string,
   :catchUp boolean,
   :displayName string,
   :name string,
   :endTime string,
   :lastPauseTime string,
   :maxConcurrentRunCount string,
   :createTime string,
   :state string,
   :cron string,
   :lastResumeTime string,
   :updateTime string,
   :allowQueueing boolean,
   :lastScheduledRunResponse {:runResponse string,
                              :scheduledRunTime string},
   :startedRunCount string,
   :createPipelineJobRequest {:parent string,
                              :pipelineJobId string,
                              :pipelineJob GoogleCloudAiplatformV1PipelineJob},
   :maxRunCount string}
  
  Updates an active or paused Schedule. When the Schedule is updated, new runs will be scheduled starting from the updated next execution time after the update time based on the time_specification in the updated Schedule. All unstarted runs before the update time will be skipped while already created runs will NOT be paused or canceled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-pause$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses a Schedule. Will mark Schedule.state to 'PAUSED'. If the schedule is paused, no new runs will be created. Already created runs will NOT be paused or canceled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:pause"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:nextRunTime string,
   :startTime string,
   :catchUp boolean,
   :displayName string,
   :name string,
   :endTime string,
   :lastPauseTime string,
   :maxConcurrentRunCount string,
   :createTime string,
   :state string,
   :cron string,
   :lastResumeTime string,
   :updateTime string,
   :allowQueueing boolean,
   :lastScheduledRunResponse {:runResponse string,
                              :scheduledRunTime string},
   :startedRunCount string,
   :createPipelineJobRequest {:parent string,
                              :pipelineJobId string,
                              :pipelineJob GoogleCloudAiplatformV1PipelineJob},
   :maxRunCount string}
  
  Creates a Schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/schedules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, filter
  
  Lists Schedules in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/schedules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an Index. An Index can only be deleted when all its DeployedIndexes had been undeployed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-removeDatapoints$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: index
  
  Optional parameters: none
  
  Body: 
  
  {:datapointIds [string]}
  
  Remove Datapoints from an Index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:index})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+index}:removeDatapoints"
     #{:index}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, filter, pageSize
  
  Lists Indexes in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/indexes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an Index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :indexStats {:vectorsCount string, :shardsCount integer},
   :encryptionSpec {:kmsKeyName string},
   :metadataSchemaUri string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :deployedIndexes [{:indexEndpoint string,
                      :deployedIndexId string,
                      :displayName string}],
   :updateTime string,
   :indexUpdateMethod string,
   :metadata any}
  
  Creates an Index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/indexes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :indexStats {:vectorsCount string, :shardsCount integer},
   :encryptionSpec {:kmsKeyName string},
   :metadataSchemaUri string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :deployedIndexes [{:indexEndpoint string,
                      :deployedIndexId string,
                      :displayName string}],
   :updateTime string,
   :indexUpdateMethod string,
   :metadata any}
  
  Updates an Index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-upsertDatapoints$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: index
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :datapoints [{:datapointId string,
                 :numericRestricts [GoogleCloudAiplatformV1IndexDatapointNumericRestriction],
                 :restricts [GoogleCloudAiplatformV1IndexDatapointRestriction],
                 :featureVector [number],
                 :crowdingTag GoogleCloudAiplatformV1IndexDatapointCrowdingTag}]}
  
  Add/update Datapoints into an Index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:index})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+index}:upsertDatapoints"
     #{:index}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexes-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-searchFeatures$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: location
  
  Optional parameters: pageSize, pageToken, query
  
  Searches Features matching a query in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+location}/featurestores:searchFeatures"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Featurestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-setIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :bindings [GoogleIamV1Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :onlineServingConfig {:scaling GoogleCloudAiplatformV1FeaturestoreOnlineServingConfigScaling,
                         :fixedNodeCount integer},
   :encryptionSpec {:kmsKeyName string},
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :onlineStorageTtlDays integer,
   :updateTime string}
  
  Updates the parameters of a single Featurestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-testIamPermissions$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: permissions
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: featurestoreId
  
  Body: 
  
  {:labels {},
   :onlineServingConfig {:scaling GoogleCloudAiplatformV1FeaturestoreOnlineServingConfigScaling,
                         :fixedNodeCount integer},
   :encryptionSpec {:kmsKeyName string},
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :onlineStorageTtlDays integer,
   :updateTime string}
  
  Creates a new Featurestore in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featurestores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single Featurestore. The Featurestore must not contain any EntityTypes or `force` must be set to true for the request to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-getIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-batchReadFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: featurestore
  
  Optional parameters: none
  
  Body: 
  
  {:passThroughFields [{:fieldName string}],
   :entityTypeSpecs [{:featureSelector GoogleCloudAiplatformV1FeatureSelector,
                      :entityTypeId string,
                      :settings [GoogleCloudAiplatformV1DestinationFeatureSetting]}],
   :startTime string,
   :destination {:tfrecordDestination GoogleCloudAiplatformV1TFRecordDestination,
                 :csvDestination GoogleCloudAiplatformV1CsvDestination,
                 :bigqueryDestination GoogleCloudAiplatformV1BigQueryDestination},
   :csvReadInstances {:gcsSource GoogleCloudAiplatformV1GcsSource},
   :bigqueryReadInstances {:inputUri string}}
  
  Batch reads Feature values from a Featurestore. This API enables batch reading Feature values, where each read instance in the batch may read Feature values of entities from one or more EntityTypes. Point-in-time correctness is guaranteed for Feature values of each read instance as of each instance's read timestamp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:featurestore})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+featurestore}:batchReadFeatureValues"
     #{:featurestore}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: readMask, pageToken, filter, pageSize, orderBy
  
  Lists Featurestores in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featurestores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-readFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: entityType
  
  Optional parameters: none
  
  Body: 
  
  {:featureSelector {:idMatcher GoogleCloudAiplatformV1IdMatcher},
   :entityId string}
  
  Reads Feature values of a specific entity of an EntityType. For reading feature values of multiple entities of an EntityType, please use StreamingReadFeatureValues."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+entityType}:readFeatureValues"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single EntityType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-setIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :bindings [GoogleIamV1Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-importFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: entityType
  
  Optional parameters: none
  
  Body: 
  
  {:disableOnlineServing boolean,
   :featureTimeField string,
   :csvSource {:gcsSource GoogleCloudAiplatformV1GcsSource},
   :workerCount integer,
   :featureSpecs [{:sourceField string, :id string}],
   :entityIdField string,
   :bigquerySource {:inputUri string},
   :disableIngestionAnalysis boolean,
   :featureTime string,
   :avroSource {:gcsSource GoogleCloudAiplatformV1GcsSource}}
  
  Imports Feature values into the Featurestore from a source storage. The progress of the import is tracked by the returned operation. The imported features are guaranteed to be visible to subsequent read operations after the operation is marked as successfully done. If an import operation fails, the Feature values returned from reads and exports may be inconsistent. If consistency is required, the caller must retry the same import request again and wait till the new operation returned is marked as successfully done. There are also scenarios where the caller can cause inconsistency. - Source data for import contains multiple distinct Feature values for the same entity ID and timestamp. - Source is modified during an import. This includes adding, updating, or removing source data and/or metadata. Examples of updating metadata include but are not limited to changing storage location, storage class, or retention policy. - Online serving cluster is under-provisioned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+entityType}:importFeatureValues"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :monitoringConfig {:categoricalThresholdConfig GoogleCloudAiplatformV1FeaturestoreMonitoringConfigThresholdConfig,
                      :snapshotAnalysis GoogleCloudAiplatformV1FeaturestoreMonitoringConfigSnapshotAnalysis,
                      :importFeaturesAnalysis GoogleCloudAiplatformV1FeaturestoreMonitoringConfigImportFeaturesAnalysis,
                      :numericalThresholdConfig GoogleCloudAiplatformV1FeaturestoreMonitoringConfigThresholdConfig},
   :description string,
   :offlineStorageTtlDays integer,
   :labels {},
   :etag string,
   :createTime string,
   :name string}
  
  Updates the parameters of a single EntityType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-testIamPermissions$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: permissions
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: entityTypeId
  
  Body: 
  
  {:updateTime string,
   :monitoringConfig {:categoricalThresholdConfig GoogleCloudAiplatformV1FeaturestoreMonitoringConfigThresholdConfig,
                      :snapshotAnalysis GoogleCloudAiplatformV1FeaturestoreMonitoringConfigSnapshotAnalysis,
                      :importFeaturesAnalysis GoogleCloudAiplatformV1FeaturestoreMonitoringConfigImportFeaturesAnalysis,
                      :numericalThresholdConfig GoogleCloudAiplatformV1FeaturestoreMonitoringConfigThresholdConfig},
   :description string,
   :offlineStorageTtlDays integer,
   :labels {},
   :etag string,
   :createTime string,
   :name string}
  
  Creates a new EntityType in a given Featurestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-deleteFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: entityType
  
  Optional parameters: none
  
  Body: 
  
  {:selectEntity {:entityIdSelector GoogleCloudAiplatformV1EntityIdSelector},
   :selectTimeRangeAndFeature {:timeRange GoogleTypeInterval,
                               :skipOnlineStorageDelete boolean,
                               :featureSelector GoogleCloudAiplatformV1FeatureSelector}}
  
  Delete Feature values from Featurestore. The progress of the deletion is tracked by the returned operation. The deleted feature values are guaranteed to be invisible to subsequent read operations after the operation is marked as successfully done. If a delete feature values operation fails, the feature values returned from reads and exports may be inconsistent. If consistency is required, the caller must retry the same delete request again and wait till the new operation returned is marked as successfully done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+entityType}:deleteFeatureValues"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-exportFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: entityType
  
  Optional parameters: none
  
  Body: 
  
  {:fullExport {:endTime string, :startTime string},
   :featureSelector {:idMatcher GoogleCloudAiplatformV1IdMatcher},
   :snapshotExport {:snapshotTime string, :startTime string},
   :destination {:tfrecordDestination GoogleCloudAiplatformV1TFRecordDestination,
                 :csvDestination GoogleCloudAiplatformV1CsvDestination,
                 :bigqueryDestination GoogleCloudAiplatformV1BigQueryDestination},
   :settings [{:featureId string, :destinationField string}]}
  
  Exports Feature values from all the entities of a target EntityType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+entityType}:exportFeatureValues"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single EntityType. The EntityType must not have any Features or `force` must be set to true for the request to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-getIamPolicy$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-writeFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: entityType
  
  Optional parameters: none
  
  Body: 
  
  {:payloads [{:entityId string, :featureValues {}}]}
  
  Writes Feature values of one or more entities of an EntityType. The Feature values are merged into existing entities if any. The Feature values to be written must have timestamp within the online storage retention."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+entityType}:writeFeatureValues"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, readMask, orderBy, pageSize, pageToken
  
  Lists EntityTypes in a given Featurestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-streamingReadFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: entityType
  
  Optional parameters: none
  
  Body: 
  
  {:featureSelector {:idMatcher GoogleCloudAiplatformV1IdMatcher},
   :entityIds [string]}
  
  Reads Feature values for multiple entities. Depending on their size, data for different entities may be broken up across multiple responses."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+entityType}:streamingReadFeatureValues"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: featureId
  
  Body: 
  
  {:description string,
   :labels {},
   :disableMonitoring boolean,
   :valueType string,
   :versionColumnName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :pointOfContact string,
   :monitoringStatsAnomalies [{:featureStatsAnomaly GoogleCloudAiplatformV1FeatureStatsAnomaly,
                               :objective string}]}
  
  Creates a new Feature in a given EntityType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/features"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :disableMonitoring boolean,
   :valueType string,
   :versionColumnName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :pointOfContact string,
   :monitoringStatsAnomalies [{:featureStatsAnomaly GoogleCloudAiplatformV1FeatureStatsAnomaly,
                               :objective string}]}
  
  Updates the parameters of a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-batchCreate$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:featureId string,
               :parent string,
               :feature GoogleCloudAiplatformV1Feature}]}
  
  Creates a batch of Features in a given EntityType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/features:batchCreate"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, filter, orderBy, latestStatsCount, pageSize
  
  Lists Features in a given EntityType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/features"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-entityTypes-features-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featurestores-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an IndexEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :publicEndpointDomainName string,
   :encryptionSpec {:kmsKeyName string},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :publicEndpointEnabled boolean,
   :deployedIndexes [{:automaticResources GoogleCloudAiplatformV1AutomaticResources,
                      :index string,
                      :displayName string,
                      :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                      :createTime string,
                      :reservedIpRanges [string],
                      :indexSyncTime string,
                      :enableAccessLogging boolean,
                      :id string,
                      :privateEndpoints GoogleCloudAiplatformV1IndexPrivateEndpoints,
                      :deploymentGroup string,
                      :deployedIndexAuthConfig GoogleCloudAiplatformV1DeployedIndexAuthConfig}],
   :updateTime string,
   :enablePrivateServiceConnect boolean,
   :privateServiceConnectConfig {:enablePrivateServiceConnect boolean,
                                 :projectAllowlist [string]},
   :network string}
  
  Updates an IndexEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-undeployIndex$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: indexEndpoint
  
  Optional parameters: none
  
  Body: 
  
  {:deployedIndexId string}
  
  Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all resources it's using."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:indexEndpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+indexEndpoint}:undeployIndex"
     #{:indexEndpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :publicEndpointDomainName string,
   :encryptionSpec {:kmsKeyName string},
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :publicEndpointEnabled boolean,
   :deployedIndexes [{:automaticResources GoogleCloudAiplatformV1AutomaticResources,
                      :index string,
                      :displayName string,
                      :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                      :createTime string,
                      :reservedIpRanges [string],
                      :indexSyncTime string,
                      :enableAccessLogging boolean,
                      :id string,
                      :privateEndpoints GoogleCloudAiplatformV1IndexPrivateEndpoints,
                      :deploymentGroup string,
                      :deployedIndexAuthConfig GoogleCloudAiplatformV1DeployedIndexAuthConfig}],
   :updateTime string,
   :enablePrivateServiceConnect boolean,
   :privateServiceConnectConfig {:enablePrivateServiceConnect boolean,
                                 :projectAllowlist [string]},
   :network string}
  
  Creates an IndexEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/indexEndpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-readIndexDatapoints$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: indexEndpoint
  
  Optional parameters: none
  
  Body: 
  
  {:deployedIndexId string, :ids [string]}
  
  Reads the datapoints/vectors of the given IDs. A maximum of 1000 datapoints can be retrieved in a batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:indexEndpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+indexEndpoint}:readIndexDatapoints"
     #{:indexEndpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an IndexEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: readMask, pageSize, filter, pageToken
  
  Lists IndexEndpoints in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/indexEndpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-mutateDeployedIndex$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: indexEndpoint
  
  Optional parameters: none
  
  Body: 
  
  {:automaticResources {:minReplicaCount integer,
                        :maxReplicaCount integer},
   :index string,
   :displayName string,
   :dedicatedResources {:machineSpec GoogleCloudAiplatformV1MachineSpec,
                        :maxReplicaCount integer,
                        :minReplicaCount integer,
                        :autoscalingMetricSpecs [GoogleCloudAiplatformV1AutoscalingMetricSpec]},
   :createTime string,
   :reservedIpRanges [string],
   :indexSyncTime string,
   :enableAccessLogging boolean,
   :id string,
   :privateEndpoints {:matchGrpcAddress string,
                      :pscAutomatedEndpoints [GoogleCloudAiplatformV1PscAutomatedEndpoints],
                      :serviceAttachment string},
   :deploymentGroup string,
   :deployedIndexAuthConfig {:authProvider GoogleCloudAiplatformV1DeployedIndexAuthConfigAuthProvider}}
  
  Update an existing DeployedIndex under an IndexEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:indexEndpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+indexEndpoint}:mutateDeployedIndex"
     #{:indexEndpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-deployIndex$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: indexEndpoint
  
  Optional parameters: none
  
  Body: 
  
  {:deployedIndex {:automaticResources GoogleCloudAiplatformV1AutomaticResources,
                   :index string,
                   :displayName string,
                   :dedicatedResources GoogleCloudAiplatformV1DedicatedResources,
                   :createTime string,
                   :reservedIpRanges [string],
                   :indexSyncTime string,
                   :enableAccessLogging boolean,
                   :id string,
                   :privateEndpoints GoogleCloudAiplatformV1IndexPrivateEndpoints,
                   :deploymentGroup string,
                   :deployedIndexAuthConfig GoogleCloudAiplatformV1DeployedIndexAuthConfig}}
  
  Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty Indexes can be deployed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:indexEndpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+indexEndpoint}:deployIndex"
     #{:indexEndpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-findNeighbors$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: indexEndpoint
  
  Optional parameters: none
  
  Body: 
  
  {:returnFullDatapoint boolean,
   :deployedIndexId string,
   :queries [{:neighborCount integer,
              :perCrowdingAttributeNeighborCount integer,
              :approximateNeighborCount integer,
              :datapoint GoogleCloudAiplatformV1IndexDatapoint,
              :fractionLeafNodesToSearchOverride number}]}
  
  Finds the nearest neighbors of each vector within the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:indexEndpoint})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+indexEndpoint}:findNeighbors"
     #{:indexEndpoint}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-indexEndpoints-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batchPredictionJobs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: filter, readMask, pageToken, pageSize
  
  Lists BatchPredictionJobs in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/batchPredictionJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batchPredictionJobs-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a BatchPredictionJob. Can only be called on jobs that already finished."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batchPredictionJobs-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a BatchPredictionJob. Starts asynchronous cancellation on the BatchPredictionJob. The server makes the best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetBatchPredictionJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On a successful cancellation, the BatchPredictionJob is not deleted;instead its BatchPredictionJob.state is set to `CANCELLED`. Any files already outputted by the job are not deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batchPredictionJobs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a BatchPredictionJob"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batchPredictionJobs-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serviceAccount string,
   :modelVersionId string,
   :labels {},
   :disableContainerLogging boolean,
   :modelParameters any,
   :outputInfo {:bigqueryOutputDataset string,
                :bigqueryOutputTable string,
                :gcsOutputDirectory string},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :explanationSpec {:metadata GoogleCloudAiplatformV1ExplanationMetadata,
                     :parameters GoogleCloudAiplatformV1ExplanationParameters},
   :dedicatedResources {:maxReplicaCount integer,
                        :startingReplicaCount integer,
                        :machineSpec GoogleCloudAiplatformV1MachineSpec},
   :completionStats {:incompleteCount string,
                     :successfulForecastPointCount string,
                     :failedCount string,
                     :successfulCount string},
   :name string,
   :endTime string,
   :createTime string,
   :state string,
   :updateTime string,
   :outputConfig {:bigqueryDestination GoogleCloudAiplatformV1BigQueryDestination,
                  :predictionsFormat string,
                  :gcsDestination GoogleCloudAiplatformV1GcsDestination},
   :unmanagedContainerModel {:predictSchemata GoogleCloudAiplatformV1PredictSchemata,
                             :artifactUri string,
                             :containerSpec GoogleCloudAiplatformV1ModelContainerSpec},
   :partialFailures [{:message string, :code integer, :details [{}]}],
   :error {:message string, :code integer, :details [{}]},
   :instanceConfig {:keyField string,
                    :instanceType string,
                    :excludedFields [string],
                    :includedFields [string]},
   :generateExplanation boolean,
   :inputConfig {:instancesFormat string,
                 :gcsSource GoogleCloudAiplatformV1GcsSource,
                 :bigquerySource GoogleCloudAiplatformV1BigQuerySource},
   :manualBatchTuningParameters {:batchSize integer},
   :resourcesConsumed {:replicaHours number},
   :model string}
  
  Creates a BatchPredictionJob. A BatchPredictionJob once created will right away be attempted to start."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/batchPredictionJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, filter, pageSize
  
  Lists FeatureOnlineStores in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureOnlineStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: featureOnlineStoreId
  
  Body: 
  
  {:labels {},
   :optimized {},
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :dedicatedServingEndpoint {:publicEndpointDomainName string},
   :bigtable {:autoScaling GoogleCloudAiplatformV1FeatureOnlineStoreBigtableAutoScaling}}
  
  Creates a new FeatureOnlineStore in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureOnlineStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :optimized {},
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :dedicatedServingEndpoint {:publicEndpointDomainName string},
   :bigtable {:autoScaling GoogleCloudAiplatformV1FeatureOnlineStoreBigtableAutoScaling}}
  
  Updates the parameters of a single FeatureOnlineStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single FeatureOnlineStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: featureViewId, runSyncImmediately
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :etag string,
   :syncConfig {:cron string},
   :indexConfig {:distanceMeasureType string,
                 :bruteForceConfig GoogleCloudAiplatformV1FeatureViewIndexConfigBruteForceConfig,
                 :filterColumns [string],
                 :treeAhConfig GoogleCloudAiplatformV1FeatureViewIndexConfigTreeAHConfig,
                 :embeddingColumn string,
                 :embeddingDimension integer,
                 :crowdingColumn string},
   :updateTime string,
   :bigQuerySource {:entityIdColumns [string], :uri string},
   :featureRegistrySource {:featureGroups [GoogleCloudAiplatformV1FeatureViewFeatureRegistrySourceFeatureGroup],
                           :projectNumber string}}
  
  Creates a new FeatureView in a given FeatureOnlineStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureViews"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single FeatureView."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageToken, pageSize
  
  Lists FeatureViews in a given FeatureOnlineStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureViews"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-fetchFeatureValues$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: featureView
  
  Optional parameters: none
  
  Body: 
  
  {:dataKey {:compositeKey GoogleCloudAiplatformV1FeatureViewDataKeyCompositeKey,
             :key string},
   :dataFormat string}
  
  Fetch feature values under a FeatureView."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:featureView})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+featureView}:fetchFeatureValues"
     #{:featureView}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :etag string,
   :syncConfig {:cron string},
   :indexConfig {:distanceMeasureType string,
                 :bruteForceConfig GoogleCloudAiplatformV1FeatureViewIndexConfigBruteForceConfig,
                 :filterColumns [string],
                 :treeAhConfig GoogleCloudAiplatformV1FeatureViewIndexConfigTreeAHConfig,
                 :embeddingColumn string,
                 :embeddingDimension integer,
                 :crowdingColumn string},
   :updateTime string,
   :bigQuerySource {:entityIdColumns [string], :uri string},
   :featureRegistrySource {:featureGroups [GoogleCloudAiplatformV1FeatureViewFeatureRegistrySourceFeatureGroup],
                           :projectNumber string}}
  
  Updates the parameters of a single FeatureView."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-searchNearestEntities$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: featureView
  
  Optional parameters: none
  
  Body: 
  
  {:query {:perCrowdingAttributeNeighborCount integer,
           :neighborCount integer,
           :stringFilters [GoogleCloudAiplatformV1NearestNeighborQueryStringFilter],
           :embedding GoogleCloudAiplatformV1NearestNeighborQueryEmbedding,
           :parameters GoogleCloudAiplatformV1NearestNeighborQueryParameters,
           :entityId string},
   :returnFullEntity boolean}
  
  Search the nearest entities under a FeatureView. Search only works for indexable feature view; if a feature view isn't indexable, returns Invalid argument response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:featureView})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+featureView}:searchNearestEntities"
     #{:featureView}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single FeatureView."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-sync$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: featureView
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Triggers on-demand sync for the FeatureView."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:featureView})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+featureView}:sync"
     #{:featureView}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-featureViewSyncs-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single FeatureViewSync."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-featureViewSyncs-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageToken, pageSize
  
  Lists FeatureViewSyncs in a given FeatureView."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/featureViewSyncs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-operations-listWait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-featureViews-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-featureOnlineStores-operations-listWait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a PersistentResource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-reboot$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Reboots a PersistentResource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:reboot"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-create$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: persistentResourceId
  
  Body: 
  
  {:labels {},
   :resourceRuntime {},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :name string,
   :createTime string,
   :reservedIpRanges [string],
   :state string,
   :updateTime string,
   :error {:message string, :code integer, :details [{}]},
   :resourcePools [{:diskSpec GoogleCloudAiplatformV1DiskSpec,
                    :autoscalingSpec GoogleCloudAiplatformV1ResourcePoolAutoscalingSpec,
                    :usedReplicaCount string,
                    :replicaCount string,
                    :machineSpec GoogleCloudAiplatformV1MachineSpec,
                    :id string}],
   :network string,
   :resourceRuntimeSpec {:raySpec GoogleCloudAiplatformV1RaySpec,
                         :serviceAccountSpec GoogleCloudAiplatformV1ServiceAccountSpec}}
  
  Creates a PersistentResource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/persistentResources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a PersistentResource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-patch$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :resourceRuntime {},
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :name string,
   :createTime string,
   :reservedIpRanges [string],
   :state string,
   :updateTime string,
   :error {:message string, :code integer, :details [{}]},
   :resourcePools [{:diskSpec GoogleCloudAiplatformV1DiskSpec,
                    :autoscalingSpec GoogleCloudAiplatformV1ResourcePoolAutoscalingSpec,
                    :usedReplicaCount string,
                    :replicaCount string,
                    :machineSpec GoogleCloudAiplatformV1MachineSpec,
                    :id string}],
   :network string,
   :resourceRuntimeSpec {:raySpec GoogleCloudAiplatformV1RaySpec,
                         :serviceAccountSpec GoogleCloudAiplatformV1ServiceAccountSpec}}
  
  Updates a PersistentResource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists PersistentResources in a Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+parent}/persistentResources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-operations-delete$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-operations-list$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-operations-get$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-operations-cancel$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-persistentResources-operations-wait$
  "https://cloud.google.com/vertex-ai
  
  Required parameters: name
  
  Optional parameters: timeout
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://aiplatform.googleapis.com/"
     "v1/{+name}:wait"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
