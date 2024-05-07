(ns happygapi.walletobjects.giftcardobject
  "Google Wallet API: giftcardobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/wallet/reference/rest/v1/giftcardobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the gift card object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/giftcardobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:cardNumber string,
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :renderEncoding string,
                     :alternateText string,
                     :type string,
                     :showCodeText LocalizedString,
                     :valuePattern string,
                     :initialRotatingBarcodeValues RotatingBarcodeValues},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :barcode {:type string,
             :alternateText string,
             :renderEncoding string,
             :value string,
             :showCodeText LocalizedString,
             :kind string},
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :classReference {:wordMark Image,
                    :reviewStatus string,
                    :wideProgramLogo Image,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :localizedEventNumberLabel LocalizedString,
                    :pinLabel string,
                    :merchantName string,
                    :localizedMerchantName LocalizedString,
                    :homepageUri Uri,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :programLogo Image,
                    :id string,
                    :kind string,
                    :localizedPinLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :cardNumberLabel string,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :allowBarcodeRedemption boolean,
                    :eventNumberLabel string,
                    :countryCode string,
                    :localizedCardNumberLabel LocalizedString},
   :disableExpirationNotification boolean,
   :pin string,
   :eventNumber string,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :validTimeInterval {:kind string, :start DateTime, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :balance {:kind string, :currencyCode string, :micros string},
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :balanceUpdateTime {:date string},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString}}
  
  Updates the gift card object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/giftcardobject/addmessage
  
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
  
  Adds a message to the gift card object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardObject/{resourceId}/addMessage"
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
  "https://developers.google.com/wallet/reference/rest/v1/giftcardobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:cardNumber string,
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :renderEncoding string,
                     :alternateText string,
                     :type string,
                     :showCodeText LocalizedString,
                     :valuePattern string,
                     :initialRotatingBarcodeValues RotatingBarcodeValues},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :barcode {:type string,
             :alternateText string,
             :renderEncoding string,
             :value string,
             :showCodeText LocalizedString,
             :kind string},
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :classReference {:wordMark Image,
                    :reviewStatus string,
                    :wideProgramLogo Image,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :localizedEventNumberLabel LocalizedString,
                    :pinLabel string,
                    :merchantName string,
                    :localizedMerchantName LocalizedString,
                    :homepageUri Uri,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :programLogo Image,
                    :id string,
                    :kind string,
                    :localizedPinLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :cardNumberLabel string,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :allowBarcodeRedemption boolean,
                    :eventNumberLabel string,
                    :countryCode string,
                    :localizedCardNumberLabel LocalizedString},
   :disableExpirationNotification boolean,
   :pin string,
   :eventNumber string,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :validTimeInterval {:kind string, :start DateTime, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :balance {:kind string, :currencyCode string, :micros string},
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :balanceUpdateTime {:date string},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString}}
  
  Updates the gift card object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/giftcardobject/list
  
  Required parameters: none
  
  Optional parameters: token, classId, maxResults
  
  Returns a list of all gift card objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardObject"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/wallet/reference/rest/v1/giftcardobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:cardNumber string,
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :renderEncoding string,
                     :alternateText string,
                     :type string,
                     :showCodeText LocalizedString,
                     :valuePattern string,
                     :initialRotatingBarcodeValues RotatingBarcodeValues},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :barcode {:type string,
             :alternateText string,
             :renderEncoding string,
             :value string,
             :showCodeText LocalizedString,
             :kind string},
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :classReference {:wordMark Image,
                    :reviewStatus string,
                    :wideProgramLogo Image,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :localizedEventNumberLabel LocalizedString,
                    :pinLabel string,
                    :merchantName string,
                    :localizedMerchantName LocalizedString,
                    :homepageUri Uri,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :programLogo Image,
                    :id string,
                    :kind string,
                    :localizedPinLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :cardNumberLabel string,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :allowBarcodeRedemption boolean,
                    :eventNumberLabel string,
                    :countryCode string,
                    :localizedCardNumberLabel LocalizedString},
   :disableExpirationNotification boolean,
   :pin string,
   :eventNumber string,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :validTimeInterval {:kind string, :start DateTime, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :balance {:kind string, :currencyCode string, :micros string},
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :balanceUpdateTime {:date string},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString}}
  
  Inserts an gift card object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardObject"
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
