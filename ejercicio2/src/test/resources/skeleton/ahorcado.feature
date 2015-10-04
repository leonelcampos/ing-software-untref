Feature: Juego Ahorcado

Scenario: Arriesgo una "X" teniendo 7 vidas entonces me quedo con 6 vidas
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 6 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "X" teniendo 6 vidas entonces me quedo con 5 vidas
Given la palabra secreta es "auto"
And tengo 6 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 5 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "X" teniendo 5 vidas entonces me quedo con 4 vidas
Given la palabra secreta es "auto"
And tengo 5 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 4 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "X" teniendo 4 vidas entonces me quedo con 3 vidas
Given la palabra secreta es "auto"
And tengo 4 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 3 vidas
And resultado "Sigo vivo"


Scenario: Arriesgo una "X" teniendo 3 vidas entonces me quedo con 2 vidas
Given la palabra secreta es "auto"
And tengo 3 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 2 vidas
And resultado "Sigo vivo"


Scenario: Arriesgo una "X" teniendo 2 vidas entonces me quedo con 1 vidas
Given la palabra secreta es "auto"
And tengo 2 vidas
And estado actual es "****"
When arriesgo "x"
Then estado es "****"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "X" teniendo 1 vida entonces me quedo con 0 vidas y pierdo el juego
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "****"
When arriesgo "X"
Then estado es "****"
And me quedan 0 vidas
And resultado "El juego ha terminado. Estas ahorcado"

Scenario: Arriesgo una "A" mayuscula y acierto 1 letra
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "A"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "a" minuscula y acierto 1 letra
Given la palabra secreta es "auto"
And tengo 7 vidas
And estado actual es "****"
When arriesgo "a"
Then estado es "a***"
And me quedan 7 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "o" y acierto 1 letra más
Given la palabra secreta es "auto"
And tengo 1 vidas
And estado actual es "a***"
When arriesgo "o"
Then estado es "a**o"
And me quedan 1 vidas
And resultado "Sigo vivo"

Scenario: Arriesgo una "t" y acierto 1 letra más
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

Scenario: Arriesgo una "r" siendo la palabra carro y acierto 2 letras 
Given la palabra secreta es "carro"
And tengo 1 vidas
And estado actual es "*****"
When arriesgo "r"
Then estado es "**rr*"
And me quedan 1 vidas
And resultado "Sigo vivo"
