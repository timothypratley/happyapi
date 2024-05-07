(ns happygapi.adsensehost.urlchannels
  "AdSense Host API: urlchannels.
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/adsense/host/v4.1/docs/urlchannels/delete
  
  Required parameters: adClientId, urlChannelId
  
  Optional parameters: none
  
  Delete a URL channel from the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:urlChannelId :adClientId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/urlchannels/{urlChannelId}"
     #{:urlChannelId :adClientId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/adsense/host/v4.1/docs/urlchannels/insert
  
  Required parameters: adClientId
  
  Optional parameters: none
  
  Body: 
  
  {:id string, :kind string, :urlPattern string}
  
  Add a new URL channel to the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/urlchannels"
     #{:adClientId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/host/v4.1/docs/urlchannels/list
  
  Required parameters: adClientId
  
  Optional parameters: maxResults, pageToken
  
  List all host URL channels in the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/urlchannels"
     #{:adClientId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
