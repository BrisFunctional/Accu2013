(ns sokoban.game
  (:require [sokoban.io :as io]))

(def start-world
  {:person [2 2]
   :targets #{[0 0]}
   :crates #{[1 0]}
   :blanks #{[0 0] [1 0] [2 0]
             [0 1]       [2 1]
             [0 2] [1 2] [2 2]}})


(defn generate-next-world [world move]
    ;; is the move legal?
    ;;  - person moving into blank?
    ;;  - person moving onto crate?
    ;;    - crate moving onto blank?
  )
  

(defn won? [world]
   false)

(defn do-turn [world]
  (io/print-the-world world)
  (generate-next-world world 
                       (io/get-next-move)))

(defn print-win [world]
  (io/print-the-world world)
  "YAY!")
           
(defn game-loop [world]
  (if (won? world)
    (print-win world)
    (recur (do-turn world))))

(game-loop start-world)
