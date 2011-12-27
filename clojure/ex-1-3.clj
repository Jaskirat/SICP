;;Exercise 1.3.  Define a procedure that takes three numbers as
;;arguments and returns the sum of the squares of the two larger
;;numbers.


(defn larger-sum-of-sq [& list]
  (let [sorted-list  (reverse (sort list))
        f (first sorted-list)
        s (second sorted-list)]
    (+ (* f f) (* s s))))
