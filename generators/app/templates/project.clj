(defproject <%= app_name %> "0.1.0-SNAPSHOT"
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [org.clojure/clojurescript "1.10.238"]
                           [cljsjs/react "16.3.0-1"]
                           [cljsjs/react-dom "16.3.0-1"]
                           [sablono "0.7.4"]]
            :plugins [[lein-figwheel "0.5.13"]]
            :clean-targets [:target-path "out"]
            :cljsbuild {:builds [{:id "dev"
                                  :source-paths ["src"]
                                  :figwheel true
                                  :compiler {:main "<%= app_path %>.core"
                                             :asset-path "cljs/out"
                                             :output-to "resources/public/cljs/main.js"
                                             :output-dir "resources/public/cljs/out"}}]}
            :figwheel {:css-dirs ["resources/public/css"]})
