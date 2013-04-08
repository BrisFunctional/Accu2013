(ns nps.core
  (:require [clojure.data.json :as json]))

(def surveys (json/read-str (slurp "startup.json")
                            :key-fn keyword))

(defn classify [survey]
    (condp <= (survey :score)
      9 :promoter
      7 :passive
      :detractor))

(def classified (map classify surveys))

(def n
  (count classified))

(def promoters
  (count (filter (partial = :promoter) classified)))

(def detractors
  (count (filter (partial = :detractor) classified)))

(def nps
  (* 100 (/ (- promoters detractors) n)))

(prn (float nps))