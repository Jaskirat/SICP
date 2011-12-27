;;Exercise 1.7.  The good-enough? test used in computing square roots
;;will not be very effective for finding the square roots of very
;;small numbers. Also, in real computers, arithmetic operations are
;;almost always performed with limited precision. This makes our test
;;inadequate for very large numbers. Explain these statements, with
;;examples showing how the test fails for small and large numbers. An
;;alternative strategy for implementing good-enough? is to watch how
;;guess changes from one iteration to the next and to stop when the
;;change is a very small fraction of the guess. Design a square-root
;;procedure that uses this kind of end test. Does this work better for
;;small and large numbers? 

;;A three digit tolerance becomes less meaningfull for very small numbers
;;and for very large numbers the floating point representation maybe
;;less meaningful and may cause us to keep guessing for a long time
;;without getting to a decent guess infinitely.

(defn sq [x]
  (* x x))

(defn avg [x y]
  (/ (+ x y)
     2))

(defn good-enough? [guess previous]
  (< (java.lang.Math/abs (- guess previous))
     0.001))

(defn improve [guess x]
  (avg guess
           (/ x guess)))

(defn sqrt-iter [guess previous x]
  (if (good-enough? guess previous)
    guess
    (sqrt-iter (improve guess x) guess x)))

(defn sqrt [x]
  (sqrt-iter 1.0 0 x))
           
