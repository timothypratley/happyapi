(ns happygapi.youtube.thirdPartyLinks
  "YouTube Data API v3: thirdPartyLinks.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/v3/docs/thirdPartyLinks/update
  
  Required parameters: part
  
  Optional parameters: externalChannelId
  
  Body: 
  
  {:status {:linkStatus string},
   :linkingToken string,
   :snippet {:type string,
             :channelToStoreLink ChannelToStoreLinkDetails},
   :etag string,
   :kind string}
  
  Updates an existing resource."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
     #{:part}
     parameters)
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
  "https://developers.google.com/youtube/v3/docs/thirdPartyLinks/delete
  
  Required parameters: linkingToken, type
  
  Optional parameters: externalChannelId, part
  
  Deletes a resource."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:type :linkingToken})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
     #{:type :linkingToken}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3/docs/thirdPartyLinks/insert
  
  Required parameters: part
  
  Optional parameters: externalChannelId
  
  Body: 
  
  {:status {:linkStatus string},
   :linkingToken string,
   :snippet {:type string,
             :channelToStoreLink ChannelToStoreLinkDetails},
   :etag string,
   :kind string}
  
  Inserts a new resource into this collection."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
     #{:part}
     parameters)
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
  "https://developers.google.com/youtube/v3/docs/thirdPartyLinks/list
  
  Required parameters: part
  
  Optional parameters: type, linkingToken, externalChannelId
  
  Retrieves a list of resources, possibly filtered."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
