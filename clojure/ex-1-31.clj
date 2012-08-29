;;Exercise 1.31.
;;a.The sum procedure is only the simplest of a vast number of
;;similar abstractions that can be captured as higher-order
;;procedures.Write an analogous procedure called product that returns
;;the product of the values of a function at points over a;given
;;range.

(defn product [term a next b]
  (if (> a b)
    1
    (* (term a)
       (product term (next a) next b))))


;;Show how to define factorial in terms of product.
(defn factorial [n]
  (product identity 1 inc n))


;;Also use product to compute approximations to using walli's formula
;;Walli's formula can be reduced to
;; Pi/2= (4n^2)/(4n^2 -1)

(defn wallis-formula [n]
  (let [f #(/ (* 4 % %)
              (dec (* 4 % %)))]
    (* (product f 1 inc n) 2.0)))

;; user> (wallis-formula 10)
;; 3.067703806643498
;; user> (wallis-formula 100)
;; 3.133787490628162
;; user> (wallis-formula 200)
;; 3.137677900950936


;;1.31-b
;;If your product procedure generates a recursive process,
;;write one that generates an iterative process. If it generates an
;;iterative process, write one that generates a recursive process


(defn iterative-product [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (* result (term a)))))
  (iter a 1))


;;I am not sure if the prevous function
;;will end up being iterative after the
;;clojure compiler is done with it.
;;Using recur-loop to be idiomiatic in clojure
(defn recur-loop-prod [term a next b]
  (loop [a a
         result 1]
    (if (> a b)
      result
      (recur (next a) (* result (term a))))))