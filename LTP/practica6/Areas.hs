--imports
    import qualified Circle
    import qualified Triangle

    main :: IO()
    main = putStrLn ("El area del círculo es: " ++ show(Circle.area 2) ++ "\n El area del triangulo es: " ++ show(Triangle.area 4 5) )
        
