(ns happygapi.documentai.projects
  "Cloud Document AI API: projects.
  Service to parse structured information from unstructured or semi-structured documents using state-of-the-art Google AI such as natural language, computer vision, translation, and AutoML.
  See: https://cloud.google.com/document-ai/docs/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn operations-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-list$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-fetchProcessorTypes$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: none
  
  Fetches processor types. Note that we don't use ListProcessorTypes here, because it isn't paginated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}:fetchProcessorTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-disable$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disables a processor"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:disable"
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

(defn locations-processors-setDefaultProcessorVersion$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: processor
  
  Optional parameters: none
  
  Body: 
  
  {:defaultProcessorVersion string}
  
  Set the default (active) version of a Processor that will be used in ProcessDocument and BatchProcessDocuments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:processor})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+processor}:setDefaultProcessorVersion"
     #{:processor}
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

(defn locations-processors-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a processor detail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-enable$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Enables a processor"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:enable"
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

(defn locations-processors-create$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :kmsKeyName string,
   :processorVersionAliases [{:processorVersion string, :alias string}],
   :processEndpoint string,
   :defaultProcessorVersion string}
  
  Creates a processor from the ProcessorType provided. The processor will be at `ENABLED` state by default after its creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processors"
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

(defn locations-processors-process$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :rawDocument {:content string, :mimeType string, :displayName string},
   :processOptions {:ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :fromEnd integer,
                    :fromStart integer,
                    :schemaOverride GoogleCloudDocumentaiV1DocumentSchema},
   :fieldMask string,
   :skipHumanReview boolean,
   :inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
                    :content string,
                    :textStyles [GoogleCloudDocumentaiV1DocumentStyle],
                    :shardInfo GoogleCloudDocumentaiV1DocumentShardInfo,
                    :entities [GoogleCloudDocumentaiV1DocumentEntity],
                    :entityRelations [GoogleCloudDocumentaiV1DocumentEntityRelation],
                    :pages [GoogleCloudDocumentaiV1DocumentPage],
                    :mimeType string,
                    :revisions [GoogleCloudDocumentaiV1DocumentRevision],
                    :error GoogleRpcStatus,
                    :uri string,
                    :text string},
   :gcsDocument {:gcsUri string, :mimeType string}}
  
  Processes a single document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:process"
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

(defn locations-processors-delete$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes all artifacts associated with this processor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-list$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all processors which belong to this project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processors-batchProcess$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inputDocuments {:gcsPrefix GoogleCloudDocumentaiV1GcsPrefix,
                    :gcsDocuments GoogleCloudDocumentaiV1GcsDocuments},
   :processOptions {:ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :fromEnd integer,
                    :fromStart integer,
                    :schemaOverride GoogleCloudDocumentaiV1DocumentSchema},
   :labels {},
   :skipHumanReview boolean,
   :documentOutputConfig {:gcsOutputConfig GoogleCloudDocumentaiV1DocumentOutputConfigGcsOutputConfig}}
  
  LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in the [Document] format."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:batchProcess"
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

(defn locations-processors-processorVersions-undeploy$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeploys the processor version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:undeploy"
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

(defn locations-processors-processorVersions-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a processor version detail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-processorVersions-process$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :rawDocument {:content string, :mimeType string, :displayName string},
   :processOptions {:ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :fromEnd integer,
                    :fromStart integer,
                    :schemaOverride GoogleCloudDocumentaiV1DocumentSchema},
   :fieldMask string,
   :skipHumanReview boolean,
   :inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
                    :content string,
                    :textStyles [GoogleCloudDocumentaiV1DocumentStyle],
                    :shardInfo GoogleCloudDocumentaiV1DocumentShardInfo,
                    :entities [GoogleCloudDocumentaiV1DocumentEntity],
                    :entityRelations [GoogleCloudDocumentaiV1DocumentEntityRelation],
                    :pages [GoogleCloudDocumentaiV1DocumentPage],
                    :mimeType string,
                    :revisions [GoogleCloudDocumentaiV1DocumentRevision],
                    :error GoogleRpcStatus,
                    :uri string,
                    :text string},
   :gcsDocument {:gcsUri string, :mimeType string}}
  
  Processes a single document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:process"
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

(defn locations-processors-processorVersions-delete$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the processor version, all artifacts under the processor version will be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-processorVersions-train$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customDocumentExtractionOptions {:trainingMethod string},
   :documentSchema {:displayName string,
                    :description string,
                    :metadata GoogleCloudDocumentaiV1DocumentSchemaMetadata,
                    :entityTypes [GoogleCloudDocumentaiV1DocumentSchemaEntityType]},
   :foundationModelTuningOptions {:learningRateMultiplier number,
                                  :trainSteps integer},
   :baseProcessorVersion string,
   :inputData {:trainingDocuments GoogleCloudDocumentaiV1BatchDocumentsInputConfig,
               :testDocuments GoogleCloudDocumentaiV1BatchDocumentsInputConfig},
   :processorVersion {:modelType string,
                      :deprecationInfo GoogleCloudDocumentaiV1ProcessorVersionDeprecationInfo,
                      :kmsKeyVersionName string,
                      :displayName string,
                      :name string,
                      :createTime string,
                      :state string,
                      :googleManaged boolean,
                      :latestEvaluation GoogleCloudDocumentaiV1EvaluationReference,
                      :kmsKeyName string,
                      :documentSchema GoogleCloudDocumentaiV1DocumentSchema}}
  
  Trains a new processor version. Operation metadata is returned as TrainProcessorVersionMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processorVersions:train"
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

(defn locations-processors-processorVersions-list$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all versions of a processor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processorVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processors-processorVersions-batchProcess$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inputDocuments {:gcsPrefix GoogleCloudDocumentaiV1GcsPrefix,
                    :gcsDocuments GoogleCloudDocumentaiV1GcsDocuments},
   :processOptions {:ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :fromEnd integer,
                    :fromStart integer,
                    :schemaOverride GoogleCloudDocumentaiV1DocumentSchema},
   :labels {},
   :skipHumanReview boolean,
   :documentOutputConfig {:gcsOutputConfig GoogleCloudDocumentaiV1DocumentOutputConfigGcsOutputConfig}}
  
  LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in the [Document] format."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:batchProcess"
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

(defn locations-processors-processorVersions-evaluateProcessorVersion$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: processorVersion
  
  Optional parameters: none
  
  Body: 
  
  {:evaluationDocuments {:gcsPrefix GoogleCloudDocumentaiV1GcsPrefix,
                         :gcsDocuments GoogleCloudDocumentaiV1GcsDocuments}}
  
  Evaluates a ProcessorVersion against annotated documents, producing an Evaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:processorVersion})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+processorVersion}:evaluateProcessorVersion"
     #{:processorVersion}
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

(defn locations-processors-processorVersions-deploy$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deploys the processor version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:deploy"
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

(defn locations-processors-processorVersions-evaluations-list$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Retrieves a set of evaluations for a given processor version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-processorVersions-evaluations-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific evaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-humanReviewConfig-reviewDocument$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: humanReviewConfig
  
  Optional parameters: none
  
  Body: 
  
  {:priority string,
   :inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
                    :content string,
                    :textStyles [GoogleCloudDocumentaiV1DocumentStyle],
                    :shardInfo GoogleCloudDocumentaiV1DocumentShardInfo,
                    :entities [GoogleCloudDocumentaiV1DocumentEntity],
                    :entityRelations [GoogleCloudDocumentaiV1DocumentEntityRelation],
                    :pages [GoogleCloudDocumentaiV1DocumentPage],
                    :mimeType string,
                    :revisions [GoogleCloudDocumentaiV1DocumentRevision],
                    :error GoogleRpcStatus,
                    :uri string,
                    :text string},
   :enableSchemaValidation boolean,
   :documentSchema {:displayName string,
                    :description string,
                    :metadata GoogleCloudDocumentaiV1DocumentSchemaMetadata,
                    :entityTypes [GoogleCloudDocumentaiV1DocumentSchemaEntityType]}}
  
  Send a document for Human Review. The input document should be processed by the specified processor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:humanReviewConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+humanReviewConfig}:reviewDocument"
     #{:humanReviewConfig}
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

(defn locations-processorTypes-list$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the processor types that exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processorTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processorTypes-get$
  "https://cloud.google.com/document-ai/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a processor type detail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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
