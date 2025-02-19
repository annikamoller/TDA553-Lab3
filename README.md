# Laboration-3


## UML-Diagram Uppgift 2
![screenshot](TDA553_Lab3_Uppgift2.png)

## UML-Diagram Uppgift 4
![screenshot](TDA553_Lab3_Uppgift4.png)

## Refaktoriseringsplan
* Ta bort de falska override-funktionerna gas() brake() osv från CarController så det blir mindre coupling mellan CarController och Car och högre cohesion inom Car
* CarController in i mindre klasser, för just nu hanterar den både simuleringslogik, bilbeteende och GUI (via CarView)
* Ta bort komposition av CarController i CarView
