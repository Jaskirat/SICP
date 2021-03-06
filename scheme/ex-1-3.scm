;;Exercise 1.3.  Define a procedure that takes three numbers as
;;arguments and returns the sum of the squares of the two larger
;;numbers.

(define (sum-of-squares x y)
  (+ (* x x) (* y y)))

(define (larger-sum-of-squares x y z)
  (cond
   ((and (>= x z) (>= y z)) (sum-of-squares x y))
   ((and (>= y x) (>= z x)) (sum-of-squares y z))
   (else (sum-of-squares x z))))
