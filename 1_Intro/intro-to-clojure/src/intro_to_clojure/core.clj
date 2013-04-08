(ns intro-to-clojure.core
  (:use clojure.repl))

;; Ctrl-<Enter> to evaluate the expression
;;              at the cursor
;; Ctrl-E       to evaluate the whole file

;; prefix notation
(+ 2 2)

(= 4 (+ 2 2))

;; define a var
(def be-polite "Hello World!")

;; print it
(prn be-polite)

;; define a function in the same way
(def add 
  (fn [a b] 
    (+ a b)))

;; or with a shorthand
(defn add [a b]
  (+ a b))

;; call it
(add 2 2)

(= 
  (+ 2 2)
  (add 2 2))

;; symbols are a bit like consts
;; they evaluate to their value
*file*

;; keywords are symbols that evaluate to themselves
;; they always start with a :
:keyword

;; data structures
;; define a list (vector) with []
[1, 2, 3, 4, 5, "six", :seven]

;; commas optional
[1 2 3 4 5 "six" :seven]

;; lists are ordered
(def a-list [1, 1, 2, 3, 5, 8, 13])
(def another-list [13, 8, 5, 3, 2, 1, 1])
(not (= a-list another-list))

;; dictionary
;; define a dictionary with {}
{:key "value"}

;; use commas if that makes you feel more comfortable ;)
(def a-dict {:key1 "value1", :key2 "value2", :key3 "value3"})
(def another-dict {:key1 "value1" :key2 "value2" :key3 "value3"})
(= a-dict another-dict)

;; set
(def a-set #{1, 2, 3})
(def another-set #{3, 2, 1})
(= a-set another-set)

;; functions can be taken as arguments and
;;  returned as a result
;;  can you spot the closure?
(defn n-ify [f n]
  (fn [a] (f n a)))

(def add2 (n-ify add 2))

(add2 2)

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

;check it
(= 
  (take 42 fib)
  (take 42 fibo)
  (take 42 you-fibber))
