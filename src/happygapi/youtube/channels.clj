(ns happygapi.youtube.channels
  "YouTube Data API v3: channels.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/v3/docs/channels/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:contentOwnerDetails {:contentOwner string, :timeLinked string},
   :localizations {},
   :brandingSettings {:image ImageSettings,
                      :channel ChannelSettings,
                      :hints [PropertyValue],
                      :watch WatchSettings},
   :snippet {:description string,
             :thumbnails ThumbnailDetails,
             :customUrl string,
             :title string,
             :country string,
             :defaultLanguage string,
             :publishedAt string,
             :localized ChannelLocalization},
   :etag string,
   :auditDetails {:contentIdClaimsGoodStanding boolean,
                  :communityGuidelinesGoodStanding boolean,
                  :copyrightStrikesGoodStanding boolean},
   :conversionPings {:pings [ChannelConversionPing]},
   :statistics {:subscriberCount string,
                :hiddenSubscriberCount boolean,
                :viewCount string,
                :commentCount string,
                :videoCount string},
   :status {:madeForKids boolean,
            :longUploadsStatus string,
            :isLinked boolean,
            :privacyStatus string,
            :selfDeclaredMadeForKids boolean},
   :id string,
   :kind string,
   :contentDetails {:relatedPlaylists {:watchLater string,
                                       :uploads string,
                                       :favorites string,
                                       :watchHistory string,
                                       :likes string}},
   :topicDetails {:topicCategories [string], :topicIds [string]}}
  
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
     "youtube/v3/channels"
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
  "https://developers.google.com/youtube/v3/docs/channels/list
  
  Required parameters: part
  
  Optional parameters: managedByMe, categoryId, forUsername, pageToken, mine, hl, id, forHandle, mySubscribers, onBehalfOfContentOwner, maxResults
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/youtubepartner-channel-audit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/channels"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
