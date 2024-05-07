(ns happygapi.books.onboarding
  "Books API: onboarding.
  The Google Books API allows clients to access the Google Books repository.
  See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listCategories$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/onboarding/listCategories
  
  Required parameters: none
  
  Optional parameters: locale
  
  List categories for onboarding experience."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/onboarding/listCategories"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listCategoryVolumes$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/onboarding/listCategoryVolumes
  
  Required parameters: none
  
  Optional parameters: categoryId, locale, maxAllowedMaturityRating, pageSize, pageToken
  
  List available volumes under categories for onboarding experience."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/onboarding/listCategoryVolumes"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
