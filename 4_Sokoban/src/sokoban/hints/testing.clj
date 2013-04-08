(ns sokoban.hints.testing)

;; TESTING PLACES FOR PROPERTIES

(defn blank? 
  "is the position pos contained in the set of world's blanks?"
  [world pos]
  ((world :blanks) pos))

(defn crate?
  "is the position pos covered by a crate?"
  ;; similar to the above
  )


(defn empty?
  "is the position pos empty (ie a blank, but not covered by a crate)"
  [w p]
  (and (blank? w p)
       (not (crate? w p))))


