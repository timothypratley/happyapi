(ns happygapi.walletobjects.eventticketclass
  "Google Wallet API: eventticketclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the event ticket class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketclass/list
  
  Required parameters: none
  
  Optional parameters: issuerId, maxResults, token
  
  Returns a list of all event ticket classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :eventName {:translatedValues [TranslatedString],
               :kind string,
               :defaultValue TranslatedString},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :logo {:kind string,
          :sourceUri ImageUri,
          :contentDescription LocalizedString},
   :wideLogo {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :customSeatLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customSectionLabel {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:start string,
              :end string,
              :doorsOpenLabel string,
              :doorsOpen string,
              :kind string,
              :customDoorsOpenLabel LocalizedString},
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :sectionLabel string,
   :localizedIssuerName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:name LocalizedString,
           :kind string,
           :address LocalizedString},
   :customRowLabel {:translatedValues [TranslatedString],
                    :kind string,
                    :defaultValue TranslatedString},
   :finePrint {:translatedValues [TranslatedString],
               :kind string,
               :defaultValue TranslatedString},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :confirmationCodeLabel string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :countryCode string}
  
  Updates the event ticket class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}"
     #{:resourceId}
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

(defn insert$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :eventName {:translatedValues [TranslatedString],
               :kind string,
               :defaultValue TranslatedString},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :logo {:kind string,
          :sourceUri ImageUri,
          :contentDescription LocalizedString},
   :wideLogo {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :customSeatLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customSectionLabel {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:start string,
              :end string,
              :doorsOpenLabel string,
              :doorsOpen string,
              :kind string,
              :customDoorsOpenLabel LocalizedString},
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :sectionLabel string,
   :localizedIssuerName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:name LocalizedString,
           :kind string,
           :address LocalizedString},
   :customRowLabel {:translatedValues [TranslatedString],
                    :kind string,
                    :defaultValue TranslatedString},
   :finePrint {:translatedValues [TranslatedString],
               :kind string,
               :defaultValue TranslatedString},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :confirmationCodeLabel string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :countryCode string}
  
  Inserts an event ticket class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass"
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

(defn patch$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :eventName {:translatedValues [TranslatedString],
               :kind string,
               :defaultValue TranslatedString},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :logo {:kind string,
          :sourceUri ImageUri,
          :contentDescription LocalizedString},
   :wideLogo {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :customSeatLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customSectionLabel {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:start string,
              :end string,
              :doorsOpenLabel string,
              :doorsOpen string,
              :kind string,
              :customDoorsOpenLabel LocalizedString},
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :sectionLabel string,
   :localizedIssuerName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:name LocalizedString,
           :kind string,
           :address LocalizedString},
   :customRowLabel {:translatedValues [TranslatedString],
                    :kind string,
                    :defaultValue TranslatedString},
   :finePrint {:translatedValues [TranslatedString],
               :kind string,
               :defaultValue TranslatedString},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :confirmationCodeLabel string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :countryCode string}
  
  Updates the event ticket class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}"
     #{:resourceId}
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

(defn addmessage$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketclass/addmessage
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:message {:header string,
             :id string,
             :kind string,
             :messageType string,
             :body string,
             :localizedHeader LocalizedString,
             :localizedBody LocalizedString,
             :displayInterval TimeInterval}}
  
  Adds a message to the event ticket class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}/addMessage"
     #{:resourceId}
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
