(ns om-basic-tutorial.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(println "This text is printed from src/om-basic-tutorial/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Frimmel was found stoned in the Red Light District"}))

(om/root
  (fn [data owner]
    (reify om/IRender
      (render [_]
        (dom/div nil
                 (dom/h2 nil (:text data))
                 (dom/h3 nil "His wife, Bemb, was shocked and horrified")))))
  app-state
  {:target (. js/document (getElementById "app"))})

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
