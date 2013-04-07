(ns intro-to-clojure.core
  (:use clojure.repl))

;; Ctrl-<Enter> to evaluate the expression
;;              at the cursor
;; Ctrl-E       to evaluate the whole file

;; prefix functions
(= 4 (+ 2 2))

;; define a var
(def be-polite "Hello World!")

;; print it
(println be-polite)

;; define a function in the same way
(def add 
  (fn [a b] 
    (+ a b)))

;; or with a shorthand
(defn add [a b]
  (+ a b))

;; call it
(= 4 (add 2 2))

;; functions can be taken as arguments and
;;  returned as a result
;;  can you spot the closure?
(defn n-ify [f n]
  (fn [a] (f n a)))

(def add2 (n-ify add 2))

(= 4 (add2 2))

;; clojure has an extensive built-in library
;;  complete with docs and source
;;  beware rabbit-holes
;; http://clojure.org/cheatsheet
;; http://clojuredocs.org/clojure_core/clojure.core
(doc map)

(find-doc "recursion")

(source trampoline)

;; challenge - fibonacci series
;; here's an idiomatic clojure version
;; can you work out how this works?
(def fib 
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

;; this is my favorite definition
(def fibo 
  (lazy-cat [0 1] (map + fibo (rest fibo))))

(= 
  (take 42 fib)
  (take 42 fibo))

;; your turn - have a go at implementing your
;;  own fib
(def you-fibber
  ;; fill in the blanks
  [0 1]
  )

(= 
  (take 42 fib)
  (take 42 fibo)
  (take 42 you-fibber))
