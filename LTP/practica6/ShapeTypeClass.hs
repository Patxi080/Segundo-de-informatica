type Side = Float
type Apothem = Float
type Radius = Float

type Height = Float
type Volume = Float

type Base = Float
type Depth = Float
type Area = Float

data Pentagon = Pentagon Side Apothem
data Circle = Circle Radius

class Shape a where
    perimeter :: a -> Float
    area :: a -> Float

instance Shape Pentagon where
    perimeter :: Pentagon -> Float
    perimeter (Pentagon s a) = 5 * s

    area :: Pentagon -> Float
    area (Pentagon s a) = 5 * ((s * a) / 2)

instance Shape Circle where
    perimeter :: Circle -> Float
    perimeter (Circle r) = 2 * pi * r

    area :: Circle -> Float
    area (Circle r) = pi * r * r

volumePrism :: (Shape a) => a -> Height -> Volume
volumePrism base height = (area base) * height

surfacePrism :: (Shape a) => a -> Height -> Area
surfacePrism base height = 2 * (area base) + (perimeter base) * height