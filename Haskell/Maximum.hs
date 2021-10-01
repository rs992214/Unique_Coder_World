

getMaximum :: Int -> Int -> Int -> Int
getMaximum a b c
    | (a >= b) && (a >= c) = a
    | (b >= c) = b
    | otherwise = c


Prelude> :load Sample.hs
[1 of 1] Compiling Main             ( Sample.hs, interpreted )
Ok, modules loaded: Main.
*Main> 
*Main> getMaximum 10 20 30
30
*Main> getMaximum 10 30 20
30
*Main> getMaximum 30 10 20
30

