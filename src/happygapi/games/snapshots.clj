(ns happygapi.games.snapshots
  "Google Play Game Services: snapshots.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://games.withgoogle.com/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://games.withgoogle.com
  
  Required parameters: snapshotId
  
  Optional parameters: language
  
  Retrieves the metadata for a given snapshot ID."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:snapshotId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/snapshots/{snapshotId}"
     #{:snapshotId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://games.withgoogle.com
  
  Required parameters: playerId
  
  Optional parameters: language, maxResults, pageToken
  
  Retrieves a list of snapshots created by your application for the player corresponding to the player ID."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/{playerId}/snapshots"
     #{:playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
