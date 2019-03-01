(ns koans.12-sequence-comprehensions
  (:require [koan-engine.core :refer :all]))

(meditations
  "Sequence comprehensions can bind each element in turn to a symbol" ;https://practicalli.github.io/clojure/thinking-functionally/list-comprehension.html
  (= [0, 1, 2 ,3 ,4 ,5]
     (for [x (range 6)]
       x));this form of iteration/mapping is useful for more clear statements when using nested/combined structures

  "They can easily emulate mapping"
  (= '(0 1 4 9 16 25)
     (map (fn [x] (* x x))
          (range 6))
     (for [x (range 6)]
       (* x x)));equality between three sequences. 

  "And also filtering"
  (= '(1 3 5 7 9)
     (filter odd? (range 10))
     (for [x (range 10) :when (odd? x)]
       x)) ;The comprehension syntax is for [parameter definition and possible mapping] (fn to be applied)

  "Combinations of these transformations is trivial"
  (= '(1 9 25 49 81)
     (map (fn [x] (* x x))
          (filter odd? (range 10)))
     (for [x (range 10) :when (odd? x)]
       (* x x)))
       ;On the other hand, the map syntax looks like map (the function) (for the values here defined)

  "More complex transformations simply take multiple binding forms"
  (= [[:top :left] [:top :middle] [:top :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]
     (for [row [:top :middle :bottom]
           column [:left :middle :right]]
       (vector row column))))
