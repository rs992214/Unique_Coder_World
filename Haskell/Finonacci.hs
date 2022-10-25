module Main where

import Text.Printf

fibs :: [Int]
fibs = 0 : 1 : zipWith (+) fibs (tail fibs)
line n = printf "%d, " $ fibs !! n

main = do
    sequence_ $ map line [1..16]
    putStrLn "..."
