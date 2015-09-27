package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private Mano manoJugador1; 
	private Mano manoJugador2; 

	//Scenario: Piedra vs Papel
	@Given("^jugador1 juega PIEDRA$")
	public void jugador1_juega_PIEDRA() throws Throwable {
		manoJugador1 = new Piedra(1);
	}

	@When("^jugador2 juega PAPEL$")
	public void jugador2_juega_PAPEL() throws Throwable {
		manoJugador2 = new Papel(2);
	}

	@Then("^gana jugador(\\d+)$")
	public void gana_jugador(int numeroDeJugador) throws Throwable {
		Assert.assertEquals(numeroDeJugador, manoJugador1.compararCon(manoJugador2));
	}
	
	
	// Scenario: Piedra vs Piedra
	
	@When("^jugador2 juega PIEDRA$")
	public void jugador2_juega_PIEDRA() throws Throwable {
		manoJugador2 = new Piedra(2);
	}
	
	@Then("^hay empate$")
	public void hay_empate() throws Throwable {
		Assert.assertEquals(0, manoJugador1.compararCon(manoJugador2));
	}

	//Scenario: Piedra vs Tijera
	@When("^jugador2 juega TIJERA$")
	public void jugador2_juega_TIJERA() throws Throwable {
		manoJugador2 = new Tijera(2);
	}

}
