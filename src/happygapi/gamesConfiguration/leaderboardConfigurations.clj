(ns happygapi.gamesConfiguration.leaderboardConfigurations
  "Google Play Game Services Publishing API: leaderboardConfigurations.
  The Google Play Game Services Publishing API allows developers to configure their games in Game Services.
  See: https://games.withgoogle.com/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://games.withgoogle.com
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Delete the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/leaderboards/{leaderboardId}"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://games.withgoogle.com
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Retrieves the metadata of the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/leaderboards/{leaderboardId}"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://games.withgoogle.com
  
  Required parameters: applicationId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :token string,
   :id string,
   :scoreOrder string,
   :scoreMin string,
   :scoreMax string,
   :draft {:kind string,
           :name LocalizedStringBundle,
           :iconUrl string,
           :sortRank integer,
           :scoreFormat GamesNumberFormatConfiguration},
   :published {:kind string,
               :name LocalizedStringBundle,
               :iconUrl string,
               :sortRank integer,
               :scoreFormat GamesNumberFormatConfiguration}}
  
  Insert a new leaderboard configuration in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/applications/{applicationId}/leaderboards"
     #{:applicationId}
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
  "https://games.withgoogle.com
  
  Required parameters: applicationId
  
  Optional parameters: maxResults, pageToken
  
  Returns a list of the leaderboard configurations in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/applications/{applicationId}/leaderboards"
     #{:applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://games.withgoogle.com
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :token string,
   :id string,
   :scoreOrder string,
   :scoreMin string,
   :scoreMax string,
   :draft {:kind string,
           :name LocalizedStringBundle,
           :iconUrl string,
           :sortRank integer,
           :scoreFormat GamesNumberFormatConfiguration},
   :published {:kind string,
               :name LocalizedStringBundle,
               :iconUrl string,
               :sortRank integer,
               :scoreFormat GamesNumberFormatConfiguration}}
  
  Update the metadata of the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/leaderboards/{leaderboardId}"
     #{:leaderboardId}
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
