(ns laziness.why-laziness-matters)

;; Why do we care about laziness?

;; The paper "Why Functional Programming Matters" explains this very well.
;; http://www.cse.chalmers.se/~rjmh/Papers/whyfp.html


;; an infinite sequence
(def reciprocals
  (map #(/ 1 (inc %)) (range)))


;; the first few terms
(take 10 reciprocals)


;; What is the shortest list of reciprocals whose sum
;; is greater than 3?
(first
  (drop-while #(> 3 (reduce + %)) 
              (map #(take (inc %) reciprocals) 
                   (range))))

;; This would be do using a `for` or a `while` without laziness
;; but using a lazy seq allows us to decouple
;; generation of the values, and the terminating condition
