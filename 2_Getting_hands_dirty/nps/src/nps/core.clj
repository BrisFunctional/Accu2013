(ns nps.core
  (:require [clojure.data.json :as json]))

(def surveys (json/read-str (slurp "startup.json")
                            :key-fn keyword))

(defn classify [score]
    (condp <= score 
      9 :promoter
      7 :passive
      :detractor))
 
(def classified 
  (map (comp classify #(:score %)) surveys))

(defn nps [a b]
  (let [c (assoc a :items (inc (:items a)))]
    (condp = b
      :promoter (assoc c :promoters (inc (:promoters c)))
      :passive c
      :detractor (assoc c :detractors (inc (:detractors c))))))

(reduce nps {:items 0 :promoters 0 :detractors 0} classified)