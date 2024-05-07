(ns happygapi.solar.dataLayers
  "Solar API: dataLayers.
  Solar API.
  See: https://developers.google.com/maps/documentation/solar"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/maps/documentation/solar/reference/rest/v1/dataLayers/get
  
  Required parameters: none
  
  Optional parameters: location.latitude, radiusMeters, requiredQuality, view, exactQualityRequired, pixelSizeMeters, location.longitude
  
  Gets solar information for a region surrounding a location. Returns an error with code `NOT_FOUND` if the location is outside the coverage area."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://solar.googleapis.com/"
     "v1/dataLayers:get"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
