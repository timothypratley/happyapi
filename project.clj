(defproject happyapi "0.1.0-SNAPSHOT"
  :description "Middleware oriented oauth2 client for webservices"
  :url "http://github.com/timothypratley/happyapi"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :main happy.gapi.lion
  :dependencies [[org.clojure/clojure "1.11.3"]
                 [buddy/buddy-sign "3.5.351"]
                 [com.grzm/uri-template "0.7.1"]]
  :deploy-repositories {"releases" {:url "https://repo.clojars.org"}}
  :profiles {:dev     {:source-paths ["dev"]
                       :dependencies [[meander/epsilon "0.0.650"]
                                      [ring "1.12.1"]
                                      [org.scicloj/kind-portal "1-beta1"]
                                      [djblue/portal "0.56.0"]
                                      [org.slf4j/slf4j-nop "2.0.13"]
                                      ;; For testing
                                      [clj-http "3.13.0"]
                                      [cheshire "5.13.0"]
                                      [org.clojure/data.json "2.5.0"]
                                      [http-kit "2.8.0"]]}
             :uberjar {:aot :all}})
