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
                :src-dirs  ["src"]})
  ;; To be used as a git dependency, a pom.xml must be present in root
  (b/copy-file {:src "target/classes/META-INF/maven/io.github.timothypratley/happyapi/pom.xml"
                :target "pom.xml"})
  ;; Hahaha now your git is no longer clean because the pom.xml updated with the latest tag
  ;; You'll need to revert the tag change when you deploy
  (b/copy-dir {:src-dirs   ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file  jar-file}))

(defn deploy [_]
  (dd/deploy {:installer :remote
              :artifact  jar-file
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))

(defn install [_]
  (dd/deploy {:installer :local
              :artifact  jar-file
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))
