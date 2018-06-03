(ns <%= app_path %>.service
  (:require [ajax.core :refer [GET POST]]
            [dommy.core :as dommy]
            ;; :refer-macros [sel sell]]
            ))

(defn handler [response]
  (.log js/console "Server response:")
  (.log js/console response)
  )
  ; (-> (sell :.fromServer)
  ;     (dommy/set-text!
  ;      (str "Hello " (aget (clj->js response) "greeting")))))

(defn error-handler [{:keys [status status-text]}]
  (.log js.console (str "An error occurred: " status " " status-text)))

(defn say-hello [user]
  (POST "/hello"
        {:params {:user user}
         :handler handler
         :error-handler error-handler
         :format :json
         :response-format :json}))
