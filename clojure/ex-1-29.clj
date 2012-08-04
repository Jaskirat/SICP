;;Exercise 1.29.  Simpson's Rule is a more accurate method of numerical
;;integration than the method illustrated above. Using Simpson's Rule,
;;the integral of a function f between a and b is approximated as
;;h(y0 + 4y1 + 2y2 + 4y3 + 2y4 + ... + 2yn-2 + 4yn-1 + yn) / 3

;;Credits:
;;I first did a sum of four terms
;;one for 4*yk another for 2*yk and y0+yn
;;Later found bill's answer which uses cond/odd/even
;;which seemed much better. Thanks Bill!
;;http://www.billthelizard.com/2010/04/sicp-exercise-129-integration-using.html

(defn simpsons [f a b n]
  (let [h (/ (- b a) n)
        y #(f (+ a (* %1 h)))
        term (fn [x]
               (* (cond (or (zero? x) (= n x)) 1
                        (odd? x) 4
                        :else 2) 
                  (y x)))]
    (* (/ h 3) (sum term 0 inc n))))


;;If you don't qualify the floats, you get
;; back a ratio (ftw)
;; user> (simpsons cube  0 1 100)
;; 1/4

;; user> (simpsons cube  0 1 100.0)
;; 0.24999999999999992
;; user> (simpsons cube  0 1 1000.0)
;; 0.2500000000000003
