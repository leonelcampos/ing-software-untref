package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private Ahorcado ahorcado;
	
	@Given("^la palabra secreta es \"(.*?)\"$")
	public void la_palabra_secreta_es(String palabraSecreta) throws Throwable {
		ahorcado = new Ahorcado(palabraSecreta);
	}
	
	@Given("^tengo (\\d+) vidas$")
	public void tengo_vidas(int vidas) throws Throwable {
		 Assert.assertEquals(7, ahorcado.getVidas());
	}

	@When("^arriesgo \"(.*?)\"$")
	public void arriesgo(String letra) throws Throwable {
		ahorcado.arriesgarLetra(letra);
	}

	@Then("^estado es \"(.*?)\"$")
	public void estado_es(String estadoPalabra) throws Throwable {
	    Assert.assertEquals(estadoPalabra, ahorcado.getEstadoPalabra());
	}

	@Then("^me quedan (\\d+) vidas$")
	public void me_quedan_vidas(int vidas) throws Throwable {
	    Assert.assertEquals(vidas, ahorcado.getVidas());
	}
}
