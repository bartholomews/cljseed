(defproject <%=app_name%> "<%=version%>"

            ;; TODO
            :description "FIXME: write this!"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}

            :min-lein-version "2.7.1"

            :dependencies [[org.clojure/clojure "1.10.1"]
                           [compojure "1.6.1"]              ; https://github.com/weavejester/compojure
                           [ring/ring-defaults "0.3.2"]     ; https://github.com/ring-clojure/ring-defaults
                           [ring/ring-json "0.5.0"]         ; https://github.com/ring-clojure/ring-json
                           ;; clojurescript
                           [org.clojure/clojurescript "1.10.520"] ; https://github.com/clojure/clojurescript
                           [cljs-ajax "0.8.0"]              ; https://clojars.org/cljs-ajax
                           [prismatic/dommy "1.1.0"]        ; https://clojars.org/prismatic/dommy
                           [reagent "0.8.1"]]               ; https://clojars.org/reagent

            :plugins [[lein-ring "0.12.5"]                  ; https://clojars.org/lein-ring
                      [lein-heroku "0.5.3"]]                ; https://clojars.org/lein-heroku

            :ring {:handler <%= app_path %>.server.api/handler}

            :clean-targets [:target-path "out"]

            :aliases {"fig"      ["trampoline" "run" "-m" "figwheel.main"]
                      "fig:dev"  ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
                      "fig:min"  ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
                      "fig:test" ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" <%= app_path %>.test-runner]
                      "package"  ["do"
                                  "clean"
                                  ["fig:min"]
                                  ["ring" "uberjar"]]

                      }

            :heroku
            {:app-name      "<%= app_name %>"
             :jdk-version   "1.8"
             :include-files ["target/<%= app_name %>-<%= version %>-standalone.jar"]
             :process-types {"web" "java -jar target/<%=app_name%>-<%=version%>-standalone.jar"}}

            :uberjar-name "<%=app_name%>-<%=version%>-standalone.jar"

            :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.1.9"]
                                            [com.bhauman/rebel-readline-cljs "0.1.4"]]
                             }})
