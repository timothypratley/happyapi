(ns happygapi.contentwarehouse.projects
  "Document AI Warehouse API: projects.
  
  See: https://cloud.google.com/document-warehouse/docs/overview"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn fetchAcl$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects/fetchAcl
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:projectOwner boolean,
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not exist. Returns an empty policy if the resource exists but does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+resource}:fetchAcl"
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

(defn setAcl$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects/setAcl
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:projectOwner boolean,
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :policy {:bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string,
            :version integer}}
  
  Sets the access control policy for a resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+resource}:setAcl"
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

(defn locations-getStatus$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations/getStatus
  
  Required parameters: location
  
  Optional parameters: none
  
  Get the project status."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+location}:getStatus"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-initialize$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations/initialize
  
  Required parameters: location
  
  Optional parameters: none
  
  Body: 
  
  {:enableCalUserEmailLogging boolean,
   :documentCreatorDefaultRole string,
   :databaseType string,
   :accessControlMode string,
   :kmsKey string}
  
  Provisions resources for given tenant project. Returns a long running operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+location}:initialize"
     #{:location}
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

(defn locations-runPipeline$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations/runPipeline
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :gcsIngestPipeline {:processorType string,
                       :pipelineConfig GoogleCloudContentwarehouseV1IngestPipelineConfig,
                       :inputPath string,
                       :schemaName string,
                       :skipIngestedDocuments boolean},
   :gcsIngestWithDocAiProcessorsPipeline {:skipIngestedDocuments boolean,
                                          :splitClassifyProcessorInfo GoogleCloudContentwarehouseV1ProcessorInfo,
                                          :extractProcessorInfos [GoogleCloudContentwarehouseV1ProcessorInfo],
                                          :inputPath string,
                                          :pipelineConfig GoogleCloudContentwarehouseV1IngestPipelineConfig,
                                          :processorResultsFolderPath string},
   :exportCdwPipeline {:trainingSplitRatio number,
                       :documents [string],
                       :docAiDataset string,
                       :exportFolderPath string},
   :processWithDocAiPipeline {:processorResultsFolderPath string,
                              :processorInfo GoogleCloudContentwarehouseV1ProcessorInfo,
                              :documents [string],
                              :exportFolderPath string}}
  
  Run a predefined pipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:runPipeline"
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

(defn locations-documentSchemas-list$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists document schemas."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/documentSchemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-documentSchemas-delete$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a document schema. Returns NOT_FOUND if the document schema does not exist. Returns BAD_REQUEST if the document schema has documents depending on it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-documentSchemas-get$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a document schema. Returns NOT_FOUND if the document schema does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-documentSchemas-create$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :createTime string,
   :propertyDefinitions [{:propertyTypeOptions GoogleCloudContentwarehouseV1PropertyTypeOptions,
                          :enumTypeOptions GoogleCloudContentwarehouseV1EnumTypeOptions,
                          :displayName string,
                          :isFilterable boolean,
                          :name string,
                          :isSearchable boolean,
                          :retrievalImportance string,
                          :schemaSources [GoogleCloudContentwarehouseV1PropertyDefinitionSchemaSource],
                          :isMetadata boolean,
                          :integerTypeOptions GoogleCloudContentwarehouseV1IntegerTypeOptions,
                          :textTypeOptions GoogleCloudContentwarehouseV1TextTypeOptions,
                          :isRequired boolean,
                          :timestampTypeOptions GoogleCloudContentwarehouseV1TimestampTypeOptions,
                          :floatTypeOptions GoogleCloudContentwarehouseV1FloatTypeOptions,
                          :dateTimeTypeOptions GoogleCloudContentwarehouseV1DateTimeTypeOptions,
                          :mapTypeOptions GoogleCloudContentwarehouseV1MapTypeOptions,
                          :isRepeatable boolean}],
   :name string,
   :displayName string,
   :documentIsFolder boolean,
   :updateTime string}
  
  Creates a document schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/documentSchemas"
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

(defn locations-documentSchemas-patch$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:documentSchema {:description string,
                    :createTime string,
                    :propertyDefinitions [GoogleCloudContentwarehouseV1PropertyDefinition],
                    :name string,
                    :displayName string,
                    :documentIsFolder boolean,
                    :updateTime string}}
  
  Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the Document Schema is non-empty and does not equal the existing name. Supports only appending new properties, adding new ENUM possible values, and updating the EnumTypeOptions.validation_check_disabled flag for ENUM possible values. Updating existing properties will result into INVALID_ARGUMENT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-ruleSets-get$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-ruleSets-delete$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a ruleset. Returns NOT_FOUND if the document does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-ruleSets-create$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :source string,
   :rules [{:condition string,
            :ruleId string,
            :actions [GoogleCloudContentwarehouseV1Action],
            :triggerType string,
            :description string}],
   :name string}
  
  Creates a ruleset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/ruleSets"
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

(defn locations-ruleSets-patch$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:ruleSet {:description string,
             :source string,
             :rules [GoogleCloudContentwarehouseV1Rule],
             :name string}}
  
  Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset is non-empty and does not equal the existing name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-ruleSets-list$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists rulesets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/ruleSets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-synonymSets-list$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns all SynonymSets (for all contexts) for the specified location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/synonymSets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-synonymSets-patch$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :context string, :synonyms [{:words [string]}]}
  
  Remove the existing SynonymSet for the context and replaces it with a new one. Throws a NOT_FOUND exception if the SynonymSet is not found."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-synonymSets-get$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a SynonymSet for a particular context. Throws a NOT_FOUND exception if the Synonymset does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-synonymSets-create$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :context string, :synonyms [{:words [string]}]}
  
  Creates a SynonymSet for a single context. Throws an ALREADY_EXISTS exception if a synonymset already exists for the context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/synonymSets"
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

(defn locations-synonymSets-delete$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a SynonymSet for a given context. Throws a NOT_FOUND exception if the SynonymSet is not found."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-documents-linkedTargets$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/linkedTargets
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Return all target document-links from the document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/linkedTargets"
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

(defn locations-documents-get$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Gets a document. Returns NOT_FOUND if the document does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:get"
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

(defn locations-documents-patch$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:document {:properties [GoogleCloudContentwarehouseV1Property],
              :creator string,
              :rawDocumentPath string,
              :textExtractionDisabled boolean,
              :textExtractionEnabled boolean,
              :dispositionTime string,
              :displayName string,
              :documentSchemaName string,
              :name string,
              :cloudAiDocument GoogleCloudDocumentaiV1Document,
              :createTime string,
              :title string,
              :updateTime string,
              :contentCategory string,
              :rawDocumentFileType string,
              :updater string,
              :referenceId string,
              :displayUri string,
              :plainText string,
              :legalHold boolean,
              :inlineRawDocument string},
   :updateOptions {:updateType string,
                   :updateMask string,
                   :mergeFieldsOptions GoogleCloudContentwarehouseV1MergeFieldsOptions},
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :cloudAiDocumentOption {:customizedEntitiesPropertiesConversions {},
                           :enableEntitiesConversions boolean}}
  
  Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does not equal the existing name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-documents-fetchAcl$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/fetchAcl
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:projectOwner boolean,
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not exist. Returns an empty policy if the resource exists but does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+resource}:fetchAcl"
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

(defn locations-documents-create$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string,
            :version integer},
   :document {:properties [GoogleCloudContentwarehouseV1Property],
              :creator string,
              :rawDocumentPath string,
              :textExtractionDisabled boolean,
              :textExtractionEnabled boolean,
              :dispositionTime string,
              :displayName string,
              :documentSchemaName string,
              :name string,
              :cloudAiDocument GoogleCloudDocumentaiV1Document,
              :createTime string,
              :title string,
              :updateTime string,
              :contentCategory string,
              :rawDocumentFileType string,
              :updater string,
              :referenceId string,
              :displayUri string,
              :plainText string,
              :legalHold boolean,
              :inlineRawDocument string},
   :createMask string,
   :cloudAiDocumentOption {:customizedEntitiesPropertiesConversions {},
                           :enableEntitiesConversions boolean},
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Creates a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/documents"
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

(defn locations-documents-linkedSources$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/linkedSources
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string,
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :pageSize integer}
  
  Return all source document-links from the document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/linkedSources"
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

(defn locations-documents-delete$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Deletes a document. Returns NOT_FOUND if the document does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:delete"
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

(defn locations-documents-search$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/search
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:totalResultSize string,
   :offset integer,
   :histogramQueries [{:requirePreciseResultSize boolean,
                       :filters GoogleCloudContentwarehouseV1HistogramQueryPropertyNameFilter,
                       :histogramQuery string}],
   :documentQuery {:documentSchemaNames [string],
                   :customWeightsMetadata GoogleCloudContentwarehouseV1CustomWeightsMetadata,
                   :isNlQuery boolean,
                   :folderNameFilter string,
                   :fileTypeFilter GoogleCloudContentwarehouseV1FileTypeFilter,
                   :documentNameFilter [string],
                   :propertyFilter [GoogleCloudContentwarehouseV1PropertyFilter],
                   :query string,
                   :timeFilters [GoogleCloudContentwarehouseV1TimeFilter],
                   :queryContext [string],
                   :documentCreatorFilter [string],
                   :customPropertyFilter string},
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :qaSizeLimit integer,
   :requireTotalSize boolean,
   :pageToken string,
   :pageSize integer,
   :orderBy string}
  
  Searches for documents using provided SearchDocumentsRequest. This call only returns documents that the caller has permission to search against."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/documents:search"
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

(defn locations-documents-setAcl$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/setAcl
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:projectOwner boolean,
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :policy {:bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string,
            :version integer}}
  
  Sets the access control policy for a resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+resource}:setAcl"
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

(defn locations-documents-lock$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/lock
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:collectionId string, :lockingUser {:id string, :groupIds [string]}}
  
  Lock the document so the document cannot be updated by other users."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:lock"
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

(defn locations-documents-documentLinks-delete$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.documentLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Remove the link between the source and target documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:delete"
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

(defn locations-documents-documentLinks-create$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.documentLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :documentLink {:targetDocumentReference GoogleCloudContentwarehouseV1DocumentReference,
                  :updateTime string,
                  :createTime string,
                  :description string,
                  :name string,
                  :state string,
                  :sourceDocumentReference GoogleCloudContentwarehouseV1DocumentReference}}
  
  Create a link between a source document and a target document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+parent}/documentLinks"
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

(defn locations-documents-referenceId-patch$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.referenceId/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:document {:properties [GoogleCloudContentwarehouseV1Property],
              :creator string,
              :rawDocumentPath string,
              :textExtractionDisabled boolean,
              :textExtractionEnabled boolean,
              :dispositionTime string,
              :displayName string,
              :documentSchemaName string,
              :name string,
              :cloudAiDocument GoogleCloudDocumentaiV1Document,
              :createTime string,
              :title string,
              :updateTime string,
              :contentCategory string,
              :rawDocumentFileType string,
              :updater string,
              :referenceId string,
              :displayUri string,
              :plainText string,
              :legalHold boolean,
              :inlineRawDocument string},
   :updateOptions {:updateType string,
                   :updateMask string,
                   :mergeFieldsOptions GoogleCloudContentwarehouseV1MergeFieldsOptions},
   :requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo},
   :cloudAiDocumentOption {:customizedEntitiesPropertiesConversions {},
                           :enableEntitiesConversions boolean}}
  
  Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does not equal the existing name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
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

(defn locations-documents-referenceId-delete$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.referenceId/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Deletes a document. Returns NOT_FOUND if the document does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:delete"
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

(defn locations-documents-referenceId-get$
  "https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.referenceId/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestMetadata {:userInfo GoogleCloudContentwarehouseV1UserInfo}}
  
  Gets a document. Returns NOT_FOUND if the document does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contentwarehouse.googleapis.com/"
     "v1/{+name}:get"
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
