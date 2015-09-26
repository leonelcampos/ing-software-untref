Feature: Juego Piedra Papel Tijera

  Scenario: Piedra vs Papel
    Given jugador1 juega PIEDRA
    When jugador2 juega PAPEL
    Then gana jugador2
