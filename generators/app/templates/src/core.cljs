(ns <%= app_path %>.core
    (:require
     [clojure.string :as string]
     [sablono.core :as sab]
     [<%= app_path %>.components :refer [counter-example]]))

(.log js/console "App started.")

(defonce app-state (atom {:likes 0}))

(defn render! []
  (.render js/ReactDOM
           (counter-example app-state)
           (.getElementById js/document "app")))

(add-watch app-state :on-change (fn [_ _ _ _] (render!)))

(render!)
