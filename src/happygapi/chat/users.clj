(ns happygapi.chat.users
  "Google Chat API: users.
  The Google Chat API lets you build Chat apps to integrate your services with Google Chat and manage Chat resources such as spaces, members, and messages.
  See: https://developers.google.com/workspace/chat"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn spaces-getSpaceReadState$
  "https://developers.google.com/workspace/chat/reference/rest/v1/users/spaces/getSpaceReadState
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns details about a user's read state within a space, used to identify read and unread messages. Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)."
  {:scopes ["https://www.googleapis.com/auth/chat.users.readstate"
            "https://www.googleapis.com/auth/chat.users.readstate.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn spaces-updateSpaceReadState$
  "https://developers.google.com/workspace/chat/reference/rest/v1/users/spaces/updateSpaceReadState
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :lastReadTime string}
  
  Updates a user's read state within a space, used to identify read and unread messages. Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)."
  {:scopes ["https://www.googleapis.com/auth/chat.users.readstate"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn spaces-threads-getThreadReadState$
  "https://developers.google.com/workspace/chat/reference/rest/v1/users/spaces/threads/getThreadReadState
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns details about a user's read state within a thread, used to identify read and unread messages. Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)."
  {:scopes ["https://www.googleapis.com/auth/chat.users.readstate"
            "https://www.googleapis.com/auth/chat.users.readstate.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
