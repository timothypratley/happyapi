(ns happygapi.analyticsadmin.properties
  "Google Analytics Admin API: properties.
  Manage properties in Google Analytics. Warning: Creating multiple Customer Applications, Accounts, or Projects to simulate or act as a single Customer Application, Account, or Project (respectively) or to circumvent Service-specific usage limits or quotas is a direct violation of Google Cloud Platform Terms of Service as well as Google APIs Terms of Service. These actions can result in immediate termination of your GCP project(s) without any warning.
  See: https://developers.google.com/analytics/devguides/config/?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single \"GA4\" Property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateDataRetentionSettings$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/updateDataRetentionSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:resetUserDataOnNewActivity boolean,
   :eventDataRetention string,
   :name string}
  
  Updates the singleton data retention settings for this property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn getDataRetentionSettings$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/getDataRetentionSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the singleton data retention settings for this property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:timeZone string,
   :deleteTime string,
   :parent string,
   :industryCategory string,
   :displayName string,
   :name string,
   :createTime string,
   :serviceLevel string,
   :updateTime string,
   :account string,
   :expireTime string,
   :propertyType string,
   :currencyCode string}
  
  Updates a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeZone string,
   :deleteTime string,
   :parent string,
   :industryCategory string,
   :displayName string,
   :name string,
   :createTime string,
   :serviceLevel string,
   :updateTime string,
   :account string,
   :expireTime string,
   :propertyType string,
   :currencyCode string}
  
  Creates an \"GA4\" property with the specified location and attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/properties"
     #{}
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

(defn delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Marks target Property as soft-deleted (ie: \"trashed\") and returns it. This API does not have a method to restore soft-deleted properties. However, they can be restored using the Trash Can UI. If the properties are not restored before the expiration time, the Property and all child resources (eg: GoogleAdsLinks, Streams, AccessBindings) will be permanently purged. https://support.google.com/analytics/answer/6154772 Returns an error if the target is not found, or is not a GA4 Property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/list
  
  Required parameters: none
  
  Optional parameters: pageSize, showDeleted, pageToken, filter
  
  Returns child Properties under the specified parent Account. Only \"GA4\" properties will be returned. Properties will be excluded if the caller does not have access. Soft-deleted (ie: \"trashed\") properties are excluded by default. Returns an empty list if no relevant properties are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/properties"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn acknowledgeUserDataCollection$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/acknowledgeUserDataCollection
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:acknowledgement string}
  
  Acknowledges the terms of user data collection for the specified property. This acknowledgement must be completed (either in the Google Analytics UI or through this API) before MeasurementProtocolSecret resources may be created."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+property}:acknowledgeUserDataCollection"
     #{:property}
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

(defn runAccessReport$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/runAccessReport
  
  Required parameters: entity
  
  Optional parameters: none
  
  Body: 
  
  {:timeZone string,
   :limit string,
   :offset string,
   :dimensionFilter {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
                     :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
                     :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
                     :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
   :dimensions [{:dimensionName string}],
   :metricFilter {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
                  :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
                  :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
                  :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
   :dateRanges [{:endDate string, :startDate string}],
   :expandGroups boolean,
   :orderBys [{:metric GoogleAnalyticsAdminV1betaAccessOrderByMetricOrderBy,
               :desc boolean,
               :dimension GoogleAnalyticsAdminV1betaAccessOrderByDimensionOrderBy}],
   :metrics [{:metricName string}],
   :includeAllUsers boolean,
   :returnEntityQuota boolean}
  
  Returns a customized report of data access records. The report provides records of each time a user reads Google Analytics reporting data. Access records are retained for up to 2 years. Data Access Reports can be requested for a property. Reports may be requested for any property, but dimensions that aren't related to quota can only be requested on Google Analytics 360 properties. This method is only available to Administrators. These data access records include GA4 UI Reporting, GA4 UI Explorations, GA4 Data API, and other products like Firebase & Admob that can retrieve data from Google Analytics through a linkage. These records don't include property configuration changes like adding a stream or changing a property's time zone. For configuration change history, see [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entity})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+entity}:runAccessReport"
     #{:entity}
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

(defn googleAdsLinks-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:creatorEmailAddress string,
   :canManageClients boolean,
   :customerId string,
   :updateTime string,
   :adsPersonalizationEnabled boolean,
   :name string,
   :createTime string}
  
  Creates a GoogleAdsLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/googleAdsLinks"
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

(defn googleAdsLinks-delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a GoogleAdsLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn googleAdsLinks-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creatorEmailAddress string,
   :canManageClients boolean,
   :customerId string,
   :updateTime string,
   :adsPersonalizationEnabled boolean,
   :name string,
   :createTime string}
  
  Updates a GoogleAdsLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn googleAdsLinks-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists GoogleAdsLinks on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/googleAdsLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn conversionEvents-get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve a single conversion event."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn conversionEvents-delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a conversion event in a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn conversionEvents-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createTime string,
   :deletable boolean,
   :eventName string,
   :defaultConversionValue {:currencyCode string, :value number},
   :name string,
   :countingMethod string,
   :custom boolean}
  
  Updates a conversion event with the specified attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn conversionEvents-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:createTime string,
   :deletable boolean,
   :eventName string,
   :defaultConversionValue {:currencyCode string, :value number},
   :name string,
   :countingMethod string,
   :custom boolean}
  
  Creates a conversion event with the specified attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/conversionEvents"
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

(defn conversionEvents-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of conversion events in the specified parent property. Returns an empty list if no conversion events are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/conversionEvents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyEvents-delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Key Event."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyEvents-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:createTime string,
   :defaultValue {:numericValue number, :currencyCode string},
   :custom boolean,
   :deletable boolean,
   :countingMethod string,
   :name string,
   :eventName string}
  
  Creates a Key Event."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/keyEvents"
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

(defn keyEvents-get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve a single Key Event."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyEvents-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createTime string,
   :defaultValue {:numericValue number, :currencyCode string},
   :custom boolean,
   :deletable boolean,
   :countingMethod string,
   :name string,
   :eventName string}
  
  Updates a Key Event."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn keyEvents-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of Key Events in the specified parent property. Returns an empty list if no Key Events are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/keyEvents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn firebaseLinks-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/firebaseLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :createTime string, :project string}
  
  Creates a FirebaseLink. Properties can have at most one FirebaseLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/firebaseLinks"
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

(defn firebaseLinks-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/firebaseLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/firebaseLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn firebaseLinks-delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/firebaseLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a FirebaseLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataStreams-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateTime string,
   :androidAppStreamData {:packageName string, :firebaseAppId string},
   :webStreamData {:defaultUri string,
                   :firebaseAppId string,
                   :measurementId string},
   :createTime string,
   :displayName string,
   :type string,
   :iosAppStreamData {:bundleId string, :firebaseAppId string},
   :name string}
  
  Creates a DataStream."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/dataStreams"
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

(defn dataStreams-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists DataStreams on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/dataStreams"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataStreams-delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DataStream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataStreams-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :androidAppStreamData {:packageName string, :firebaseAppId string},
   :webStreamData {:defaultUri string,
                   :firebaseAppId string,
                   :measurementId string},
   :createTime string,
   :displayName string,
   :type string,
   :iosAppStreamData {:bundleId string, :firebaseAppId string},
   :name string}
  
  Updates a DataStream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn dataStreams-get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single DataStream."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataStreams-measurementProtocolSecrets-delete$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes target MeasurementProtocolSecret."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataStreams-measurementProtocolSecrets-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:secretValue string, :displayName string, :name string}
  
  Creates a measurement protocol secret."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/measurementProtocolSecrets"
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

(defn dataStreams-measurementProtocolSecrets-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:secretValue string, :displayName string, :name string}
  
  Updates a measurement protocol secret."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn dataStreams-measurementProtocolSecrets-get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single \"GA4\" MeasurementProtocolSecret."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataStreams-measurementProtocolSecrets-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns child MeasurementProtocolSecrets under the specified parent Property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/measurementProtocolSecrets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:parameterName string,
   :name string,
   :description string,
   :measurementUnit string,
   :scope string,
   :restrictedMetricType [string],
   :displayName string}
  
  Creates a CustomMetric."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/customMetrics"
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

(defn customMetrics-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:parameterName string,
   :name string,
   :description string,
   :measurementUnit string,
   :scope string,
   :restrictedMetricType [string],
   :displayName string}
  
  Updates a CustomMetric on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn customMetrics-get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single CustomMetric."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists CustomMetrics on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/customMetrics"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-archive$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/archive
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Archives a CustomMetric on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}:archive"
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

(defn customDimensions-get$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single CustomDimension."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-create$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :name string,
   :disallowAdsPersonalization boolean,
   :scope string,
   :parameterName string,
   :displayName string}
  
  Creates a CustomDimension."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/customDimensions"
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

(defn customDimensions-patch$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :name string,
   :disallowAdsPersonalization boolean,
   :scope string,
   :parameterName string,
   :displayName string}
  
  Updates a CustomDimension on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn customDimensions-archive$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/archive
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Archives a CustomDimension on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}:archive"
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

(defn customDimensions-list$
  "https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists CustomDimensions on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+parent}/customDimensions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
