(ns happygapi.books.cloudloading
  "Books API: cloudloading.
  The Google Books API allows clients to access the Google Books repository.
  See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addBook$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/cloudloading/addBook
  
  Required parameters: none
  
  Optional parameters: drive_document_id, mime_type, name, upload_client_token
  
  Add a user-upload volume and triggers processing."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/cloudloading/addBook"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deleteBook$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/cloudloading/deleteBook
  
  Required parameters: volumeId
  
  Optional parameters: none
  
  Remove the book and its contents"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/cloudloading/deleteBook"
     #{:volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateBook$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/cloudloading/updateBook
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:volumeId string,
   :title string,
   :author string,
   :processingState string}
  
  Updates a user-upload volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/cloudloading/updateBook"
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
