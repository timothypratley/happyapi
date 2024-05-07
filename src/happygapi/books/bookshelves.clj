(ns happygapi.books.bookshelves
  "Books API: bookshelves.
  The Google Books API allows clients to access the Google Books repository.
  See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/bookshelves/get
  
  Required parameters: userId, shelf
  
  Optional parameters: source
  
  Retrieves metadata for a specific bookshelf for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/users/{userId}/bookshelves/{shelf}"
     #{:shelf :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/bookshelves/list
  
  Required parameters: userId
  
  Optional parameters: source
  
  Retrieves a list of public bookshelves for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/users/{userId}/bookshelves"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn volumes-list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/bookshelves/volumes/list
  
  Required parameters: userId, shelf
  
  Optional parameters: maxResults, showPreorders, source, startIndex
  
  Retrieves volumes in a specific bookshelf for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/users/{userId}/bookshelves/{shelf}/volumes"
     #{:shelf :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
