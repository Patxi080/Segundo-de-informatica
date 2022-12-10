module Queue (Queue, empty, enqueue, dequeue, first, isEmpty, size) where
data Queue a = EmptyQueue | Item a (Queue a) 
 
empty :: Queue a
empty = EmptyQueue

enqueue :: t -> Queue t -> Queue t
enqueue x EmptyQueue = Item x EmptyQueue
enqueue x (Item a q) = Item a (enqueue x q)

dequeue :: Queue a -> Queue a
dequeue (Item _ q) = q

first :: Queue a -> a
first (Item a _) = a 

isEmpty :: Queue a -> Bool
isEmpty EmptyQueue = True
isEmpty _ = False

size :: Num a1 => Queue a2 -> a1
size EmptyQueue = 0
size (Item _ q) = 1 + size q

instance (Eq a) => Eq (Queue a) where
    (==) :: Queue a -> Queue a -> Bool
    (==) EmptyQueue EmptyQueue = True
    (==) (Item x xs) (Item y ys) = x == y && xs == ys
    (==) _ _ = False







