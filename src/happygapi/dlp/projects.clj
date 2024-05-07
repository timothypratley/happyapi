(ns happygapi.dlp.projects
  "Sensitive Data Protection (DLP): projects.
  Discover and protect your sensitive data. A fully managed service designed to help you discover, classify, and protect your valuable data assets with ease.
  See: https://cloud.google.com/sensitive-data-protection/docs/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-inspectTemplates-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplate {:displayName string,
                     :description string,
                     :createTime string,
                     :updateTime string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :name string},
   :updateMask string}
  
  Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-inspectTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, orderBy, locationId
  
  Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplate {:displayName string,
                     :description string,
                     :createTime string,
                     :updateTime string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :name string},
   :templateId string,
   :locationId string}
  
  Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
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

(defn locations-inspectTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tableDataProfiles-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.tableDataProfiles/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a TableDataProfile. Will not prevent the profile from being regenerated if the table is still included in a discovery configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tableDataProfiles-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.tableDataProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists table data profiles for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/tableDataProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tableDataProfiles-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.tableDataProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a table data profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, locationId, pageToken, pageSize
  
  Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:config {:displayName string,
            :description string,
            :regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary},
   :locationId string,
   :storedInfoTypeId string}
  
  Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
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

(defn locations-storedInfoTypes-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :config {:displayName string,
            :description string,
            :regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary}}
  
  Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-content-reidentify$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.content/reidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reidentifyConfig {:transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :imageTransformations GooglePrivacyDlpV2ImageTransformations,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :locationId string,
   :item {:value string,
          :table GooglePrivacyDlpV2Table,
          :byteItem GooglePrivacyDlpV2ByteContentItem},
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]},
   :reidentifyTemplateName string,
   :inspectTemplateName string}
  
  Re-identifies content that has been de-identified. See https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:reidentify"
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

(defn locations-content-inspect$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.content/inspect
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:item {:value string,
          :table GooglePrivacyDlpV2Table,
          :byteItem GooglePrivacyDlpV2ByteContentItem},
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]},
   :inspectTemplateName string,
   :locationId string}
  
  Finds potentially sensitive info in content. This method has limits on input size, processing time, and output size. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated. For how to guides, see https://cloud.google.com/sensitive-data-protection/docs/inspecting-images and https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:inspect"
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

(defn locations-content-deidentify$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.content/deidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]},
   :inspectTemplateName string,
   :deidentifyConfig {:transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :imageTransformations GooglePrivacyDlpV2ImageTransformations,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :item {:value string,
          :table GooglePrivacyDlpV2Table,
          :byteItem GooglePrivacyDlpV2ByteContentItem},
   :deidentifyTemplateName string}
  
  De-identifies potentially sensitive info from a ContentItem. This method has limits on input size and output size. See https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:deidentify"
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

(defn locations-columnDataProfiles-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.columnDataProfiles/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, filter, pageToken
  
  Lists column data profiles for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/columnDataProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-columnDataProfiles-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.columnDataProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a column data profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, locationId, pageSize, filter, type
  
  Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running DlpJob. This method indicates that the client is no longer interested in the DlpJob result. The job will be canceled if possible. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-hybridInspect$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/hybridInspect
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:hybridItem {:findingDetails GooglePrivacyDlpV2HybridFindingDetails,
                :item GooglePrivacyDlpV2ContentItem}}
  
  Inspect hybrid content and store findings to a job. To review the findings, inspect the job. Inspection will occur asynchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:hybridInspect"
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

(defn locations-dlpJobs-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running DlpJob. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-finish$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/finish
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Finish a running hybrid DlpJob. Triggers the finalization steps and running of any enabled actions that have not yet run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:finish"
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

(defn locations-dlpJobs-cancel$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to cancel the DlpJob, but success is not guaranteed. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn locations-dlpJobs-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:riskJob {:actions [GooglePrivacyDlpV2Action],
             :privacyMetric GooglePrivacyDlpV2PrivacyMetric,
             :sourceTable GooglePrivacyDlpV2BigQueryTable},
   :inspectJob {:actions [GooglePrivacyDlpV2Action],
                :inspectTemplateName string,
                :storageConfig GooglePrivacyDlpV2StorageConfig,
                :inspectConfig GooglePrivacyDlpV2InspectConfig},
   :locationId string,
   :jobId string}
  
  Creates a new job to inspect storage or calculate risk metrics. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more. When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
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

(defn locations-deidentifyTemplates-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:name string,
                        :updateTime string,
                        :displayName string,
                        :description string,
                        :createTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig},
   :updateMask string}
  
  Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-deidentifyTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: locationId, pageSize, pageToken, orderBy
  
  Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:name string,
                        :updateTime string,
                        :displayName string,
                        :description string,
                        :createTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig},
   :locationId string,
   :templateId string}
  
  Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
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

(defn locations-jobTriggers-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:triggerId string,
   :locationId string,
   :jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string}}
  
  Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
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

(defn locations-jobTriggers-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string},
   :updateMask string}
  
  Updates a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-jobTriggers-activate$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the trigger event to occur."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:activate"
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

(defn locations-jobTriggers-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/list
  
  Required parameters: parent
  
  Optional parameters: type, orderBy, pageSize, locationId, pageToken, filter
  
  Lists job triggers. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-hybridInspect$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/hybridInspect
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:hybridItem {:findingDetails GooglePrivacyDlpV2HybridFindingDetails,
                :item GooglePrivacyDlpV2ContentItem}}
  
  Inspect hybrid content and store findings to a trigger. The inspection will be processed asynchronously. To review the findings monitor the jobs within the trigger."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:hybridInspect"
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

(defn locations-projectDataProfiles-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.projectDataProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a project data profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-projectDataProfiles-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.projectDataProfiles/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageSize, pageToken
  
  Lists project data profiles for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/projectDataProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-image-redact$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.image/redact
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:byteItem {:type string, :data string},
   :includeFindings boolean,
   :locationId string,
   :imageRedactionConfigs [{:infoType GooglePrivacyDlpV2InfoType,
                            :redactionColor GooglePrivacyDlpV2Color,
                            :redactAllText boolean}],
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]}}
  
  Redacts potentially sensitive info from an image. This method has limits on input size, processing time, and output size. See https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/image:redact"
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

(defn locations-connections-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists Connections in a parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/connections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-search$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/search
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Searches for Connections in a parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/connections:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:connection {:errors [GooglePrivacyDlpV2Error],
                :cloudSql GooglePrivacyDlpV2CloudSqlProperties,
                :state string,
                :name string},
   :updateMask string}
  
  Update a Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-connections-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a Connection by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:connection {:errors [GooglePrivacyDlpV2Error],
                :cloudSql GooglePrivacyDlpV2CloudSqlProperties,
                :state string,
                :name string}}
  
  Create a Connection to an external data source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/connections"
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

(defn locations-discoveryConfigs-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:configId string,
   :discoveryConfig {:inspectTemplates [string],
                     :errors [GooglePrivacyDlpV2Error],
                     :displayName string,
                     :name string,
                     :createTime string,
                     :orgConfig GooglePrivacyDlpV2OrgConfig,
                     :targets [GooglePrivacyDlpV2DiscoveryTarget],
                     :actions [GooglePrivacyDlpV2DataProfileAction],
                     :updateTime string,
                     :status string,
                     :lastRunTime string}}
  
  Creates a config for discovery to scan and profile storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/discoveryConfigs"
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

(defn locations-discoveryConfigs-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:discoveryConfig {:inspectTemplates [string],
                     :errors [GooglePrivacyDlpV2Error],
                     :displayName string,
                     :name string,
                     :createTime string,
                     :orgConfig GooglePrivacyDlpV2OrgConfig,
                     :targets [GooglePrivacyDlpV2DiscoveryTarget],
                     :actions [GooglePrivacyDlpV2DataProfileAction],
                     :updateTime string,
                     :status string,
                     :lastRunTime string},
   :updateMask string}
  
  Updates a discovery configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-discoveryConfigs-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a discovery configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveryConfigs-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a discovery configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveryConfigs-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, pageToken
  
  Lists discovery configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/discoveryConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, orderBy, locationId
  
  Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:config {:displayName string,
            :description string,
            :regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary},
   :locationId string,
   :storedInfoTypeId string}
  
  Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
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

(defn storedInfoTypes-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :config {:displayName string,
            :description string,
            :regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary}}
  
  Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn content-deidentify$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.content/deidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]},
   :inspectTemplateName string,
   :deidentifyConfig {:transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :imageTransformations GooglePrivacyDlpV2ImageTransformations,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :item {:value string,
          :table GooglePrivacyDlpV2Table,
          :byteItem GooglePrivacyDlpV2ByteContentItem},
   :deidentifyTemplateName string}
  
  De-identifies potentially sensitive info from a ContentItem. This method has limits on input size and output size. See https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:deidentify"
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

(defn content-inspect$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.content/inspect
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:item {:value string,
          :table GooglePrivacyDlpV2Table,
          :byteItem GooglePrivacyDlpV2ByteContentItem},
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]},
   :inspectTemplateName string,
   :locationId string}
  
  Finds potentially sensitive info in content. This method has limits on input size, processing time, and output size. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated. For how to guides, see https://cloud.google.com/sensitive-data-protection/docs/inspecting-images and https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:inspect"
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

(defn content-reidentify$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.content/reidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reidentifyConfig {:transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :imageTransformations GooglePrivacyDlpV2ImageTransformations,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :locationId string,
   :item {:value string,
          :table GooglePrivacyDlpV2Table,
          :byteItem GooglePrivacyDlpV2ByteContentItem},
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]},
   :reidentifyTemplateName string,
   :inspectTemplateName string}
  
  Re-identifies content that has been de-identified. See https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:reidentify"
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

(defn inspectTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, locationId, pageToken, orderBy
  
  Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplate {:displayName string,
                     :description string,
                     :createTime string,
                     :updateTime string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :name string},
   :templateId string,
   :locationId string}
  
  Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
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

(defn inspectTemplates-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplate {:displayName string,
                     :description string,
                     :createTime string,
                     :updateTime string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :name string},
   :updateMask string}
  
  Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn inspectTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:name string,
                        :updateTime string,
                        :displayName string,
                        :description string,
                        :createTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig},
   :locationId string,
   :templateId string}
  
  Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
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

(defn deidentifyTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, locationId, pageToken, orderBy
  
  Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:name string,
                        :updateTime string,
                        :displayName string,
                        :description string,
                        :createTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig},
   :updateMask string}
  
  Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn deidentifyTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn image-redact$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.image/redact
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:byteItem {:type string, :data string},
   :includeFindings boolean,
   :locationId string,
   :imageRedactionConfigs [{:infoType GooglePrivacyDlpV2InfoType,
                            :redactionColor GooglePrivacyDlpV2Color,
                            :redactAllText boolean}],
   :inspectConfig {:ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :includeQuote boolean,
                   :minLikelihood string,
                   :contentOptions [string],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :excludeInfoTypes boolean,
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihoodPerInfoType [GooglePrivacyDlpV2InfoTypeLikelihood]}}
  
  Redacts potentially sensitive info from an image. This method has limits on input size, processing time, and output size. See https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/image:redact"
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

(defn dlpJobs-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running DlpJob. This method indicates that the client is no longer interested in the DlpJob result. The job will be canceled if possible. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dlpJobs-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:riskJob {:actions [GooglePrivacyDlpV2Action],
             :privacyMetric GooglePrivacyDlpV2PrivacyMetric,
             :sourceTable GooglePrivacyDlpV2BigQueryTable},
   :inspectJob {:actions [GooglePrivacyDlpV2Action],
                :inspectTemplateName string,
                :storageConfig GooglePrivacyDlpV2StorageConfig,
                :inspectConfig GooglePrivacyDlpV2InspectConfig},
   :locationId string,
   :jobId string}
  
  Creates a new job to inspect storage or calculate risk metrics. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more. When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
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

(defn dlpJobs-cancel$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to cancel the DlpJob, but success is not guaranteed. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn dlpJobs-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/list
  
  Required parameters: parent
  
  Optional parameters: type, filter, pageToken, locationId, pageSize, orderBy
  
  Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dlpJobs-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running DlpJob. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-activate$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the trigger event to occur."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:activate"
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

(defn jobTriggers-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string},
   :updateMask string}
  
  Updates a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn jobTriggers-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-create$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:triggerId string,
   :locationId string,
   :jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string}}
  
  Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
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

(defn jobTriggers-get$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-list$
  "https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, locationId, filter, orderBy, type
  
  Lists job triggers. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
