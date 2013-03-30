(ns sokoban.fib)


(defn fib [l]
  (cons (+ (first l) (second l)) l))


(take 10 (iterate fib [1 1]))