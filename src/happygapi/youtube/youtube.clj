(ns happygapi.youtube.youtube
  "YouTube Data API v3: youtube.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn v3-updateCommentThreads$
  "https://developers.google.com/youtube/v3/docs/youtube/v3/updateCommentThreads
  
  Required parameters: none
  
  Optional parameters: part
  
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
  
  Updates an existing resource."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/commentThreads"
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
