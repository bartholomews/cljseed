(ns <%= app_path %>.counter
  (:require
   [reagent.core :as r]))

(defonce click-count (r/atom 0))

(defn title []
  [:div
   [:h3 "I am a component"]
   [:p @click-count]
   [:button {:on-click #(swap! click-count inc)}
   "I have been clicked " @click-count " times."]   ])

(defn state-ful-with-atom []
  [:div {:on-click #(swap! click-count inc)}
   "I have been clicked " @click-count " times."])
