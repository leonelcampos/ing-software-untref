Feature: Como usuario quiero disparar a los barcos enemigos

  Scenario: Disparo y toco agua
    Given no hay barcos en posicion (1,8)
    When disparo a la posicion (1,8)
    Then el disparo dio en el agua

  Scenario: Disparo y toco un barco pero no lo hundo
    Given hay un barco en posicion (1,8)
    When disparo a la posicion (1,8)
    Then el disparo dio en el blanco

  Scenario: Disparo toco un barco y lo hundo
    Given hay un barco en posicion (1,8)
    When disparo a la posicion (1,8)
    Then el barco desaparece de la posicion (1,8)
