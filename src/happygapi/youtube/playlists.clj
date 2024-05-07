(ns happygapi.youtube.playlists
  "YouTube Data API v3: playlists.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3/docs/playlists/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlists"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3/docs/playlists/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Body: 
  
  {:snippet {:description string,
             :tags [string],
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :localized PlaylistLocalization,
             :channelTitle string,
             :thumbnailVideoId string,
             :defaultLanguage string},
   :etag string,
   :player {:embedHtml string},
   :id string,
   :status {:privacyStatus string},
   :kind string,
   :contentDetails {:itemCount integer},
   :localizations {}}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlists"
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

(defn update$
  "https://developers.google.com/youtube/v3/docs/playlists/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:snippet {:description string,
             :tags [string],
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :localized PlaylistLocalization,
             :channelTitle string,
             :thumbnailVideoId string,
             :defaultLanguage string},
   :etag string,
   :player {:embedHtml string},
   :id string,
   :status {:privacyStatus string},
   :kind string,
   :contentDetails {:itemCount integer},
   :localizations {}}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlists"
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
  "https://developers.google.com/youtube/v3/docs/playlists/list
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwnerChannel, channelId, pageToken, mine, hl, id, onBehalfOfContentOwner, maxResults
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlists"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
