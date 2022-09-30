

{-# LANGUAGE BangPatterns #-}

ackermann :: Integer -> Integer -> Integer
ackermann !m !n
    | (m==0) = n+1
    | (m > 0) && (n==0) = ackermann (m-1) 1
    | (m > 0) && (n > 0) = ackermann (m-1) (ackermann m (n-1))


*Main> :load Ackermann.hs
[1 of 1] Compiling Main             ( Ackermann.hs, interpreted 
Ok, modules loaded: Main.
*Main> 
*Main> ackermann 0 0
1
*Main> ackermann 0 1
2
*Main> ackermann 1 4
6
*Main> ackermann 3 3
61
*Main> ackermann 3 4
125

