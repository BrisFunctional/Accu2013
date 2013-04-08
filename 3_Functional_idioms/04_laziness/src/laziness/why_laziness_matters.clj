(ns laziness.why-laziness-matters)

;; Why do we care about laziness?

;; The paper "Why Functional Programming Matters" explains this very well.
;; http://www.cse.chalmers.se/~rjmh/Papers/whyfp.html


;; an infinite sequence
(def reciprocals
  (map #(/ 1 %) (next (range))))


;; check the first few terms
(take 10 reciprocals)


;; What is the shortest list of reciprocals whose sum
;; is greater than 3?
(first
  (drop-while #(> 3 (apply + %)) 
              (map #(take % reciprocals) (range))))

;; This would be done using a `for` or a `while` in an imperative language
;; but using a lazy seq allows us to decouple
;; generation of the values, and the terminating condition

;; functions that take a lazy sequence and do something iteratively to it
;; can return a lazy sequence, too.
