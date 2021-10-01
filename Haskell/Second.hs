Prelude> let secondElements tup = [(snd p) | p <- tup]
Prelude> 
Prelude> secondElements [(1, 1), (2, 4), (3, 9), (4, 16), (5, 25)]
[1,4,9,16,25]
