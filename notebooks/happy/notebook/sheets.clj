(ns happy.notebook.sheets
  (:require [clojure.test :refer [deftest is testing]]
            [happyapi.google.sheets-v4 :as sheets]))

(def spreadsheet-id "1NbGRyCRMoOT_MLhnubC5900JNwiQq_uqvdKwbqZOfyM")

#_
(deftest get$-test
  (credentials/init!)
  (testing "When fetching a spreadsheet"
    (let [spreadsheet (sheets/get$ (credentials/auth!)
                                   {:spreadsheetId spreadsheet-id})]
      (is (map? spreadsheet) "should receive spreadsheet info")
      (is (seq spreadsheet) "should contain properties")))

  (testing "When missing a required key"
    (is (thrown? AssertionError (sheets/get$ (credentials/auth!) {:badKey "123"}))
        "should get an exception")))
#_
(deftest values-batchUpdate$-test
  (credentials/init!)
  (testing "When updating values in a sheet"
    (let [response (sheets/values-batchUpdate$ (credentials/auth!)
                                               {:spreadsheetId spreadsheet-id}
                                               {:valueInputOption "USER_ENTERED"
                                                 :data             [{:range  "Sheet1"
                                                                     :values [[1 2 3]
                                                                              [4 5 6]]}]})]
      (is (map? response) "should receive a summary")
      (is (seq response) "containing data"))))
