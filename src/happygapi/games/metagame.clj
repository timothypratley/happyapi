(ns happygapi.games.metagame
  "Google Play Game Services: metagame.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://games.withgoogle.com/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getMetagameConfig$
  "https://games.withgoogle.com
  
  Required parameters: none
  
  Optional parameters: none
  
  Return the metagame configuration data for the calling application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/metagameConfig"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listCategoriesByPlayer$
  "https://games.withgoogle.com
  
  Required parameters: playerId, collection
  
  Optional parameters: language, maxResults, pageToken
  
  List play data aggregated per category for the player corresponding to `playerId`."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/{playerId}/categories/{collection}"
     #{:playerId :collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
