

isListEmpty :: [a] -> Bool
isListEmpty [] = True
isListEmpty _ = False


*Main> :load listUtil.hs
[1 of 1] Compiling Main             ( listUtil.hs, interpreted )
Ok, modules loaded: Main.
*Main> 
*Main> isListEmpty []
True
*Main> isListEmpty [1, 2, 3]
False
*Main> isListEmpty [1..]
False
*Main> isListEmpty ""
True
*Main> 

