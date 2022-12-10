
module List where
    import Queue (enqueue,first, dequeue, isEmpty, Queue, empty )
    import Distribution.ModuleName (main)
    toList :: Queue a -> [a]
    toList queue 
        |isEmpty queue   = []
        |otherwise = first queue : toList (dequeue queue)

    fromList :: [a] -> Queue a
    fromList (x:xs)
        |length (x:xs) == 0 = empty 
        |otherwise = (enqueue x)  (fromList xs)

    main :: IO()
    main = putStrLn (show (toList (enqueue 5 (enqueue 6 (enqueue 15 empty)))))
    
   
   
   
   
   