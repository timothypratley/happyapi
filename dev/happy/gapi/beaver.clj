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
  [{:keys [id]}]
  {:pre [(string? id)]}
  (->> (str/split id #"\.")
       (drop 1)
       (str/join \-)
       (symbol)))

(defn summarize-schema
  "Given a json-schema of type definitions,
  and a request that is a $ref to one of those types,
  resolves $ref(s) to a depth of 5,
  discards the distracting information,
  and returns a pattern for constructing the required input."
  ([request schema] (summarize-schema request schema 1))
  ([request schema depth]
   (m/rewrite request
              {:$ref (m/pred string? ?ref)}
              ;;>
              ~(or (and (<= depth 5)
                        (some-> (get schema (keyword ?ref))
                                (summarize-schema schema (inc depth))))
                   (symbol ?ref))

              {:enum [!enums ...]}
              ;;>
              [(m/app symbol !enums) ...]

              {:type  "array"
               :items ?item}
              ;;>
              [~(summarize-schema ?item schema depth)]

              {:type                 "object"
               :properties           (m/pred seq (m/seqable [!property !item] ...))}
              ;;>
              {& ([!property (m/app #(summarize-schema % schema depth) !item)] ...)}

              {:type "object"}
              ;;>
              any

              {:type (m/pred string? ?type)}
              ;;>
              (m/app symbol ?type))))

(defn doc-string [{:as ?api :keys [schemas]} {:as ?method :keys [description request]} ?request-sym !optional-parameters]
  (str description \newline \newline
       (str "Docs: " (raven/doc-link ?api ?method))
       (when (seq !optional-parameters)
         (str \newline \newline
              "Optional parameters: " \newline
              "  " (str/join ", " !optional-parameters)))
       (when request
         (str \newline \newline
              ?request-sym ":" \newline
              (if-let [s (summarize-schema request schemas)]
                (str/trim-newline (with-out-str (pprint/pprint s)))
                "any")))))

(def request-sym
  (s/rewrite (m/or (m/pred nil? ?sym)
                   {:$ref (m/some (m/app symbol ?sym))}
                   {:type (m/some (m/app symbol ?sym))})
             ?sym))

(defn single-arity [{:as ?api :keys [baseUrl]} {:as ?method :keys [path httpMethod scopes request]} !required-parameters]
  (let [?method-sym (method-sym ?method)
        ?request-sym (request-sym request)
        params (cond-> !required-parameters
                       request (conj ?request-sym))]
    (list 'defn ?method-sym
          (doc-string ?api ?method ?request-sym nil)
          params
          (list 'client/api-request
                (cond-> {:method            httpMethod
                         :uri-template      (str baseUrl path)
                         :uri-template-args (zipmap (map keyword !required-parameters) !required-parameters)
                         :scopes            scopes}
                        request (conj [:body ?request-sym]))))))


(defn multi-arity [{:as ?api :keys [baseUrl]} {:as ?method :keys [path httpMethod scopes request]} !required-parameters !optional-parameters]
  (let [?method-sym (method-sym ?method)
        ?request-sym (request-sym request)
        params (cond-> !required-parameters
                       request (conj ?request-sym))]
    (list 'defn ?method-sym
          (doc-string ?api ?method ?request-sym !optional-parameters)
          (list params (list* ?method-sym (conj params nil)))
          (list (conj params 'optional)
                (list 'client/api-request
                      (cond-> {:method            httpMethod
                               :uri-template      (str baseUrl path)
                               :uri-template-args (zipmap (map keyword !required-parameters) !required-parameters)
                               :scopes            scopes
                               :query-params      'optional}
                              request (conj [:body ?request-sym])))))))

(def extract-method
  "Given an api definition, and an api method definition,
  produces a defn form."
  (s/rewrite
    [{:baseUrl ?base-url
      :schemas ?schemas
      :as      ?api}
     {:path        ?path
      :parameters  (m/seqable (m/or [(m/app symbol !required-parameters) {:required true}]
                                    [(m/app symbol !optional-parameters) {}]) ...)
      :description ?description
      :scopes      ?scopes
      :httpMethod  ?httpMethod
      :request     ?request
      :as          ?method}]
    ;;>
    ~(if (seq !optional-parameters)
       (multi-arity ?api ?method !required-parameters !optional-parameters)
       (single-arity ?api ?method !required-parameters))

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
