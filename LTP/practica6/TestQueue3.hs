import Queue ( empty, enqueue )
main :: IO ()
main = do
   putStrLn (show (enqueue 7 (enqueue 5 empty)))
