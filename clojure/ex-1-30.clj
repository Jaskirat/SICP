;;Exercise 1.30.  The sum procedure above generates a linear
;;recursion. The procedure can be rewritten so that the sum is
;;performed iteratively. Show how to do this by filling in the missing
;;expressions in the following definition: 


;; (define (sum term a next b)
;;   (define (iter a result)
;;     (if <??>
;;       <??>
;;       (iter <??> <??>)))
;;   (iter <??> <??>))

(defn iterative-sum [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (+ result (term a)))))
  (iter a 0))


;;Something similar perhaps in a more
;;clojure idiomatic way?
(defn recur-loop-sum [term a next b]
  (loop [a a
         result 0]
    (if (> a b)
      result
      (recur (next a) (+ result (term a))))))

;;somehow reduce feels more nicer
;;its also lazy :-)
(defn map-reduce-sum [term a next b]
  (let [nexter (iterate next a)
        col (take-while #(<= %1 b) nexter)]
    (reduce + (map term col))))

;;yeah naming functions is hard.