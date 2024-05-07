(ns happygapi.kgsearch.entities
  "Knowledge Graph Search API: entities.
  Searches the Google Knowledge Graph for entities.
  See: https://developers.google.com/knowledge-graph/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/knowledge-graph
  
  Required parameters: none
  
  Optional parameters: types, indent, limit, prefix, query, languages, ids
  
  Searches Knowledge Graph for entities that match the constraints. A list of matched entities will be returned in response, which will be in JSON-LD format and compatible with http://schema.org"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://kgsearch.googleapis.com/"
     "v1/entities:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
