(defproject <%=app_name%> "<%=version%>"
  :min-lein-version "2.0.0"
  :source-paths ["src/clj"]
  :dependencies
  [[org.clojure/clojure "1.8.0"]
   [compojure "1.5.1"]
   [ring/ring-defaults "0.2.1"]
   [ring/ring-json "0.4.0"]
   ;; clojurescript
   [org.clojure/clojurescript "1.10.238"]
   [cljs-ajax "0.7.3"]
   [prismatic/dommy "1.1.0"]
   [reagent "0.8.1"]]
  :plugins
  [[lein-ring "0.9.7"]
   [lein-figwheel "0.5.13"]
   [lein-cooper "1.2.2"]
   [lein-cljsbuild
    "1.1.5"
    :exclusions
    [[org.clojure/clojure]]]
   [lein-heroku "0.5.3"]]
  :cooper
  {"fig"  ["lein" "figwheel"]
   "ring" ["lein" "ring" "server"]}
  :ring {:handler <%= app_path %>.handler/app}
  :clean-targets [:target-path "out"]
  :cljsbuild
  {:builds [{:id           "dev"
             :source-paths ["src/cljs"]
             :figwheel     true
             :compiler     {:main       "<%=app_path%>.app"
                            :asset-path "js/out"
                            :output-to  "resources/public/js/main.js"
                            :output-dir "resources/public/js/out"}}
            {:id           "min"
             :source-paths ["src/cljs"]
             :compiler     {:main          "<%=app_path%>.app"
                            :output-to     "resources/public/js/main.js"
                            :optimizations :advanced
                            :pretty-print  false}}]}

  :figwheel {:css-dirs ["resources/public/css"]}

  :aliases
  {"package" ["do"
              "clean"
              ["cljsbuild" "once" "min"]
              ["ring" "uberjar"]]}

  :heroku
  {:app-name      "<%= app_name %>"
   :jdk-version   "1.8"
   :include-files ["target/<%= app_name %>-<%= version %>-standalone.jar"]
   :process-types {"web" "java -jar target/<%=app_name%>-<%=version%>-standalone.jar"}}

  :uberjar-name "<%=app_name%>-<%=version%>-standalone.jar"
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
