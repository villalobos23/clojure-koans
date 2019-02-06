(ns koans.07-functions
  (:require [koan-engine.core :refer :all]))

(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n)); named function

(meditations
  "Calling a function is like giving it a hug with parentheses"
  (= 81 (square 9))

  "Functions are usually defined before they are used"
  (= 20 (multiply-by-ten 2))

  "But they can also be defined inline"
  (= 10 ((fn [n] (* 5 n)) 2)) ;anonymous function

  "Or using an even shorter syntax"
  (= 60 (#(* 15 %) 4)); https://stackoverflow.com/questions/13204993/anonymous-function-shorthand

  "Even anonymous functions may take multiple arguments"
  (= 15 (#(+ %1 %2 %3) 4 5 6))

  "Arguments can also be skipped"
  (= "AACC" (#(str "AA" %2) "bb" "CC"))

  "One function can beget another"
  (= 9 (((fn [] + )) 4 5)) ;https://stackoverflow.com/questions/41584697/doc-on-how-one-function-can-beget-another-in-clojurescript
    ;anonymous function defined and set. It is a function that returns a function, in this case the addition

  "Functions can also take other functions as input"
  (= 20 ((fn [f] (f 4 5)) ;function as parameter for an anonymous function
           *))

  "Higher-order functions take function arguments"
  (= 25 ((fn [f] (f 5))
          (fn [n] (* n n)))) ;https://stackoverflow.com/questions/21816506/clojure-higher-order-functions-take-function-arguments-but-what-is-the-syntax
            ;Define a function that takes a function and calls it passing five as an argument (IIFE in javascript). 
            ;Inmediately invoke it passing as a parameter a function that is anonymously defined as the power function
            ;Is the same as the previous example but with an anonymous function

  "But they are often better written using the names of functions"
  (= 25 ((fn [f] (f 5)) square))
  
  )