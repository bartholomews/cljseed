(defproject <%= app_name %> "0.1.0-SNAPSHOT"
            :min-lein-version "2.0.0"
            :source-paths ["src/clj"]
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [compojure "1.5.1"]
                           [ring/ring-defaults "0.2.1"]
                           [ring/ring-json "0.4.0"]
                           ;; ClojureScript
                           [org.clojure/clojurescript "1.10.238"]
                           [cljs-ajax "0.7.3"]
                           [prismatic/dommy "1.1.0"]
                           [reagent "0.8.1"]]
            :plugins [[lein-ring "0.9.7"]
                      [lein-figwheel "0.5.13"]
                      [lein-cooper "1.2.2"]]
            :cooper {"fig" ["lein" "figwheel"]
                     "ring"  ["lein" "ring" "server"]}
            :ring {:handler <%= app_path %>.handler/app}
            :clean-targets [:target-path "out"]
            :cljsbuild {:builds [{:id "<%= app_name %>"
                                  :source-paths ["src/cljs"]
                                  :figwheel true
                                  :compiler {:main "<%= app_path %>.app"
                                             :asset-path "js/out"
                                             :output-to "resources/public/js/main.js"
                                             :output-dir "resources/public/js/out"}}]}
            :figwheel {:css-dirs ["resources/public/css"]}
            :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                            [ring/ring-mock "0.3.0"]]}})
