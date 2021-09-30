quickSort :: Ord a => [a] -> [a]
quickSort [] = []
quickSort (x:xs) = quickSort lhs ++ [x] ++ quickSort rhs
                   where
                       lhs = filter (< x) xs
                       rhs = filter (>= x) xs


*Main> quickSort [1, 10, 15, 43, 23, 21, 43, 21]
[1,10,15,21,21,23,43,43]
*Main> 
*Main> quickSort "Hello World to Haskell"
"   HHWadeeklllllooorst"
*Main> 
*Main> quickSort [[1, 2, 3], [4, 5, 6], [1, 3, 4, 5]]
[[1,2,3],[1,3,4,5],[4,5,6]]

