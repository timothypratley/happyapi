(ns happygapi.walletobjects.transitobject
  "Google Wallet API: transitobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/wallet/reference/rest/v1/transitobject/list
  
  Required parameters: none
  
  Optional parameters: token, classId, maxResults
  
  Returns a list of all transit objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/wallet/reference/rest/v1/transitobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:ticketStatus string,
   :purchaseDetails {:ticketCost TicketCost,
                     :confirmationCode string,
                     :purchaseReceiptNumber string,
                     :accountId string,
                     :purchaseDateTime string},
   :ticketLegs [{:originName LocalizedString,
                 :destinationName LocalizedString,
                 :zone string,
                 :originStationCode string,
                 :transitOperatorName LocalizedString,
                 :ticketSeats [TicketSeat],
                 :transitTerminusName LocalizedString,
                 :destinationStationCode string,
                 :arrivalDateTime string,
                 :departureDateTime string,
                 :ticketSeat TicketSeat,
                 :fareName LocalizedString,
                 :platform string,
                 :carriage string}],
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
   :tripType string,
   :barcode {:type string,
             :alternateText string,
             :renderEncoding string,
             :value string,
             :showCodeText LocalizedString,
             :kind string},
   :passengerType string,
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :customConcessionCategory {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString},
   :classReference {:wordMark Image,
                    :transitType string,
                    :customFareNameLabel LocalizedString,
                    :customDiscountMessageLabel LocalizedString,
                    :customPlatformLabel LocalizedString,
                    :reviewStatus string,
                    :customRouteRestrictionsDetailsLabel LocalizedString,
                    :customCarriageLabel LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :customZoneLabel LocalizedString,
                    :customFareClassLabel LocalizedString,
                    :customPurchaseReceiptNumberLabel LocalizedString,
                    :logo Image,
                    :activationOptions ActivationOptions,
                    :enableSingleLegItinerary boolean,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :transitOperatorName LocalizedString,
                    :homepageUri Uri,
                    :customConcessionCategoryLabel LocalizedString,
                    :customSeatLabel LocalizedString,
                    :customTransitTerminusNameLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :customRouteRestrictionsLabel LocalizedString,
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :customTimeRestrictionsLabel LocalizedString,
                    :customOtherRestrictionsLabel LocalizedString,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :customPurchaseFaceValueLabel LocalizedString,
                    :customConfirmationCodeLabel LocalizedString,
                    :customCoachLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :customPurchasePriceLabel LocalizedString,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :watermark Image,
                    :countryCode string,
                    :customTicketNumberLabel LocalizedString,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :ticketLeg {:originName LocalizedString,
               :destinationName LocalizedString,
               :zone string,
               :originStationCode string,
               :transitOperatorName LocalizedString,
               :ticketSeats [TicketSeat],
               :transitTerminusName LocalizedString,
               :destinationStationCode string,
               :arrivalDateTime string,
               :departureDateTime string,
               :ticketSeat TicketSeat,
               :fareName LocalizedString,
               :platform string,
               :carriage string},
   :validTimeInterval {:kind string, :start DateTime, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :ticketNumber string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :concessionCategory string,
   :passengerNames string,
   :ticketRestrictions {:routeRestrictions LocalizedString,
                        :timeRestrictions LocalizedString,
                        :otherRestrictions LocalizedString,
                        :routeRestrictionsDetails LocalizedString},
   :tripId string,
   :version string,
   :deviceContext {:deviceToken string},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :customTicketStatus {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :activationStatus {:state string}}
  
  Updates the transit object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/transitobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:ticketStatus string,
   :purchaseDetails {:ticketCost TicketCost,
                     :confirmationCode string,
                     :purchaseReceiptNumber string,
                     :accountId string,
                     :purchaseDateTime string},
   :ticketLegs [{:originName LocalizedString,
                 :destinationName LocalizedString,
                 :zone string,
                 :originStationCode string,
                 :transitOperatorName LocalizedString,
                 :ticketSeats [TicketSeat],
                 :transitTerminusName LocalizedString,
                 :destinationStationCode string,
                 :arrivalDateTime string,
                 :departureDateTime string,
                 :ticketSeat TicketSeat,
                 :fareName LocalizedString,
                 :platform string,
                 :carriage string}],
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
   :tripType string,
   :barcode {:type string,
             :alternateText string,
             :renderEncoding string,
             :value string,
             :showCodeText LocalizedString,
             :kind string},
   :passengerType string,
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :customConcessionCategory {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString},
   :classReference {:wordMark Image,
                    :transitType string,
                    :customFareNameLabel LocalizedString,
                    :customDiscountMessageLabel LocalizedString,
                    :customPlatformLabel LocalizedString,
                    :reviewStatus string,
                    :customRouteRestrictionsDetailsLabel LocalizedString,
                    :customCarriageLabel LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :customZoneLabel LocalizedString,
                    :customFareClassLabel LocalizedString,
                    :customPurchaseReceiptNumberLabel LocalizedString,
                    :logo Image,
                    :activationOptions ActivationOptions,
                    :enableSingleLegItinerary boolean,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :transitOperatorName LocalizedString,
                    :homepageUri Uri,
                    :customConcessionCategoryLabel LocalizedString,
                    :customSeatLabel LocalizedString,
                    :customTransitTerminusNameLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :customRouteRestrictionsLabel LocalizedString,
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :customTimeRestrictionsLabel LocalizedString,
                    :customOtherRestrictionsLabel LocalizedString,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :customPurchaseFaceValueLabel LocalizedString,
                    :customConfirmationCodeLabel LocalizedString,
                    :customCoachLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :customPurchasePriceLabel LocalizedString,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :watermark Image,
                    :countryCode string,
                    :customTicketNumberLabel LocalizedString,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :ticketLeg {:originName LocalizedString,
               :destinationName LocalizedString,
               :zone string,
               :originStationCode string,
               :transitOperatorName LocalizedString,
               :ticketSeats [TicketSeat],
               :transitTerminusName LocalizedString,
               :destinationStationCode string,
               :arrivalDateTime string,
               :departureDateTime string,
               :ticketSeat TicketSeat,
               :fareName LocalizedString,
               :platform string,
               :carriage string},
   :validTimeInterval {:kind string, :start DateTime, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :ticketNumber string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :concessionCategory string,
   :passengerNames string,
   :ticketRestrictions {:routeRestrictions LocalizedString,
                        :timeRestrictions LocalizedString,
                        :otherRestrictions LocalizedString,
                        :routeRestrictionsDetails LocalizedString},
   :tripId string,
   :version string,
   :deviceContext {:deviceToken string},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :customTicketStatus {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :activationStatus {:state string}}
  
  Inserts an transit object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject"
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

(defn addmessage$
  "https://developers.google.com/wallet/reference/rest/v1/transitobject/addmessage
  
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
  
  Adds a message to the transit object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}/addMessage"
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
  "https://developers.google.com/wallet/reference/rest/v1/transitobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:ticketStatus string,
   :purchaseDetails {:ticketCost TicketCost,
                     :confirmationCode string,
                     :purchaseReceiptNumber string,
                     :accountId string,
                     :purchaseDateTime string},
   :ticketLegs [{:originName LocalizedString,
                 :destinationName LocalizedString,
                 :zone string,
                 :originStationCode string,
                 :transitOperatorName LocalizedString,
                 :ticketSeats [TicketSeat],
                 :transitTerminusName LocalizedString,
                 :destinationStationCode string,
                 :arrivalDateTime string,
                 :departureDateTime string,
                 :ticketSeat TicketSeat,
                 :fareName LocalizedString,
                 :platform string,
                 :carriage string}],
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
   :tripType string,
   :barcode {:type string,
             :alternateText string,
             :renderEncoding string,
             :value string,
             :showCodeText LocalizedString,
             :kind string},
   :passengerType string,
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :customConcessionCategory {:translatedValues [TranslatedString],
                              :kind string,
                              :defaultValue TranslatedString},
   :classReference {:wordMark Image,
                    :transitType string,
                    :customFareNameLabel LocalizedString,
                    :customDiscountMessageLabel LocalizedString,
                    :customPlatformLabel LocalizedString,
                    :reviewStatus string,
                    :customRouteRestrictionsDetailsLabel LocalizedString,
                    :customCarriageLabel LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :customZoneLabel LocalizedString,
                    :customFareClassLabel LocalizedString,
                    :customPurchaseReceiptNumberLabel LocalizedString,
                    :logo Image,
                    :activationOptions ActivationOptions,
                    :enableSingleLegItinerary boolean,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :transitOperatorName LocalizedString,
                    :homepageUri Uri,
                    :customConcessionCategoryLabel LocalizedString,
                    :customSeatLabel LocalizedString,
                    :customTransitTerminusNameLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :customRouteRestrictionsLabel LocalizedString,
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :customTimeRestrictionsLabel LocalizedString,
                    :customOtherRestrictionsLabel LocalizedString,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :customPurchaseFaceValueLabel LocalizedString,
                    :customConfirmationCodeLabel LocalizedString,
                    :customCoachLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :customPurchasePriceLabel LocalizedString,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :watermark Image,
                    :countryCode string,
                    :customTicketNumberLabel LocalizedString,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
   :ticketLeg {:originName LocalizedString,
               :destinationName LocalizedString,
               :zone string,
               :originStationCode string,
               :transitOperatorName LocalizedString,
               :ticketSeats [TicketSeat],
               :transitTerminusName LocalizedString,
               :destinationStationCode string,
               :arrivalDateTime string,
               :departureDateTime string,
               :ticketSeat TicketSeat,
               :fareName LocalizedString,
               :platform string,
               :carriage string},
   :validTimeInterval {:kind string, :start DateTime, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:header string,
               :id string,
               :kind string,
               :messageType string,
               :body string,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString,
               :displayInterval TimeInterval}],
   :ticketNumber string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :concessionCategory string,
   :passengerNames string,
   :ticketRestrictions {:routeRestrictions LocalizedString,
                        :timeRestrictions LocalizedString,
                        :otherRestrictions LocalizedString,
                        :routeRestrictionsDetails LocalizedString},
   :tripId string,
   :version string,
   :deviceContext {:deviceToken string},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :customTicketStatus {:translatedValues [TranslatedString],
                        :kind string,
                        :defaultValue TranslatedString},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :activationStatus {:state string}}
  
  Updates the transit object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/transitobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the transit object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
