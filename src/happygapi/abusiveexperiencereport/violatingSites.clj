(ns happygapi.abusiveexperiencereport.violatingSites
  "Abusive Experience Report API: violatingSites.
  Views Abusive Experience Report data, and gets a list of sites that have a significant number of abusive experiences.
  See: https://developers.google.com/abusive-experience-report/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/abusive-experience-report/v1/reference/rest/v1/violatingSites/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Lists sites that are failing in the Abusive Experience Report."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://abusiveexperiencereport.googleapis.com/"
     "v1/violatingSites"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
