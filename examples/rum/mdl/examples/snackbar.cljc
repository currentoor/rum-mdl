(ns rum.mdl.examples.snackbar
  (:require
   [rum.core :as rum]
   [rum.mdl  :as mdl]
   [rum.mdl.demo :as demo]))

(let [color (volatile! "")]
  (defn on-click-fn [this]
    #?(:cljs
       (fn [_]
         (->> (-> (js/Math.random)
                (* 0xFFFFFF)
                (js/Math.floor)
                (.toString 16))
           (str "#")
           (vreset! color))
         (rum/request-render this)
         (let [show-snackbar (aget this "refs" "snackbar" "show-snackbar")]
           (show-snackbar
            #js {:message "Button color changed."
                 :timeout 1200
                 :actionHandler (fn [_]
                                  (vreset! color "")
                                  (.forceUpdate this))
                 :actionText "Undo"})))))
  
  (rum/defcc example-snackbar [this]
    #?(:cljs
       [:div
        (rum/with-ref (mdl/snackbar) "snackbar")
        (mdl/button
         {:mdl [:raised]
          :style {:background-color @color}
          :on-click (on-click-fn this)}
         "Show Snackbar")])))

(let [counter (volatile! 0)]
  (rum/defcc toast [this]
    #?(:cljs
       [:div
        (rum/with-ref (mdl/snackbar) "snackbar")
        (mdl/button
         {:mdl [:raised]
          :on-click
          (fn [_]
            (vswap! counter inc)
            (let [show-snackbar (aget this "refs" "snackbar" "show-snackbar")]
              (show-snackbar
               #js {:message (str "Example Message #" @counter)})))}
         "Show Toast")])))

(rum/defc examples
  []
  (demo/section
   (demo/intro "Snackbar")
   (demo/oneliner
    (example-snackbar)
    "Snackbar"
    (toast)
    "Toast")))
