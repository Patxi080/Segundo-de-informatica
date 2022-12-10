module Compare where
    type Nombre = String
    type Edad = Int
    type Persona = (Nombre, Edad)

    (==) :: (Eq Persona)=> Persona -> Persona -> Bool 
    (==) persona1 persona2 = if (Nombre,_) == (Nombre,_) && persona1.Edad == persona2.Edad then True else False