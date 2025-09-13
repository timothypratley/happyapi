(ns build
  (:require [clojure.tools.build.api :as b]
            [clojure.tools.build.tasks.write-pom :as wp]
            [deps-deploy.deps-deploy :as dd]))

(def lib 'io.github.timothypratley/happyapi)
(def version (format "1.0.%s" (b/git-count-revs nil)))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"
                            :aliases [:provided]}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn tag [_]
  (b/git-process {:git-args ["tag" "-a" (str "v" version)
                             "-m" (str "Release version v" version)]})
  (b/git-process {:git-args ["push" "origin" (str "v" version)]}))

(defn write-pom [x]
  (let [to-dep-orig @#'wp/to-dep]
    (with-redefs [wp/to-dep
                  (fn [[_lib {:keys [scope]} :as entry]]
                    (cond-> (to-dep-orig entry)
                            scope (conj [:xmlns.http%3A%2F%2Fmaven.apache.org%2FPOM%2F4.0.0/scope scope])))]
      (b/write-pom x))))

(defn jar [_]
  ;; I think this extends the pom.xml in root,
  ;; which I manually added the license to, and SCM details.
  ;; License is required by Clojars.
  ;; SCM is required by cljdocs
  (write-pom {:class-dir class-dir
              :lib       lib
              :version   version
              :basis     basis
              :src-dirs  ["src"]
              :scm       {:url                 "https://github.com/timothypratley/happyapi"
                          :connection          "scm:git:git://github.com/timothypratley/happyapi.git"
                          :developerConnection "scm:git:ssh://git@github.com/timothypratley/happyapi.git"
                          :tag                 (str "v" version)}
              :pom-data  [[:description "Middleware oriented oauth2 client for webservices"]
                          [:licenses
                           [:license
                            [:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"]
                            [:url "https://www.eclipse.org/legal/epl-2.0/"]]]]})
  (b/copy-dir {:src-dirs   ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file  jar-file})
  (println "Made" jar-file))

(defn deploy [_]
  (tag nil)
  (dd/deploy {:installer :remote
              :artifact  jar-file
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))

(defn install [_]
  (dd/deploy {:installer :local
              :artifact  jar-file
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))
