(ns koans.13-creating-functions
  (:require [koan-engine.core :refer :all]))

(defn square [x] (* x x))

(meditations
  "One may know what they seek by knowing what they do not seek"
  (= [true false true] (let [not-a-symbol? (complement symbol?)]
                  (map not-a-symbol? [:a 'b "c"])));the first one is a keyword, the second a symbol the third a string

  "Praise and 'complement' may help you separate the wheat from the chaff"
  (= [:wheat "wheat" 'wheat]
       (let [not-nil? (complement nil?)]
         (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil])))

  "Partial functions allow procrastination"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (multiply-by-5 4))) ;https://stackoverflow.com/questions/622785/let-vs-def-in-clojure

  "Don't forget: first things first"
  (= [:a :b :c :d]
       (let [ab-adder (partial concat [:a :b])]
         (ab-adder [:c :d])))

  "Functions can join forces as one 'composed' function"
  (= 25 (let [inc-and-square (comp square inc)]
          (inc-and-square 4)));https://clojuredocs.org/clojure.core/comp
                ;https://stuartsierra.com/2015/04/26/clojure-donts-concat
                ;https://dzone.com/articles/clojure-partial-and-comp

  "Have a go on a double dec-er"
  (= 8 (let [double-dec (comp dec dec)]
          (double-dec 10)))

  "Be careful about the order in which you mix your functions"
  (= 99 (let [square-and-dec (comp dec square)];the first function of the composition applied to the args is the last on the right
          (square-and-dec 10))))
