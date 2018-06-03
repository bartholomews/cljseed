(ns <%= app_path %>.app
    (:require
     [clojure.string :as string]
     [reagent.core :as r]
     [<%= app_path %>.service :as ajax]
     [<%= app_path %>.counter :as counter]))

(.log js/console "App started.")

(defn render [element]
  (r/render-component [counter/title]  element))

(def user "John")
(ajax/say-hello user)

(render
 (js/document.getElementById "app"))
