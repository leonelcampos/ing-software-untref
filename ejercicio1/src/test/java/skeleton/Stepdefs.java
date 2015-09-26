package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

	@Given("^jugador(\\d+) juega PIEDRA$")
	public void jugador_juega_PIEDRA(int arg1) throws Throwable {
	}

	@When("^jugador(\\d+) juega PAPEL$")
	public void jugador_juega_PAPEL(int arg1) throws Throwable {
	}

	@Then("^gana jugador(\\d+)$")
	public void gana_jugador(int arg1) throws Throwable {
	}

}
