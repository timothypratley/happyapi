(ns happygapi.walletobjects.loyaltyclass
  "Google Wallet API: loyaltyclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/wallet"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:translatedValues [TranslatedString],
                             :kind string,
                             :defaultValue TranslatedString},
   :wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedRewardsTier {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :wideProgramLogo {:kind string,
                     :sourceUri ImageUri,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :discoverableProgram {:state string,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo,
                         :merchantSignupInfo DiscoverableProgramMerchantSignupInfo},
   :localizedRewardsTierLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:translatedValues [TranslatedString],
                                   :kind string,
                                   :defaultValue TranslatedString},
   :imageModulesData [{:id string, :mainImage Image}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:translatedValues [TranslatedString],
                                        :kind string,
                                        :defaultValue TranslatedString},
   :localizedAccountNameLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :programName string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :localizedProgramName {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :accountIdLabel string,
   :countryCode string}
  
  Updates the loyalty class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:translatedValues [TranslatedString],
                             :kind string,
                             :defaultValue TranslatedString},
   :wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedRewardsTier {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :wideProgramLogo {:kind string,
                     :sourceUri ImageUri,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :discoverableProgram {:state string,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo,
                         :merchantSignupInfo DiscoverableProgramMerchantSignupInfo},
   :localizedRewardsTierLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:translatedValues [TranslatedString],
                                   :kind string,
                                   :defaultValue TranslatedString},
   :imageModulesData [{:id string, :mainImage Image}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:translatedValues [TranslatedString],
                                        :kind string,
                                        :defaultValue TranslatedString},
   :localizedAccountNameLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :programName string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :localizedProgramName {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :accountIdLabel string,
   :countryCode string}
  
  Inserts an loyalty class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass"
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

(defn list$
  "https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/list
  
  Required parameters: none
  
  Optional parameters: token, issuerId, maxResults
  
  Returns a list of all loyalty classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass"
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
  "https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:translatedValues [TranslatedString],
                             :kind string,
                             :defaultValue TranslatedString},
   :wordMark {:kind string,
              :sourceUri ImageUri,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedRewardsTier {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :wideProgramLogo {:kind string,
                     :sourceUri ImageUri,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedBody LocalizedString,
                      :body string,
                      :localizedHeader LocalizedString,
                      :header string,
                      :id string}],
   :issuerName string,
   :discoverableProgram {:state string,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo,
                         :merchantSignupInfo DiscoverableProgramMerchantSignupInfo},
   :localizedRewardsTierLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :id string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:translatedValues [TranslatedString],
                                   :kind string,
                                   :defaultValue TranslatedString},
   :imageModulesData [{:id string, :mainImage Image}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:translatedValues [TranslatedString],
                                        :kind string,
                                        :defaultValue TranslatedString},
   :localizedAccountNameLabel {:translatedValues [TranslatedString],
                               :kind string,
                               :defaultValue TranslatedString},
   :programName string,
   :classTemplateInfo {:cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :localizedProgramName {:translatedValues [TranslatedString],
                          :kind string,
                          :defaultValue TranslatedString},
   :heroImage {:kind string,
               :sourceUri ImageUri,
               :contentDescription LocalizedString},
   :accountIdLabel string,
   :countryCode string}
  
  Updates the loyalty class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}"
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
  "https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/addmessage
  
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
  
  Adds a message to the loyalty class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}/addMessage"
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
  "https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the loyalty class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
