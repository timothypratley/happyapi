(ns build
  (:require [clojure.tools.build.api :as b]
            [deps-deploy.deps-deploy :as dd]))

(def lib 'io.github.timothypratley/happyapi)
(def version (format "1.0.%s" (b/git-count-revs nil)))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn tag [_]
  (b/git-process {:git-args ["tag" "-a" (str "v" version)
                             "-m" (str "Release version v" version)]})
  (b/git-process {:git-args ["push" "origin" (str "v" version)]}))

(defn jar [_]
  ;; I think this extends the pom.xml in root,
  ;; which I manually added the license to, and SCM details.
  ;; License is required by Clojars.
  ;; SCM is required by cljdocs
  (b/write-pom {:class-dir class-dir
                :lib       lib
                :version   version
                :basis     basis
                :src-dirs  ["src"]
                :scm {:url "https://github.com/timothypratley/happyapi"
                      :connection "scm:git:git://github.com/timothypratley/happyapi.git"
                      :developerConnection "scm:git:ssh://git@github.com/timothypratley/happyapi.git"
                      :tag (str "v" version)}
                :pom-data  [[:description "Middleware oriented oauth2 client for webservices"]
                            [:licenses
                             [:license
                              [:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"]
                              [:url "https://www.eclipse.org/legal/epl-2.0/"]]]
                            (into [:dependencies
                                   (for [[g a v] '[[clj-http clj-http "3.13.0"]
                                                   [http-kit http-kit "2.8.0"]
                                                   [cheshire cheshire "5.13.0"]
                                                   [org.clojure data.json "2.5.0"]
                                                   [metosin jsonista "0.3.9"]]]
                                     [:dependency
                                      [:groupId g]
                                      [:artifactId a]
                                      [:version v]
                                      [:scope "provided"]])])]})
  (b/copy-dir {:src-dirs   ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file  jar-file}))

(defn deploy [_]
  (tag nil)
  (dd/deploy {:installer :remote
              :artifact  jar-file
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))

(defn install [_]
  (dd/deploy {:installer :local
              :artifact  jar-file
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))
