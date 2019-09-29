(ns <%= app_path %>.server.api
    (:require [compojure.core :refer :all]
      [compojure.route :as route]
      [ring.middleware.json :as middleware]
      [ring.middleware.keyword-params :refer [wrap-keyword-params]]
      [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
      [ring.util.response :as response]))

(defroutes app-routes
           (GET "/" [] (response/resource-response "index.html" {:root "public"}))
           (route/resources "/")
           (POST "/hello" request
                 (response/response {:greeting
                                     (get-in request [:params :user])}))
           (route/not-found "Not Found"))

(def handler
  (-> app-routes
      wrap-keyword-params
      middleware/wrap-json-params
      middleware/wrap-json-response))
