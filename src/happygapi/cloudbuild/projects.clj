(ns happygapi.cloudbuild.projects
  "Cloud Build API: projects.
  Creates and manages builds on Google Cloud Platform.
  See: https://cloud.google.com/build/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+name}/locations"
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
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-get$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-setIamPolicy$
  "https://cloud.google.com/build/docs
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [Binding],
            :version integer,
            :etag string,
            :auditConfigs [AuditConfig]},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
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

(defn locations-connections-patch$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: etag, updateMask, allowMissing
  
  Body: 
  
  {:disabled boolean,
   :name string,
   :githubEnterpriseConfig {:serverVersion string,
                            :apiKey string,
                            :hostUri string,
                            :serviceDirectoryConfig GoogleDevtoolsCloudbuildV2ServiceDirectoryConfig,
                            :privateKeySecretVersion string,
                            :appSlug string,
                            :appId string,
                            :webhookSecretSecretVersion string,
                            :appInstallationId string,
                            :sslCa string},
   :createTime string,
   :etag string,
   :updateTime string,
   :bitbucketDataCenterConfig {:hostUri string,
                               :serviceDirectoryConfig GoogleDevtoolsCloudbuildV2ServiceDirectoryConfig,
                               :authorizerCredential UserCredential,
                               :sslCa string,
                               :serverVersion string,
                               :readAuthorizerCredential UserCredential,
                               :webhookSecretSecretVersion string},
   :reconciling boolean,
   :installationState {:stage string,
                       :actionUri string,
                       :message string},
   :githubConfig {:appInstallationId string,
                  :authorizerCredential OAuthCredential},
   :bitbucketCloudConfig {:authorizerCredential UserCredential,
                          :readAuthorizerCredential UserCredential,
                          :webhookSecretSecretVersion string,
                          :workspace string},
   :annotations {},
   :gitlabConfig {:sslCa string,
                  :readAuthorizerCredential UserCredential,
                  :serviceDirectoryConfig GoogleDevtoolsCloudbuildV2ServiceDirectoryConfig,
                  :serverVersion string,
                  :authorizerCredential UserCredential,
                  :webhookSecretSecretVersion string,
                  :hostUri string}}
  
  Updates a single connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-testIamPermissions$
  "https://cloud.google.com/build/docs
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
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

(defn locations-connections-create$
  "https://cloud.google.com/build/docs
  
  Required parameters: parent
  
  Optional parameters: connectionId
  
  Body: 
  
  {:disabled boolean,
   :name string,
   :githubEnterpriseConfig {:serverVersion string,
                            :apiKey string,
                            :hostUri string,
                            :serviceDirectoryConfig GoogleDevtoolsCloudbuildV2ServiceDirectoryConfig,
                            :privateKeySecretVersion string,
                            :appSlug string,
                            :appId string,
                            :webhookSecretSecretVersion string,
                            :appInstallationId string,
                            :sslCa string},
   :createTime string,
   :etag string,
   :updateTime string,
   :bitbucketDataCenterConfig {:hostUri string,
                               :serviceDirectoryConfig GoogleDevtoolsCloudbuildV2ServiceDirectoryConfig,
                               :authorizerCredential UserCredential,
                               :sslCa string,
                               :serverVersion string,
                               :readAuthorizerCredential UserCredential,
                               :webhookSecretSecretVersion string},
   :reconciling boolean,
   :installationState {:stage string,
                       :actionUri string,
                       :message string},
   :githubConfig {:appInstallationId string,
                  :authorizerCredential OAuthCredential},
   :bitbucketCloudConfig {:authorizerCredential UserCredential,
                          :readAuthorizerCredential UserCredential,
                          :webhookSecretSecretVersion string,
                          :workspace string},
   :annotations {},
   :gitlabConfig {:sslCa string,
                  :readAuthorizerCredential UserCredential,
                  :serviceDirectoryConfig GoogleDevtoolsCloudbuildV2ServiceDirectoryConfig,
                  :serverVersion string,
                  :authorizerCredential UserCredential,
                  :webhookSecretSecretVersion string,
                  :hostUri string}}
  
  Creates a Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-delete$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a single connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-getIamPolicy$
  "https://cloud.google.com/build/docs
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-list$
  "https://cloud.google.com/build/docs
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists Connections in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-fetchLinkableRepositories$
  "https://cloud.google.com/build/docs
  
  Required parameters: connection
  
  Optional parameters: pageToken, pageSize
  
  FetchLinkableRepositories get repositories from SCM that are accessible and could be added to the connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:connection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+connection}:fetchLinkableRepositories"
     #{:connection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-processWebhook$
  "https://cloud.google.com/build/docs
  
  Required parameters: parent
  
  Optional parameters: webhookKey
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  ProcessWebhook is called by the external SCM for notifying of events."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+parent}/connections:processWebhook"
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

(defn locations-connections-repositories-delete$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a single repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-repositories-accessReadToken$
  "https://cloud.google.com/build/docs
  
  Required parameters: repository
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Fetches read token of a given repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:repository})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+repository}:accessReadToken"
     #{:repository}
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

(defn locations-connections-repositories-get$
  "https://cloud.google.com/build/docs
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-connections-repositories-list$
  "https://cloud.google.com/build/docs
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists Repositories in a given connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+parent}/repositories"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-repositories-batchCreate$
  "https://cloud.google.com/build/docs
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:parent string,
               :repository Repository,
               :repositoryId string}]}
  
  Creates multiple repositories inside a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+parent}/repositories:batchCreate"
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

(defn locations-connections-repositories-create$
  "https://cloud.google.com/build/docs
  
  Required parameters: parent
  
  Optional parameters: repositoryId
  
  Body: 
  
  {:annotations {},
   :etag string,
   :webhookId string,
   :createTime string,
   :updateTime string,
   :name string,
   :remoteUri string}
  
  Creates a Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+parent}/repositories"
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

(defn locations-connections-repositories-accessReadWriteToken$
  "https://cloud.google.com/build/docs
  
  Required parameters: repository
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Fetches read/write token of a given repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:repository})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+repository}:accessReadWriteToken"
     #{:repository}
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

(defn locations-connections-repositories-fetchGitRefs$
  "https://cloud.google.com/build/docs
  
  Required parameters: repository
  
  Optional parameters: refType, pageSize, pageToken
  
  Fetch the list of branches or tags for a given repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:repository})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v2/{+repository}:fetchGitRefs"
     #{:repository}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
