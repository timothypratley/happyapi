(ns happygapi.youtube.liveChatMessages
  "YouTube Data API v3: liveChatMessages.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/v3/docs/liveChatMessages/list
  
  Required parameters: part, liveChatId
  
  Optional parameters: pageToken, hl, maxResults, profileImageSize
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :liveChatId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveChat/messages"
     #{:part :liveChatId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3/docs/liveChatMessages/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:authorDetails {:isChatModerator boolean,
                   :channelUrl string,
                   :isVerified boolean,
                   :isChatSponsor boolean,
                   :profileImageUrl string,
                   :channelId string,
                   :isChatOwner boolean,
                   :displayName string},
   :id string,
   :kind string,
   :etag string,
   :snippet {:publishedAt string,
             :superChatDetails LiveChatSuperChatDetails,
             :messageDeletedDetails LiveChatMessageDeletedDetails,
             :hasDisplayContent boolean,
             :superStickerDetails LiveChatSuperStickerDetails,
             :type string,
             :newSponsorDetails LiveChatNewSponsorDetails,
             :pollDetails LiveChatPollDetails,
             :giftMembershipReceivedDetails LiveChatGiftMembershipReceivedDetails,
             :fanFundingEventDetails LiveChatFanFundingEventDetails,
             :memberMilestoneChatDetails LiveChatMemberMilestoneChatDetails,
             :textMessageDetails LiveChatTextMessageDetails,
             :authorChannelId string,
             :userBannedDetails LiveChatUserBannedMessageDetails,
             :liveChatId string,
             :displayMessage string,
             :messageRetractedDetails LiveChatMessageRetractedDetails,
             :membershipGiftingDetails LiveChatMembershipGiftingDetails}}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveChat/messages"
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
  "https://developers.google.com/youtube/v3/docs/liveChatMessages/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a chat message."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveChat/messages"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
