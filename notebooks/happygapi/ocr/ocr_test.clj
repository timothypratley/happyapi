(ns happygapi.ocr.ocr-test
  (:require [clojure.test :refer :all]
            [happy.oauth2.credentials :as credentials]
            [happygapi.vision.images :as gimg]
            [happygapi.documentai.projects :as dap]
            [happygapi.documentai.operations :as dao]
            [happygapi.documentai.uiv1beta3 :as dai]))

(dap/locations-processors-create$)
(dap/locations-processors-process$)
(dai/projects-locations-get$)
(dao/delete$)

(deftest t
  (credentials/init!)
  (gimg/annotate$ (credentials/auth!)
                  {}
                  {:requests [{:image        {
                                              ;;:content ...
                                              :source {:imageUri "https://i0.wp.com/static.flickr.com/102/308775600_4ca34de425_o.jpg"}},
                               :features     [{:type "DOCUMENT_TEXT_DETECTION"}],
                               :imageContext {:languageHints ["Tamil"]}}]}))
