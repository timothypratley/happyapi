(ns happy.gapi.beaver
  "Builds code forms for calling the remote APIs."
  (:require [clojure.java.io :as io]
            [happy.gapi.raven :as raven]
            [clojure.string :as str]
            [fipp.clojure :as pprint]
            [meander.strategy.epsilon :as s]
            [meander.epsilon :as m]))

(def project-name "happygapi")
(def out-dir (io/file ".." project-name "src" project-name))

(defn method
  "Fully qualified by hyphenation for convenience"
  [id]
  (symbol (str/join \- (drop 1 (str/split id #"\.")))))

(defn summarize-schema [schema request depth]
  "Given a json-schema of type definitions,
  and a request that is a $ref to one of those types,
  resolves $ref(s) to a depth of 3,
  discards the distracting information,
  and returns a pattern for constructing the required input."
  (m/rewrite request
             {:type                 "object"
              :additionalProperties ?ap
              :properties           (m/seqable [!property !item] ...)}
             ;;>
             {& ([!property (m/app #(summarize-schema schema % depth) !item)] ...)}

             {:type  "array"
              :items ?item}
             ;;>
             [~(summarize-schema schema ?item depth)]

             {:type (m/pred string? ?type)}
             ;;>
             (m/app symbol ?type)

             {:$ref (m/pred string? ?ref)}
             ;;>
             ~(if (> depth 2)
                (symbol ?ref)
                (summarize-schema schema (get schema (keyword ?ref)) (inc depth)))))

(def extract-method
  "Given an api definition, and an api method definition,
  produces a defn form."
  (s/rewrite
    [{:baseUrl ?base-url
      :schemas ?schemas
      :as      ?api}
     {:id          (m/and ?id
                          (m/app method ?method))
      :path        ?path
      :parameters  (m/seqable (m/or [(m/app symbol !required-parameters) {:required true}]
                                    [(m/app symbol !optional-parameters) {}]) ...)
      :description ?description
      :scopes      ?scopes
      :httpMethod  ?httpMethod
      ;; TODO: this might screw up the order of arguments
      :request     (m/and ?request !required-parameters)
      :as          ?method}]
    ;;>
    (defn ?method
      ~(str (raven/doc-link ?api ?method)
            (when (seq !optional-parameters)
              (str \newline \newline
                   "Optional parameters: " \newline
                   ;; TODO: handle indentation properly
                   "  " (str/join ", " !optional-parameters)))
            (when ?request
              (str \newline \newline
                   "Body: " \newline
                   "  " (with-out-str (pprint/pprint (summarize-schema ?schemas ?request 1)))
                   \newline))
            ?description)
      {:scopes ?scopes}
      ;; TODO: could elide when no optional params exist
      ;; TODO: when request is present, body is a required arg? look for an example
      (([!required-parameters ...] (?method . !required-parameters ... nil))
       ([!required-parameters ... optional]
        (client/request
          {:method            (str/lower-case ?httpMethod)
           :uri-template      (str ?base-url ?path)
           :uri-template-args {& [(m/app keyword !required-parameters) !required-parameters]}
           :query-params      optional
           :body              ?request}))))
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def extract-resource-methods
  "Given an api definition and a resource,
  discovers all the methods,
  and methods of sub-resources."
  (s/rewrite
    [?api (m/with [%resource {:methods   (m/seqable [_ !methods] ...)
                              :resources (m/seqable [_ %resource] ...)}]
                  %resource)]
    ;;>
    ((m/app extract-method [?api !methods]) ...)
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def build-api-ns
  (s/rewrite
    {:name              ?name
     :title             ?title
     :description       ?description
     :documentationLink ?documentationLink
     :resources         {& (m/seqable [!resource-names !resources] ...)}
     :as                ?api}
    ((ns ~(symbol (str project-name \. ?name))
       ~(str ?title \newline
             ?description \newline
             "See: " (raven/maybe-redirected ?documentationLink))
       (:require
         [happy.oauth2.client ~:as client]
         ;; TODO: nope
         [happy.util ~:as util])) .
     (m/app extract-resource-methods [?api !resources]) ...)))
