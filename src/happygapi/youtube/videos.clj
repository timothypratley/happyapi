(ns happygapi.youtube.videos
  "YouTube Data API v3: videos.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/v3/docs/videos/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:monetizationDetails {:access AccessPolicy},
   :localizations {},
   :snippet {:description string,
             :tags [string],
             :publishedAt string,
             :channelId string,
             :categoryId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :defaultAudioLanguage string,
             :liveBroadcastContent string,
             :localized VideoLocalization,
             :channelTitle string,
             :defaultLanguage string},
   :fileDetails {:creationTime string,
                 :fileSize string,
                 :fileType string,
                 :fileName string,
                 :bitrateBps string,
                 :videoStreams [VideoFileDetailsVideoStream],
                 :container string,
                 :durationMs string,
                 :audioStreams [VideoFileDetailsAudioStream]},
   :etag string,
   :recordingDetails {:recordingDate string,
                      :location GeoPoint,
                      :locationDescription string},
   :statistics {:dislikeCount string,
                :favoriteCount string,
                :likeCount string,
                :commentCount string,
                :viewCount string},
   :ageGating {:restricted boolean,
               :alcoholContent boolean,
               :videoGameRating string},
   :status {:uploadStatus string,
            :publicStatsViewable boolean,
            :license string,
            :embeddable boolean,
            :publishAt string,
            :madeForKids boolean,
            :privacyStatus string,
            :failureReason string,
            :rejectionReason string,
            :selfDeclaredMadeForKids boolean},
   :processingDetails {:processingFailureReason string,
                       :thumbnailsAvailability string,
                       :fileDetailsAvailability string,
                       :processingProgress VideoProcessingDetailsProcessingProgress,
                       :tagSuggestionsAvailability string,
                       :processingStatus string,
                       :editorSuggestionsAvailability string,
                       :processingIssuesAvailability string},
   :id string,
   :kind string,
   :liveStreamingDetails {:scheduledStartTime string,
                          :scheduledEndTime string,
                          :actualEndTime string,
                          :actualStartTime string,
                          :concurrentViewers string,
                          :activeLiveChatId string},
   :suggestions {:processingErrors [string],
                 :tagSuggestions [VideoSuggestionsTagSuggestion],
                 :processingHints [string],
                 :editorSuggestions [string],
                 :processingWarnings [string]},
   :contentDetails {:caption string,
                    :definition string,
                    :licensedContent boolean,
                    :duration string,
                    :contentRating ContentRating,
                    :countryRestriction AccessPolicy,
                    :regionRestriction VideoContentDetailsRegionRestriction,
                    :dimension string,
                    :projection string,
                    :hasCustomThumbnail boolean},
   :player {:embedWidth string, :embedHtml string, :embedHeight string},
   :projectDetails {},
   :topicDetails {:relevantTopicIds [string],
                  :topicCategories [string],
                  :topicIds [string]}}
  
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
     "youtube/v3/videos"
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

(defn reportAbuse$
  "https://developers.google.com/youtube/v3/docs/videos/reportAbuse
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:secondaryReasonId string,
   :reasonId string,
   :videoId string,
   :language string,
   :comments string}
  
  Report abuse for a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/videos/reportAbuse"
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

(defn list$
  "https://developers.google.com/youtube/v3/docs/videos/list
  
  Required parameters: part
  
  Optional parameters: maxHeight, maxWidth, locale, pageToken, chart, hl, id, regionCode, myRating, onBehalfOfContentOwner, maxResults, videoCategoryId
  
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
     "youtube/v3/videos"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3/docs/videos/insert
  
  Required parameters: part
  
  Optional parameters: autoLevels, onBehalfOfContentOwner, notifySubscribers, stabilize, onBehalfOfContentOwnerChannel
  
  Body: 
  
  {:monetizationDetails {:access AccessPolicy},
   :localizations {},
   :snippet {:description string,
             :tags [string],
             :publishedAt string,
             :channelId string,
             :categoryId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :defaultAudioLanguage string,
             :liveBroadcastContent string,
             :localized VideoLocalization,
             :channelTitle string,
             :defaultLanguage string},
   :fileDetails {:creationTime string,
                 :fileSize string,
                 :fileType string,
                 :fileName string,
                 :bitrateBps string,
                 :videoStreams [VideoFileDetailsVideoStream],
                 :container string,
                 :durationMs string,
                 :audioStreams [VideoFileDetailsAudioStream]},
   :etag string,
   :recordingDetails {:recordingDate string,
                      :location GeoPoint,
                      :locationDescription string},
   :statistics {:dislikeCount string,
                :favoriteCount string,
                :likeCount string,
                :commentCount string,
                :viewCount string},
   :ageGating {:restricted boolean,
               :alcoholContent boolean,
               :videoGameRating string},
   :status {:uploadStatus string,
            :publicStatsViewable boolean,
            :license string,
            :embeddable boolean,
            :publishAt string,
            :madeForKids boolean,
            :privacyStatus string,
            :failureReason string,
            :rejectionReason string,
            :selfDeclaredMadeForKids boolean},
   :processingDetails {:processingFailureReason string,
                       :thumbnailsAvailability string,
                       :fileDetailsAvailability string,
                       :processingProgress VideoProcessingDetailsProcessingProgress,
                       :tagSuggestionsAvailability string,
                       :processingStatus string,
                       :editorSuggestionsAvailability string,
                       :processingIssuesAvailability string},
   :id string,
   :kind string,
   :liveStreamingDetails {:scheduledStartTime string,
                          :scheduledEndTime string,
                          :actualEndTime string,
                          :actualStartTime string,
                          :concurrentViewers string,
                          :activeLiveChatId string},
   :suggestions {:processingErrors [string],
                 :tagSuggestions [VideoSuggestionsTagSuggestion],
                 :processingHints [string],
                 :editorSuggestions [string],
                 :processingWarnings [string]},
   :contentDetails {:caption string,
                    :definition string,
                    :licensedContent boolean,
                    :duration string,
                    :contentRating ContentRating,
                    :countryRestriction AccessPolicy,
                    :regionRestriction VideoContentDetailsRegionRestriction,
                    :dimension string,
                    :projection string,
                    :hasCustomThumbnail boolean},
   :player {:embedWidth string, :embedHtml string, :embedHeight string},
   :projectDetails {},
   :topicDetails {:relevantTopicIds [string],
                  :topicCategories [string],
                  :topicIds [string]}}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/videos"
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

(defn rate$
  "https://developers.google.com/youtube/v3/docs/videos/rate
  
  Required parameters: id, rating
  
  Optional parameters: none
  
  Adds a like or dislike rating to a video or removes a rating from a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :rating})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/videos/rate"
     #{:id :rating}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getRating$
  "https://developers.google.com/youtube/v3/docs/videos/getRating
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  
  Retrieves the ratings that the authorized user gave to a list of specified videos."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/videos/getRating"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/youtube/v3/docs/videos/delete
  
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
     "youtube/v3/videos"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
