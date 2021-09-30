

fibonacci :: Integer -> Integer
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2)


Prelude> :load Fib.hs
[1 of 1] Compiling Main             ( Fib.hs, interpreted )
Ok, modules loaded: Main.
*Main> 
*Main> fibonacci 0
0
*Main> fibonacci 1
1
*Main> fibonacci 2
1
*Main> fibonacci 3
2
*Main> fibonacci 4
3
*Main> fibonacci 5
5

