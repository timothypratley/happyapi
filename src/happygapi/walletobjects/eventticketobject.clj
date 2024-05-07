(ns happygapi.walletobjects.eventticketobject
  "Google Wallet API: eventticketobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:faceValue {:kind string, :currencyCode string, :micros string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:kind string, :confirmationCode string},
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
   :seatInfo {:gate LocalizedString,
              :seat LocalizedString,
              :section LocalizedString,
              :row LocalizedString,
              :kind string},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :ticketType {:translatedValues [TranslatedString],
                :kind string,
                :defaultValue TranslatedString},
   :state string,
   :classReference {:wordMark Image,
                    :eventName LocalizedString,
                    :reviewStatus string,
                    :rowLabel string,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :logo Image,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :customSeatLabel LocalizedString,
                    :customSectionLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :eventId string,
                    :locations [LatLongPoint],
                    :dateTime EventDateTime,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :sectionLabel string,
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :kind string,
                    :venue EventVenue,
                    :customRowLabel LocalizedString,
                    :finePrint LocalizedString,
                    :gateLabel string,
                    :seatLabel string,
                    :customConfirmationCodeLabel LocalizedString,
                    :confirmationCodeLabel string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :customGateLabel LocalizedString,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
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
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :ticketHolderName string}
  
  Updates the event ticket object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:faceValue {:kind string, :currencyCode string, :micros string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:kind string, :confirmationCode string},
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
   :seatInfo {:gate LocalizedString,
              :seat LocalizedString,
              :section LocalizedString,
              :row LocalizedString,
              :kind string},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :ticketType {:translatedValues [TranslatedString],
                :kind string,
                :defaultValue TranslatedString},
   :state string,
   :classReference {:wordMark Image,
                    :eventName LocalizedString,
                    :reviewStatus string,
                    :rowLabel string,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :logo Image,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :customSeatLabel LocalizedString,
                    :customSectionLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :eventId string,
                    :locations [LatLongPoint],
                    :dateTime EventDateTime,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :sectionLabel string,
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :kind string,
                    :venue EventVenue,
                    :customRowLabel LocalizedString,
                    :finePrint LocalizedString,
                    :gateLabel string,
                    :seatLabel string,
                    :customConfirmationCodeLabel LocalizedString,
                    :confirmationCodeLabel string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :customGateLabel LocalizedString,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
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
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :ticketHolderName string}
  
  Inserts an event ticket object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject"
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

(defn modifylinkedofferobjects$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/modifylinkedofferobjects
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:linkedOfferObjectIds {:addLinkedOfferObjectIds [string],
                          :removeLinkedOfferObjectIds [string]}}
  
  Modifies linked offer objects for the event ticket object with the given ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}/modifyLinkedOfferObjects"
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
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the event ticket object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addmessage$
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/addmessage
  
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
  
  Adds a message to the event ticket object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}/addMessage"
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
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:faceValue {:kind string, :currencyCode string, :micros string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:kind string, :confirmationCode string},
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
   :seatInfo {:gate LocalizedString,
              :seat LocalizedString,
              :section LocalizedString,
              :row LocalizedString,
              :kind string},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :ticketType {:translatedValues [TranslatedString],
                :kind string,
                :defaultValue TranslatedString},
   :state string,
   :classReference {:wordMark Image,
                    :eventName LocalizedString,
                    :reviewStatus string,
                    :rowLabel string,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :logo Image,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :customSeatLabel LocalizedString,
                    :customSectionLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :eventId string,
                    :locations [LatLongPoint],
                    :dateTime EventDateTime,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :sectionLabel string,
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :kind string,
                    :venue EventVenue,
                    :customRowLabel LocalizedString,
                    :finePrint LocalizedString,
                    :gateLabel string,
                    :seatLabel string,
                    :customConfirmationCodeLabel LocalizedString,
                    :confirmationCodeLabel string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :customGateLabel LocalizedString,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:id string, :mainImage Image}],
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
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :ticketHolderName string}
  
  Updates the event ticket object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/eventticketobject/list
  
  Required parameters: none
  
  Optional parameters: token, maxResults, classId
  
  Returns a list of all event ticket objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
