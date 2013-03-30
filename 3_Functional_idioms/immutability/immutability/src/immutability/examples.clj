(ns immutability.examples)

;; here's some data

(def city2004 {:name "Bristol"
               :location "The South-West"
               :population 430000}) ;; 2004 estimate

;; lets update the population with a more recent estimate

(def city2011 
  (assoc city2004 
         :population 428100)) ;; 2011 census - population went down?


;; now city2004 & city2011 are both in scope
;; beacuse they're immutable, there is no problem
;; sharing the :name and :location elements

;; if city2004 ever goes out of scope, it's population is
;; eligible for garbage collection