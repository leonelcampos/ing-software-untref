Feature: Juego Piedra Papel Tijera

  Scenario: Piedra vs Papel
    Given jugador1 juega PIEDRA
    When jugador2 juega PAPEL
    Then gana jugador2

  Scenario: Piedra vs Piedra
    Given jugador1 juega PIEDRA
    When jugador2 juega PIEDRA
    Then hay empate

Scenario: Piedra vs Tijera
  Given jugador1 juega PIEDRA
  When jugador2 juega TIJERA
  Then gana jugador1
