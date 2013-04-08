(ns sokoban.hints.moving)


;; WORKING OUT WHERE A MOVE WILL END UP

(defn do-move
  "returns the new coordinate after moving in direction d from coord [x y]"
  [[x y] d]
  (condp = d
    :n [x (dec y)]
    :s [x (inc y)]
    :w [(dec x) y]
    :e [(inc x) y]))






;; MOVING A CRATE

(defn move-crate [world old new]
  (-> (disj (world :crates) old)
      (conj new)))
