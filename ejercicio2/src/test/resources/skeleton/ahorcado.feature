Feature: Juego Ahorcado

Scenario: Arriesgo una "X" y pierdo 1 vida
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 6 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "X" y pierdo 1 vida
Given la palabra secreta es "auto"
And tengo 6 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 5 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "A" y asierto 1 letra
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "A"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "a" y asierto 1 letra
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "a"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "w" teniendo 1 vida entonces pierdo el juego
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "****"
When arriesgo "w"
Then estado es "****"
And me quedan 0 vidas
And resultado "El juego ha terminado. Estas ahorcado"

Scenario: Arriesgo una "o" y asierto 1 letra más
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "a***"
When arriesgo "o"
Then estado es "a**o"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "t" y asierto 1 letra más
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "a**o"
When arriesgo "t"
Then estado es "a*to"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "u" faltando solo esa letra entonces gano el juego
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "a*to"
When arriesgo "u"
Then estado es "auto"
And me quedan 7 vidas
And resultado "El juego ha terminado. Has ganado!"

Scenario: Arriesgo una "r" siendo la palabra carro y asierto 2 letras 
Given la palabra secreta es "carro"
And tengo 1 vidas
And estado actual es "*****"
When arriesgo "r"
Then estado es "**rr*"
And me quedan 1 vidas
And resultado "Sigo vivo"
