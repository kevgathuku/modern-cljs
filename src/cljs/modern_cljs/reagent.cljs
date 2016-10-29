(ns modern-cljs.reagent
  (:require [reagent.core :as r]
            [domina.core :refer [by-id]]))

(def data [{:id 1
            :author "Pete Hunt"
            :text "This is one comment"}
           {:id 2
            :author "Jordan Walke"
            :text "This is *another* comment"}])

(defn comment-component [author comment]
  [:div.comment
   [:h2.commentAuthor author]
   [:span {:dangerouslySetInnerHTML #js {:__html (.render (js/Remarkable.) comment)}}]])

(defn comment-list [comments]
  [:div.commentList
   (for [{:keys [id author text]} comments]
     ^{:key id} [comment-component author text])])

(defn comment-box [comments]
  [:div.commentBox
   [:h1 "Comments"]
   [comment-list comments]])

(r/render [comment-box data] (by-id "content"))
