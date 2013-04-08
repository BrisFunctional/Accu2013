(ns sokoban.hard-mode)


;; a harder level, if you're ready

(def beast-mode
  {:person [1 2]
   :targets #{[7 0] [7 1] [7 2] [7 3]}
   :crates #{[2 2] [3 2] [4 2] [6 1]}
   :blanks #{                                     [6 0] [7 0] [8 0]
                    [1 1] [2 1] [3 1]             [6 1] [7 1] [8 1]
                    [1 2] [2 2] [3 2] [4 2] [5 2] [6 2] [7 2] [8 2]
                          [2 3] [3 3]       [5 3] [6 3] [7 3] [8 3]
                          [2 4] [3 4]}})