(ns happygapi.kmsinventory.organizations
  "KMS Inventory API: organizations.
  
  See: https://cloud.google.com/security/products/security-key-management"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn protectedResources-search$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/organizations/protectedResources/search
  
  Required parameters: scope
  
  Optional parameters: cryptoKey, pageToken, resourceTypes, pageSize
  
  Returns metadata about the resources protected by the given Cloud KMS CryptoKey in the given Cloud organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://kmsinventory.googleapis.com/"
     "v1/{+scope}/protectedResources:search"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
