Feature: Juego Ahorcado

Scenario: Arriesgo una "X" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "x"
Then estado es "****"
And me quedan 6 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "A" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "A"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "a" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "a"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "w" 
Given la palabra secreta es "auto"
And tengo 1 vidas
When arriesgo "w"
Then estado es "****"
And me quedan 0 vidas
And resultado "El juego ha terminado. Estas ahorcado"
