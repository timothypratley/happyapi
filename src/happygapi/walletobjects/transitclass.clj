(ns happygapi.walletobjects.transitclass
  "Google Wallet API: transitclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/wallet/reference/rest/v1/transitclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the transit class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/wallet/reference/rest/v1/transitclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :transitType string,
   :customFareNameLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :customDiscountMessageLabel {:translatedValues [TranslatedString],
                                :kind string,
                                :defaultValue TranslatedString},
   :customPlatformLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:translatedValues [TranslatedString],
                                         :kind string,
                                         :defaultValue TranslatedString},
   :customCarriageLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :customZoneLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customFareClassLabel {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :customPurchaseReceiptNumberLabel {:translatedValues [TranslatedString],
                                      :kind string,
                                      :defaultValue TranslatedString},
   :logo {:kind string,
          :sourceUri ImageUri,
          :contentDescription LocalizedString},
   :activationOptions {:activationUrl string,
                       :allowReactivation boolean},
   :enableSingleLegItinerary boolean,
   :wideLogo {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :customConcessionCategoryLabel {:translatedValues [TranslatedString],
                                   :kind string,
                                   :defaultValue TranslatedString},
   :customSeatLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customTransitTerminusNameLabel {:translatedValues [TranslatedString],
                                    :kind string,
                                    :defaultValue TranslatedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :customRouteRestrictionsLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :customOtherRestrictionsLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
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
   :id string,
   :customPurchaseFaceValueLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
   :customConfirmationCodeLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :customCoachLabel {:translatedValues [TranslatedString],
                      :kind string,
                      :defaultValue TranslatedString},
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString},
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :watermark {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :countryCode string,
   :customTicketNumberLabel {:translatedValues [TranslatedString],
                             :kind string,
                             :defaultValue TranslatedString},
   :languageOverride string}
  
  Updates the transit class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/transitclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :transitType string,
   :customFareNameLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :customDiscountMessageLabel {:translatedValues [TranslatedString],
                                :kind string,
                                :defaultValue TranslatedString},
   :customPlatformLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:translatedValues [TranslatedString],
                                         :kind string,
                                         :defaultValue TranslatedString},
   :customCarriageLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :customZoneLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customFareClassLabel {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :customPurchaseReceiptNumberLabel {:translatedValues [TranslatedString],
                                      :kind string,
                                      :defaultValue TranslatedString},
   :logo {:kind string,
          :sourceUri ImageUri,
          :contentDescription LocalizedString},
   :activationOptions {:activationUrl string,
                       :allowReactivation boolean},
   :enableSingleLegItinerary boolean,
   :wideLogo {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :customConcessionCategoryLabel {:translatedValues [TranslatedString],
                                   :kind string,
                                   :defaultValue TranslatedString},
   :customSeatLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customTransitTerminusNameLabel {:translatedValues [TranslatedString],
                                    :kind string,
                                    :defaultValue TranslatedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :customRouteRestrictionsLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :customOtherRestrictionsLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
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
   :id string,
   :customPurchaseFaceValueLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
   :customConfirmationCodeLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :customCoachLabel {:translatedValues [TranslatedString],
                      :kind string,
                      :defaultValue TranslatedString},
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString},
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :watermark {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :countryCode string,
   :customTicketNumberLabel {:translatedValues [TranslatedString],
                             :kind string,
                             :defaultValue TranslatedString},
   :languageOverride string}
  
  Inserts a transit class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass"
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
  "https://developers.google.com/wallet/reference/rest/v1/transitclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :transitType string,
   :customFareNameLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :customDiscountMessageLabel {:translatedValues [TranslatedString],
                                :kind string,
                                :defaultValue TranslatedString},
   :customPlatformLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:translatedValues [TranslatedString],
                                         :kind string,
                                         :defaultValue TranslatedString},
   :customCarriageLabel {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :customZoneLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customFareClassLabel {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :customPurchaseReceiptNumberLabel {:translatedValues [TranslatedString],
                                      :kind string,
                                      :defaultValue TranslatedString},
   :logo {:kind string,
          :sourceUri ImageUri,
          :contentDescription LocalizedString},
   :activationOptions {:activationUrl string,
                       :allowReactivation boolean},
   :enableSingleLegItinerary boolean,
   :wideLogo {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:translatedValues [TranslatedString],
                         :kind string,
                         :defaultValue TranslatedString},
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :customConcessionCategoryLabel {:translatedValues [TranslatedString],
                                   :kind string,
                                   :defaultValue TranslatedString},
   :customSeatLabel {:translatedValues [TranslatedString],
                     :kind string,
                     :defaultValue TranslatedString},
   :customTransitTerminusNameLabel {:translatedValues [TranslatedString],
                                    :kind string,
                                    :defaultValue TranslatedString},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :customRouteRestrictionsLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :customOtherRestrictionsLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
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
   :id string,
   :customPurchaseFaceValueLabel {:translatedValues [TranslatedString],
                                  :kind string,
                                  :defaultValue TranslatedString},
   :customConfirmationCodeLabel {:translatedValues [TranslatedString],
                                 :kind string,
                                 :defaultValue TranslatedString},
   :customCoachLabel {:translatedValues [TranslatedString],
                      :kind string,
                      :defaultValue TranslatedString},
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString},
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :watermark {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :countryCode string,
   :customTicketNumberLabel {:translatedValues [TranslatedString],
                             :kind string,
                             :defaultValue TranslatedString},
   :languageOverride string}
  
  Updates the transit class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/transitclass/addmessage
  
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
  
  Adds a message to the transit class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}/addMessage"
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

(defn list$
  "https://developers.google.com/wallet/reference/rest/v1/transitclass/list
  
  Required parameters: none
  
  Optional parameters: token, maxResults, issuerId
  
  Returns a list of all transit classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
