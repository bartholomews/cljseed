(ns ^:figwheel-hooks <%= app_path %>.client.app
  (:require
    [goog.dom :as gdom]
    [<%= app_path %>.client.counter :as counter]
    [<%= app_path %>.client.service :as ajax]
    [reagent.core :as reagent :refer [atom]]))

(println "This text is printed from src/hello_world/core.cljs. Go ahead and edit it and see reloading in action.")

(defn multiply [a b] (* a b))

(.log js/console "App started.")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn render [element]
      (reagent/render-component [counter/title] element))

(def user "JADSSADASDOAKSM")
(ajax/say-hello user)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
      (gdom/getElement "app"))

(defn hello-world []
      [:div
       [:h1 (:text @app-state)]
       [:h3 "Edit this in src/hello_world/core.cljs and watch it change!"]])

(defn mount [el]
      (reagent/render-component [hello-world] el))

(defn mount-app-element []
      (when-let [el (get-app-element)]
                ;(mount el)
                (render el)
                ))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
      (mount-app-element)
      ;; optionally touch your app-state to force rerendering depending on
      ;; your application
      ;; (swap! app-state update-in [:__figwheel_counter] inc)
      )