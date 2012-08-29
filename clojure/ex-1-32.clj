;;Exercise 1.32.
;;a. Show that sum and product (exercise 1.31) are both
;;special cases of a still more general notion called accumulate that
;;combines a collection of terms, using some general accumulation
;;function

(defn accumulate [combiner null-value term a next b]
  (if (> a b)
    null-value
    (combiner (term a)
              (accumulate combiner null-value term (next a) next b))))

;;Write accumulate and show how sum and product can both be defined as
;;simple calls to accumulate.

(defn acc-sum [t a n b]
  (accumulate + 0 t a n b))

(defn acc-product [t a n b]
  (accumulate * 1 t a n b))


;;b. If your accumulate procedure generates a recursive process, write
;;one that generates an iterative process. If it generates an
;;iterative process, write one that generates a recursive process. 
(defn iterative-accumulate [combiner null-value term a next b]
  (loop [a a
         result null-value]
    (if (> a b)
      result
      (recur (next a) (combiner result (term a))))))
