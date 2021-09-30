

simpleInterest = do
                   putStrLn ("Enter Principal")
                   inpStr <- getLine
                   let principal = (read inpStr) :: Double

                   putStrLn ("Enter time in months")
                   inpStr <- getLine
                   let time = (read inpStr) :: Integer

                   putStrLn ("Enter Rate Of Interest")
                   inpStr <- getLine
                   let rateOfInterest = (read inpStr) :: Double

                   let result = (principal * fromIntegral time * rateOfInterest) / 100

                   putStrLn ("Simple Interest : " ++ show (result))


*Main> :load InterestUtil.hs 
[1 of 1] Compiling Main             ( InterestUtil.hs, interpreted )
Ok, modules loaded: Main.
*Main> 
*Main> simpleInterest
Enter Principal
815
Enter time in months
36
Enter Rate Of Interest
2
Simple Interest : 586.8
*Main> 
*Main> simpleInterest
Enter Principal
100000
Enter time in months
12
Enter Rate Of Interest
1.10
Simple Interest : 13200.0
*Main> 

