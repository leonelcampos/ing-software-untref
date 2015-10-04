Feature: Arriesgar letra

Scenario: Arriesgo una letra y pierdo una vida
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 6 vidas
And resultado "Sigo vivo"

Given la palabra secreta es "auto"
And tengo 6 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 5 vidas
And resultado "Sigo vivo"

Given la palabra secreta es "auto"
And tengo 5 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 4 vidas
And resultado "Sigo vivo"

Given la palabra secreta es "auto"
And tengo 4 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 3 vidas
And resultado "Sigo vivo"


Given la palabra secreta es "auto"
And tengo 3 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 2 vidas
And resultado "Sigo vivo"


Given la palabra secreta es "auto"
And tengo 2 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una letra y pierdo el juego
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "****"
When arriesgo "X"
Then estado es "****"
And me quedan 0 vidas
And resultado "El juego ha terminado. Estas ahorcado"

Scenario: Arriesgo una letra y acierto
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "a***"
When arriesgo "o"
Then estado es "a**o"
And me quedan 1 vidas
And resultado "Sigo vivo"

Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "a**o"
When arriesgo "t"
Then estado es "a*to"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una letra y acierto dos
Given la palabra secreta es "carro"
And tengo 1 vidas
And estado actual es "*****"
When arriesgo "r"
Then estado es "**rr*"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una letra y gano el juego
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "a*to"
When arriesgo "u"
Then estado es "auto"
And me quedan 7 vidas
And resultado "El juego ha terminado. Has ganado!"

Scenario: Arriesgo una letra mayuscula y acierto
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "A"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una letra minuscula y acierto 
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "a"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

