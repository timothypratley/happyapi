(ns happygapi.walletobjects.giftcardclass
  "Google Wallet API: giftcardclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/wallet/reference/rest/v1/giftcardclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the gift card class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/giftcardclass/list
  
  Required parameters: none
  
  Optional parameters: token, maxResults, issuerId
  
  Returns a list of all gift card classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addmessage$
  "https://developers.google.com/wallet/reference/rest/v1/giftcardclass/addmessage
  
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
  
  Adds a message to the gift card class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}/addMessage"
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

(defn patch$
  "https://developers.google.com/wallet/reference/rest/v1/giftcardclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :wideProgramLogo {:kind string,
                     :sourceUri ImageUri,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:translatedValues [TranslatedString],
                           :kind string,
                           :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :callbackOptions {:url string, :updateRequestUrl string},
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
   :redemptionIssuers [string],
   :review {:comments string},
   :programLogo {:kind string,
                 :sourceUri ImageUri,
                 :contentDescription LocalizedString},
   :id string,
   :kind string,
   :localizedPinLabel {:translatedValues [TranslatedString],
                       :kind string,
                       :defaultValue TranslatedString},
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString}}
  
  Updates the gift card class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}"
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

(defn update$
  "https://developers.google.com/wallet/reference/rest/v1/giftcardclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :wideProgramLogo {:kind string,
                     :sourceUri ImageUri,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:translatedValues [TranslatedString],
                           :kind string,
                           :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :callbackOptions {:url string, :updateRequestUrl string},
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
   :redemptionIssuers [string],
   :review {:comments string},
   :programLogo {:kind string,
                 :sourceUri ImageUri,
                 :contentDescription LocalizedString},
   :id string,
   :kind string,
   :localizedPinLabel {:translatedValues [TranslatedString],
                       :kind string,
                       :defaultValue TranslatedString},
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString}}
  
  Updates the gift card class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/giftcardclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :wideProgramLogo {:kind string,
                     :sourceUri ImageUri,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:translatedValues [TranslatedString],
                           :kind string,
                           :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :callbackOptions {:url string, :updateRequestUrl string},
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
   :redemptionIssuers [string],
   :review {:comments string},
   :programLogo {:kind string,
                 :sourceUri ImageUri,
                 :contentDescription LocalizedString},
   :id string,
   :kind string,
   :localizedPinLabel {:translatedValues [TranslatedString],
                       :kind string,
                       :defaultValue TranslatedString},
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString}}
  
  Inserts an gift card class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass"
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
