(ns curses-om.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [figwheel.client :as fw :include-macros true]))

(enable-console-print!)

(fw/watch-and-reload
 :websocket-url   "ws://localhost:3449/figwheel-ws"
 :jsload-callback 'mount-root)

(defonce app-state (atom {:message "Clojurescript electrons +om"}))
(defonce next-state (atom {:message "Blahblahblah blah"}))
(defonce last-state (atom {:message "blah..."}))

(defn mount-root []
  (om/root
   (fn [state owner]
     (reify om/IRender
       (render [_]
         (dom/h2 nil (:message state)))))
   app-state
   {:target (. js/document
               (getElementById "app"))}))

(defn mount-next []
  (om/root
    (fn [state owner]
      (reify om/IRender
        (render [_]
          (dom/h3 nil (:message state)))))
    next-state
    {:target (. js/document
                (getElementById "next"))}))

(defn mount-last []
  (om/root
    (fn [state owner]
      (reify om/IRender
        (render [_]
          (dom/h4 nil (:message state)))))
    last-state
    {:target (. js/document
                (getElementById "last"))}))

(defn init! []
  (mount-root)
  (mount-next)
  (mount-last))

(init!)
