(ns happyapinotebook.ocr
  (:require [clojure.test :refer [deftest is]]
            [happyapi.oauth2.credentials :as credentials]
            [happygapi.vision :as vision]
    ;; TODO:
            [happygapi.documentai :as dai]))

(deftest t
  (credentials/init!)
  (vision/images-annotate {:requests [{:image        {:source {:imageUri "https://i0.wp.com/static.flickr.com/102/308775600_4ca34de425_o.jpg"}},
                                       :features     [{:type "DOCUMENT_TEXT_DETECTION"}],
                                       :imageContext {:languageHints ["Tamil"]}}]}))
