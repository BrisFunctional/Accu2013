(ns laziness.examples)

;; an infinite sequence (evaluate it if you want to find out...)
;; (but check the keyboard shortcut for 'kill repl' first ;)
(range)

;; but, still, we can do
(take 10 (range))

;; or
(take 10 (map (fn [x] (* x x)) (range)))


;; How are we passing around an infinite list?

;; How is this implemented internally?

;; What similar features are there in $other_language?
