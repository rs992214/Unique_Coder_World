Prelude> :m Data.Set
Prelude Data.Set> 
Prelude Data.Set> let set1 = fromList [2, 3, 5, 2, 3, 10, 19, 5]
Prelude Data.Set> set1
fromList [2,3,5,10,19]
Prelude Data.Set> 
Prelude Data.Set> let list1 = toList set1
Prelude Data.Set> list1
[2,3,5,10,19]
