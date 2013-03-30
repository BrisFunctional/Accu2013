(ns sokoban.test)


;; this is basic arithmetic
(= (- 10 (* 2 3)) 4)

;; function invocation
(+ 2 3 4)

;; function definition
(defn foo [x]
  (* 2 x))
(foo 10)

;; lists, maps, sets
[1 2 3 4]

{:name "Matthew"
 :likes #{"hot food" "dogs"}}


;; -- enough?

;; functions that "alter" collections

(assoc {:name "Thom"}
       :name "Matthew")