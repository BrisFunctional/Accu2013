(ns sokoban.game
  (:require [sokoban.io :as io]))

(def start-world
  {:person [2 2]
   :targets #{[0 0]}
   :crates #{[1 0]}
   :blanks #{[0 0] [1 0] [2 0]
             [0 1]       [2 1]
             [0 2] [1 2] [2 2]}})

(def beast-mode
  {:person [1 2]
   :targets #{[7 0] [7 1] [7 2] [7 3]}
   :crates #{[2 2] [3 2] [4 2] [6 1]}
   :blanks #{                                     [6 0] [7 0] [8 0]
                    [1 1] [2 1] [3 1]             [6 1] [7 1] [8 1]
                    [1 2] [2 2] [3 2] [4 2] [5 2] [6 2] [7 2] [8 2]
                          [2 3] [3 3]       [5 3] [6 3] [7 3] [8 3]
                          [2 4] [3 4]}})




(defn do-move [[x y] d]
  (condp = d
    :n [x (dec y)]
    :s [x (inc y)]
    :w [(dec x) y]
    :e [(inc x) y]))


(defn blank? [world pos]
  ((world :blanks) pos))

(defn crate? [world pos]
  ((world :crates) pos))

(defn empty? [w p]
  (and (blank? w p)
       (not (crate? w p))))

(defn move-crate [world old new]
  (-> (disj (world :crates) old)
      (conj new)))

(defn generate-next-world [world move]
  
  (let [ppos (world :person)
        npos (do-move ppos move)
        nnpos (do-move npos move)]
    
    (cond
      
      (empty? world npos) (assoc world :person npos)
      
      (and (crate? world npos)
           (empty? world nnpos)) (assoc world
                                        :person npos
                                        :crates (move-crate world npos nnpos))
                                        
           
      :else world)))
    
  ;; is the move legal?
  ;;  - person moving into blank?
  ;;  - person moving onto crate?
  ;;    - crate moving onto blank?
  
  
(defn won? [world]
  ;; false)
  (= (world :targets) (world :crates)))



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
