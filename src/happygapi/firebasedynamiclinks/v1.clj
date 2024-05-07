(ns happygapi.firebasedynamiclinks.v1
  "Firebase Dynamic Links API: v1.
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://firebase.google.com/docs/dynamic-links/v1/docs/reopenAttribution
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:sdkVersion string, :requestedLink string, :bundleId string}
  
  Get iOS reopen attribution for app universal link open deeplinking."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/reopenAttribution"
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

(defn $
  "https://firebase.google.com/docs/dynamic-links/v1/docs/getLinkStats
  
  Required parameters: dynamicLink
  
  Optional parameters: sdkVersion, durationDays
  
  Fetches analytics stats of a short Dynamic Link for a given duration. Metrics include number of clicks, redirects, installs, app first opens, and app reopens."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dynamicLink})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/{dynamicLink}/linkStats"
     #{:dynamicLink}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://firebase.google.com/docs/dynamic-links/v1/docs/installAttribution
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:retrievalMethod string,
   :bundleId string,
   :sdkVersion string,
   :visualStyle string,
   :appInstallationTime string,
   :iosVersion string,
   :device {:deviceModelName string,
            :screenResolutionWidth string,
            :languageCodeFromWebview string,
            :timezone string,
            :screenResolutionHeight string,
            :languageCode string,
            :languageCodeRaw string},
   :uniqueMatchLinkToCheck string}
  
  Get iOS strong/weak-match info for post-install attribution."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/installAttribution"
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
