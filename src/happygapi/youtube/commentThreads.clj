(ns happygapi.youtube.commentThreads
  "YouTube Data API v3: commentThreads.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/v3/docs/commentThreads/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :snippet {:totalReplyCount integer,
             :isPublic boolean,
             :canReply boolean,
             :topLevelComment Comment,
             :videoId string,
             :channelId string},
   :kind string,
   :etag string,
   :replies {:comments [Comment]}}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/commentThreads"
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
  "https://developers.google.com/youtube/v3/docs/commentThreads/list
  
  Required parameters: part
  
  Optional parameters: textFormat, channelId, allThreadsRelatedToChannelId, pageToken, id, videoId, order, searchTerms, moderationStatus, maxResults
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/commentThreads"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
