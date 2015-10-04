Feature: Juego Ahorcado

Scenario: Arriesgo una "X" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "x"
Then estado es "****"
And me quedan 6 vidas

Scenario: Arriesgo una "A" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "A"
Then estado es "a***"
And me quedan 7 vidas


Scenario: Arriesgo una "a" 
Given la palabra secreta es "auto"
And tengo 7 vidas
When arriesgo "a"
Then estado es "a***"
And me quedan 7 vidas

