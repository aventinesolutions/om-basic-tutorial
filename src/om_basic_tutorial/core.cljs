(ns om-basic-tutorial.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(println "This text is printed from src/om-basic-tutorial/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:list ["Lion" "Zebra" "Buffalo" "Antelope"]}))

(om/root
 (fn [data owner]
   (om/component
    (apply dom/ul #js {:className "menagerie"}
           (map (fn [text] (dom/li #js {:className "animals"} text)) (:list data)))))
 app-state
 {:target (. js/document (getElementById "appUm"))})

(om/root
 (fn [data owner]
   (om/component (dom/h2 nil (:test data))))
 app-state
 {:target (. js/document (getElementById "appDois"))})

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
