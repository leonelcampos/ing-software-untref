Feature: Juego Ahorcado

Scenario: Arriesgo una "X" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "x"
Then estado es "****"
And me quedan 6 vidas

