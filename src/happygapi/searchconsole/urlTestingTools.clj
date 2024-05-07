(ns happygapi.searchconsole.urlTestingTools
  "Google Search Console API: urlTestingTools.
  The Search Console API provides access to both Search Console data (verified users only) and to public information on an URL basis (anyone)
  See: https://developer.chrome.com/docs/lighthouse/overview/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn mobileFriendlyTest-run$
  "https://developer.chrome.com/docs/lighthouse/overview
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requestScreenshot boolean, :url string}
  
  Runs Mobile-Friendly Test for a given URL."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "v1/urlTestingTools/mobileFriendlyTest:run"
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
