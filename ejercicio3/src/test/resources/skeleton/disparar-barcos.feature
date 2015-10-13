Feature: Como usuario quiero disparar a los barcos enemigos

Scenario: Disparo y toco agua
    Given no hay barcos en posicion (1,8)
    When disparo a la posicion (1,8)
    Then el disparo dio en el agua