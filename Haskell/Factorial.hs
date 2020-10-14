module Main where

import Text.Printf

factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n - 1)

line x = printf "%d! = %d\n" x $ factorial x

main = mapM_ line [0..16]
