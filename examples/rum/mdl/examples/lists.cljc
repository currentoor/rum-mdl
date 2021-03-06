(ns rum.mdl.examples.lists
  (:require
   [rum.core :as rum]
   [rum.mdl  :as mdl]
   [rum.mdl.demo :as demo]
   [rum.mdl.examples.badges :as badge]))

(rum/defc examples
  []
  (demo/section
   (demo/intro "Lists")
   (demo/oneliner
    (mdl/list
     (mdl/li {:content "React"})
     (mdl/li {:content "Rum"})
     (mdl/li {:content "Rum-MDL"}))
    "Simple list"
    (mdl/list
     (mdl/li {:icon "person" :content "React"})
     (mdl/li {:icon "person" :content "Rum"})
     (mdl/li {:icon "person" :content "Rum-MDL"}))
    "Icons")
   (demo/snippet
    {:components
     [(mdl/list
       (mdl/li {:icon "person" :content "React"}
               {:action (badge/my-badge badge/counter)})
       (mdl/li {:icon "person" :content "Rum"}
               {:action (badge/my-badge badge/counter)})
       (mdl/li {:icon "person" :content "Rum-MDL"}
               {:action (badge/my-badge badge/counter)}))
      (mdl/list
       (mdl/li {:icon "person" :content "Rum"}
               {:action (mdl/checkbox {:mdl [:ripple] :for "checkbox-1"})})
       (mdl/li {:icon "person" :content "Rum-MDL"}
               {:action (mdl/switch {:mdl [:ripple] :for "switch-1" :checked true})}))]
     :captions
     ["Avatars and actions"
      "Avatars and controls"]})
   (demo/snippet
    {:components
     [(mdl/list
       (mdl/li {:mdl [:two]
                :icon "person" :content "Rum"
                :sub "React wrapper"}
               {:action (mdl/checkbox {:mdl [:ripple] :for "checkbox-2"})})
       (mdl/li {:mdl [:two]
                :icon "person" :content "Rum-MDL"
                :sub "MDL wrapper written with RUM"}
               {:action (mdl/switch {:mdl [:ripple] :for "switch-2" :checked true})
                :info "Actor"}))]
     :captions
     ["Two line"]})
   (demo/snippet
    {:components
     [(mdl/list
       (mdl/li {:mdl [:three]
                :icon "person" :content "Bryan Cranston"
                :body "Bryan Cranston played the role of Walter in Breaking Bad. He is also known for playing Hal in Malcom in the Middle."}
               {:action (mdl/icon "star")})
       (mdl/li {:mdl [:three]
                :icon "person" :content "Aaron Paul"
                :body "Aaron Paul played the role of Jesse in Breaking Bad. He also featured in the \"Need For Speed\" Movie."}
               {:action (mdl/icon "star")})
       (mdl/li {:mdl [:three]
                :icon "person" :content "Bob Odenkirk"
                :body "Bob Odinkrik played the role of Saul in Breaking Bad. Due to public fondness for the character, Bob stars in his own show now, called \"Better Call Saul\"."}
               {:action (mdl/icon "star")}))]
     :captions
     ["Three line"]})))
