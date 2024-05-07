(ns happygapi.walletobjects.offerclass
  "Google Wallet API: offerclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/wallet/reference/rest/v1/offerclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:kind string,
             :id string,
             :uri string,
             :description string,
             :localizedDescription LocalizedString},
   :wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedFinePrint {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :localizedTitle {:translatedValues [TranslatedString],
                    :kind string,
                    :defaultValue TranslatedString},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:translatedValues [TranslatedString],
                       :kind string,
                       :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :titleImage {:kind string,
                :sourceUri ImageUri,
                :contentDescription LocalizedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :title string,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :locations [{:latitude number, :kind string, :longitude number}],
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
   :localizedIssuerName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :wideTitleImage {:kind string,
                    :sourceUri ImageUri,
                    :contentDescription LocalizedString},
   :id string,
   :kind string,
   :finePrint string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :provider string,
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :localizedDetails {:translatedValues [TranslatedString],
                      :kind string,
                      :defaultValue TranslatedString},
   :countryCode string}
  
  Updates the offer class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/offerclass/addmessage
  
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
  
  Adds a message to the offer class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}/addMessage"
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
  "https://developers.google.com/wallet/reference/rest/v1/offerclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:kind string,
             :id string,
             :uri string,
             :description string,
             :localizedDescription LocalizedString},
   :wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedFinePrint {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :localizedTitle {:translatedValues [TranslatedString],
                    :kind string,
                    :defaultValue TranslatedString},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:translatedValues [TranslatedString],
                       :kind string,
                       :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :titleImage {:kind string,
                :sourceUri ImageUri,
                :contentDescription LocalizedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :title string,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :locations [{:latitude number, :kind string, :longitude number}],
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
   :localizedIssuerName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :wideTitleImage {:kind string,
                    :sourceUri ImageUri,
                    :contentDescription LocalizedString},
   :id string,
   :kind string,
   :finePrint string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :provider string,
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :localizedDetails {:translatedValues [TranslatedString],
                      :kind string,
                      :defaultValue TranslatedString},
   :countryCode string}
  
  Inserts an offer class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass"
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

(defn update$
  "https://developers.google.com/wallet/reference/rest/v1/offerclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:kind string,
             :id string,
             :uri string,
             :description string,
             :localizedDescription LocalizedString},
   :wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedFinePrint {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :localizedTitle {:translatedValues [TranslatedString],
                    :kind string,
                    :defaultValue TranslatedString},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:translatedValues [TranslatedString],
                       :kind string,
                       :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :titleImage {:kind string,
                :sourceUri ImageUri,
                :contentDescription LocalizedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :title string,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :locations [{:latitude number, :kind string, :longitude number}],
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
   :localizedIssuerName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :wideTitleImage {:kind string,
                    :sourceUri ImageUri,
                    :contentDescription LocalizedString},
   :id string,
   :kind string,
   :finePrint string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :provider string,
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :localizedDetails {:translatedValues [TranslatedString],
                      :kind string,
                      :defaultValue TranslatedString},
   :countryCode string}
  
  Updates the offer class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}"
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

(defn get$
  "https://developers.google.com/wallet/reference/rest/v1/offerclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the offer class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/offerclass/list
  
  Required parameters: none
  
  Optional parameters: issuerId, maxResults, token
  
  Returns a list of all offer classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
