

reverseList :: [a] -> [a]
reverseList [] = []
reverseList (x:xs) =  reverseList(xs) ++ (x:[])


Prelude> :load ListUtil.hs
[1 of 1] Compiling Main             ( ListUtil.hs, interpreted )
Ok, modules loaded: Main.
*Main> 
*Main> reverseList []
[]
*Main> 
*Main> reverseList [2, 3, 5, 7]
[7,5,3,2]
*Main> 



You can rewrite above function like below also.

reverseList :: [a] -> [a]
reverseList [] = []
reverseList (x:xs) =  reverseList(xs) ++ [x]

