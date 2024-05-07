(ns happygapi.chromepolicy.media
  "Chrome Policy API: media.
  The Chrome Policy API is a suite of services that allows Chrome administrators to control the policies applied to their managed Chrome OS devices and Chrome browsers.
  See: https://developers.google.com/chrome/policy"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://developers.google.com/chrome/policy/reference/rest/v1/media/upload
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:policyField string}
  
  Creates an enterprise file from the content provided by user. Returns a public download url for end user."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/files:uploadPolicyFile"
     #{:customer}
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
