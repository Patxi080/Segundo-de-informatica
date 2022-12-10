module QueueV2 where
data Queue a = Queue [a] [a]

empty :: Queue a
empty = Queue [] []

enqueue :: a -> Queue a -> Queue a
enqueue y (Queue xs ys) = Queue xs (y:ys)

dequeue :: Queue a -> Queue a
dequeue (Queue (x:xs) ys) = Queue xs ys
dequeue (Queue [] ys) = dequeue (Queue (reverse ys) [])

first :: Queue a -> a
first (Queue (x:xs) ys) = x
first (Queue [] ys) = head (reverse ys)

isEmpty :: Queue a -> Bool
isEmpty (Queue [] []) = True
isEmpty _ = False

instance (Show a ) => Show (Queue a) where
    show :: Show a => Queue a -> String
    show queue
        | isEmpty queue = "<-"
        | otherwise = "<-" ++ (show (first queue)) ++ (show (dequeue queue))
    