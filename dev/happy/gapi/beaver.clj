(ns happy.gapi.beaver
  "Builds code forms for calling the remote APIs."
  (:require [clojure.java.io :as io]
            [clojure.pprint :as pprint]
            [happy.gapi.raven :as raven]
            [clojure.string :as str]
            [meander.strategy.epsilon :as s]
            [meander.epsilon :as m]))

(def project-name "happygapi2")
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

              {:type       "object"
               :properties (m/pred seq (m/seqable [!property !item] ...))}
              ;;>
              {& ([!property (m/app #(summarize-schema % schema depth) !item)] ...)}

              {:type (m/pred string? ?type)}
              ;;>
              (m/app symbol ?type))))

(defn doc-string [{:as ?api :keys [schemas]} {:as ?method :keys [description request parameters parameterOrder]} ?request-sym]
  (str description \newline
       (raven/doc-link ?api ?method)

       (when (or request (seq parameterOrder))
         (str \newline
              (when (seq parameterOrder)
                (str \newline
                     (str/join \newline
                               (for [p parameterOrder]
                                 (let [{:keys [type description]} (get parameters (keyword p))]
                                   (str p " <" type "> " description))))))
              (when request
                (str \newline
                     ?request-sym
                     (if-let [s (summarize-schema request schemas)]
                       (str ":" \newline (str/trim-newline (with-out-str (pprint/pprint s))))
                       " <unspecified>")))))

       (when-let [opts (seq (for [[p {:keys [required type description]}] parameters
                                  ;; pageToken is handled by the wrap-paging middleware
                                  :when (and (not required) (not= p :pageToken))]
                              (str (name p) " <" type "> " description)))]
         (str \newline \newline
              "optional:" \newline
              (str/join \newline opts)))))

(def request-sym
  (s/rewrite (m/or (m/pred nil? ?sym)
                   {:$ref (m/some (m/app symbol ?sym))}
                   {:type (m/some (m/app symbol ?sym))})
             ?sym))

;; TODO: location "query", location "path"
;; TODO: parameterOrder seems useful!!!

(defn required-path-params [parameters]
  (into {} (for [[k {:keys [required location]}] parameters
                 :when (and required (= location "path"))]
             [k (symbol k)])))

(defn required-query-params [parameters]
  (into {} (for [[k {:keys [required location]}] parameters
                 :when (and required (= location "query"))]
             [k (symbol k)])))

(defn single-arity [{:as ?api :keys [baseUrl]} {:as ?method :keys [path httpMethod scopes request parameters parameterOrder]}]
  (let [?method-sym (method-sym ?method)
        ?request-sym (request-sym request)
        params (cond-> (mapv symbol parameterOrder)
                       request (conj ?request-sym))]
    (list 'defn ?method-sym
          (doc-string ?api ?method ?request-sym)
          params
          (list 'client/api-request
                (cond-> {:method            httpMethod
                         :uri-template      (str baseUrl path)
                         :uri-template-args (required-path-params parameters)
                         :query-params      (required-query-params parameters)
                         :scopes            scopes}
                        request (conj [:body ?request-sym]))))))


(defn multi-arity [{:as ?api :keys [baseUrl]} {:as ?method :keys [path httpMethod scopes request parameters parameterOrder]}]
  (let [?method-sym (method-sym ?method)
        ?request-sym (request-sym request)
        params (cond-> (mapv symbol parameterOrder)
                       request (conj ?request-sym))]
    (list 'defn ?method-sym
          (doc-string ?api ?method ?request-sym)
          (list params (list* ?method-sym (conj params nil)))
          (list (conj params 'optional)
                (list 'client/api-request
                      (cond-> {:method            httpMethod
                               :uri-template      (str baseUrl path)
                               :uri-template-args (required-path-params parameters)
                               :query-params      (list 'merge (required-query-params parameters) 'optional)
                               :scopes            scopes}
                              request (conj [:body ?request-sym])))))))

(def extract-method
  "Given an api definition, and an api method definition,
  produces a defn form."
  (s/rewrite
    [{:as ?api}
     {:parameters (m/seqable (m/or [(m/app symbol !required-parameters) {:required true}]
                                   [(m/app symbol !optional-parameters) {}]) ...)
      :as         ?method}]
    ;;>
    ~(if (seq !optional-parameters)
       (multi-arity ?api ?method)
       (single-arity ?api ?method))

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
       (:require [happy.oauth2.client ~:as client]))
     ;; TODO: this might make exploring APIs nicer, but takes up too much space
     #_(def api ?api)
     . (m/app extract-method [?api !methods]) ...)
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))
