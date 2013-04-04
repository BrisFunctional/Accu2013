(ns immutability.examples)

;; here's some data

(def city2004 {:name "Bristol"
               :location "The South-West"
               :population 430000}) ;; 2004 estimate


;; "update" the population with a more recent estimate

(def city2011
  (assoc city2004
         :population 428100)) ;; 2011 census - population went down?



;; What values are in scope now?

;; What's shared between the city2004 and city2011?

;; So, about the cost of creating city2011
;;  What new data was stored?
;;  What locking did we need to do?

;; What about when one of them goes out of scope?
