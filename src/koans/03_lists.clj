(ns koans.03-lists
  (:require [koan-engine.core :refer :all]))

(meditations
  "Lists can be expressed by function or a quoted form"
  (= '(1 2 3 4 5) (list 1 2 3 4 5)) 

  "They are Clojure seqs (sequences), so they allow access to the first"
  (= 1 (first '(1 2 3 4 5))) ;https://clojure.org/reference/sequences

  "As well as the rest"
  (= (list 2 3 4 5) (rest '(1 2 3 4 5))) ; rest gives you what is after the first element

  "Count your blessings"
  (= 3 (count '(dracula dooku chocula)))

  "Before they are gone"
  (= 0 (count '()))

  "The rest, when nothing is left, is empty"
  (= '() (rest '(100))) ; empty seq -> '()

  "Construction by adding an element to the front is easy"
  (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e))) ; :keywords have colons symbols quotes

  "Conjoining an element to a list isn't hard either"
  (= '(:e :a :b :c :d) (conj '(:a :b :c :d) :e)) ; cons and conj apparently do the same but they vary depending on the type of the collection passed plus the arg quantity and order
    ;https://stackoverflow.com/questions/3008411/clojure-consseq-vs-conjlist

  "You can use a list like a stack to get the first element"
  (= (keyword "a") (peek '(:a :b :c :d :e)))

  "Or the others"
  (= '(:b :c :d :e) (pop '(:a :b :c :d :e))) ;the symbol reserved keyword is not the same as the quote notation

  "But watch out if you try to pop nothing"
  (= "No dice!" (try
          (pop '())
          (catch IllegalStateException e
            "No dice!"))) ;catch associates the rules after the expected exception description to be executed if it is the first match to be found

  "The rest of nothing isn't so strict"
  (= '() (try
          (rest '())
          (catch IllegalStateException e
            "No dice!"))))
