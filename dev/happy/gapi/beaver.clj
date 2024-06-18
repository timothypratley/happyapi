(ns happy.gapi.beaver
  "Builds code forms for calling the remote APIs."
  (:require [clojure.java.io :as io]
            [clojure.pprint :as pprint]
            [happy.gapi.raven :as raven]
            [clojure.string :as str]
            [meander.strategy.epsilon :as s]
            [meander.epsilon :as m]))

(def project-name "happygapi")
(def out-dir (io/file ".." project-name "src" project-name))

(defn method-sym
  "Fully qualified by hyphenation for convenience"
  [id]
  {:pre [(string? id)]}
  (->> (str/split id #"\.")
       (drop 1)
       (str/join \-)
       (symbol)))

(defn summarize-schema [schema request depth]
  "Given a json-schema of type definitions,
  and a request that is a $ref to one of those types,
  resolves $ref(s) to a depth of 5,
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
             ~(if (> depth 5)
                (symbol ?ref)
                (summarize-schema schema (get schema (keyword ?ref)) (inc depth)))))

(defn doc-string [?api ?method ?description ?request ?schemas !optional-parameters]
  (str ?description \newline \newline
       (str "Docs: " (raven/doc-link ?api ?method))
       (when (seq !optional-parameters)
         (str \newline \newline
              "Optional parameters: " \newline
              "  " (str/join ", " !optional-parameters)))
       (when ?request
         (str \newline \newline
              ?request ":" \newline
              (str/trim-newline (with-out-str (pprint/pprint (summarize-schema ?schemas (get ?schemas (keyword ?request)) 1))))))))

(defn single-arity [?api ?method ?description ?request ?schemas ?scopes !required-parameters ?method-sym ?httpMethod ?base-url ?path]
  (list 'defn ?method-sym
        (doc-string ?api ?method ?description ?request ?schemas nil)
        (cond-> !required-parameters
                ?request (conj ?request))
        (list 'client/request
              (cond-> {:method            (str/lower-case ?httpMethod)
                       :uri-template      (str ?base-url ?path)
                       :uri-template-args (zipmap (map keyword !required-parameters) !required-parameters)
                       :scopes            ?scopes}
                      ?request (conj [:body ?request])))))

(defn multi-arity [?api ?method ?description ?request ?schemas !optional-parameters ?scopes !required-parameters ?method-sym ?httpMethod ?base-url ?path]
  (let [params (cond-> !required-parameters
                       ?request (conj ?request))]
    (list 'defn ?method-sym
          (doc-string ?api ?method ?description ?request ?schemas !optional-parameters)
          (list params (list* ?method-sym (conj params nil)))
          (list (conj params 'optional)
                (list 'client/request
                      (cond-> {:method            (str/lower-case ?httpMethod)
                               :uri-template      (str ?base-url ?path)
                               :uri-template-args (zipmap (map keyword !required-parameters) !required-parameters)
                               :scopes            ?scopes
                               :query-params      'optional}
                              ?request (conj [:body ?request])))))))

(def extract-method
  "Given an api definition, and an api method definition,
  produces a defn form."
  (s/rewrite
    [{:baseUrl ?base-url
      :schemas ?schemas
      :as      ?api}
     {:id          (m/and ?id
                          (m/app method-sym ?method-sym))
      :path        ?path
      :parameters  (m/seqable (m/or [(m/app symbol !required-parameters) {:required true}]
                                    [(m/app symbol !optional-parameters) {}]) ...)
      :description ?description
      :scopes      ?scopes
      :httpMethod  ?httpMethod
      ;; TODO: this might screw up the order of arguments
      :request     (m/or {:$ref (m/app symbol ?request)} ?request)
      :as          ?method}]
    ;;>
    ~(if (seq !optional-parameters)
       (multi-arity ?api ?method ?description ?request ?schemas !optional-parameters ?scopes !required-parameters ?method-sym ?httpMethod ?base-url ?path)
       (single-arity ?api ?method ?description ?request ?schemas ?scopes !required-parameters ?method-sym ?httpMethod ?base-url ?path))

    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def build-api-ns
  (s/rewrite
    (m/with [%resource {:methods   (m/seqable [_ !methods] ...)
                        :resources (m/seqable [_ %resource] ...)}]
            {:name              ?name
             :title             ?title
             :description       ?description
             :documentationLink ?documentationLink
             :resources         {& (m/seqable [_ %resource] ...)}
             :as                ?api})
    ((ns ~(symbol (str project-name \. ?name))
       ~(str ?title \newline
             ?description \newline
             "See: " (raven/maybe-redirected ?documentationLink))
       (:require [happy.oauth2.client ~:as client])) .
     (m/app extract-method [?api !methods]) ...)
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))
