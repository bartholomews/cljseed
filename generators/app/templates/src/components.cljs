(ns <%= app_path %>.components
  (:require [sablono.core :as sab]))

(defn counter-example [data]
  (sab/html [:div
             [:h1 "A counter example: count" (:likes @data)]
             [:div [:a {:href "#"
                        :onClick #(swap! data update-in [:likes] inc)}
                    "Click me!"]]]))
