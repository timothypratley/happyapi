(ns happygapi.books.promooffer
  "Books API: promooffer.
  The Google Books API allows clients to access the Google Books repository.
  See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn accept$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/promooffer/accept
  
  Required parameters: none
  
  Optional parameters: androidId, device, manufacturer, model, offerId, product, serial, volumeId
  
  Accepts the promo offer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/promooffer/accept"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dismiss$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/promooffer/dismiss
  
  Required parameters: none
  
  Optional parameters: androidId, device, manufacturer, model, offerId, product, serial
  
  Marks the promo offer as dismissed."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/promooffer/dismiss"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/promooffer/get
  
  Required parameters: none
  
  Optional parameters: androidId, device, manufacturer, model, product, serial
  
  Returns a list of promo offers available to the user"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/promooffer/get"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
