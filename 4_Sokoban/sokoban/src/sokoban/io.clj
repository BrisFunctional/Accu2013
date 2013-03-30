(ns sokoban.io)

(defn read-user-input []
  ;; This would be done using stdin, but that doesn't work easily
  ;; when the app is running inside clooj
  (javax.swing.JOptionPane/showInputDialog "Your next move? (w-a-s-d keys)"))

(defn get-next-move []
  (condp = (read-user-input)
    "w" :n
    "a" :w
    "s" :s
    "d" :e
    (recur)))



(defn printable-char [world pos]
  (cond
    (= pos (world :person)) "I"
    (and ((world :crates) pos)
         ((world :targets) pos)) "0"
    ((world :crates) pos) "C"
    ((world :targets) pos) "."
    ((world :blanks) pos) " "
    :else "#"))

(defn print-the-world [world]
  (let [extents (apply (partial map max) (world :blanks))]
    (doseq [y (range -1 (+ 2 (second extents)))]
      (do (doseq [x (range -1  (+ 2 (first extents)))]
            (print (printable-char world [x y])))
          (println)))))
