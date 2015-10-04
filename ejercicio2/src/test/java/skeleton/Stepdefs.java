package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private static final String LETRA_PARA_ERRAR = "*";
	private Ahorcado ahorcado;
	
	@Given("^la palabra secreta es \"(.*?)\"$")
	public void la_palabra_secreta_es(String palabraSecreta) throws Throwable {
		ahorcado = new Ahorcado(palabraSecreta);
	}
	
	@Given("^tengo (\\d+) vidas$")
	public void tengo_vidas(int vidas) throws Throwable {
		int cantidadDeVecesAErrar = ahorcado.getVidas() - vidas;
		
		errarLetra(cantidadDeVecesAErrar);
		
		Assert.assertEquals(vidas, ahorcado.getVidas());
	}

	private void errarLetra(int cantidadDeVecesAErrar) {
		
		for(int i = 0; i < cantidadDeVecesAErrar; i++){
			ahorcado.arriesgarLetra(LETRA_PARA_ERRAR);
		}
	}
	
	@Given("^estado actual es \"(.*?)\"$")
	public void estado_actual_es(String estado) throws Throwable {
		
		modificarPalabraInicial(estado);
		
		Assert.assertEquals(estado, ahorcado.getEstadoPalabra());
	}

	private void modificarPalabraInicial(String estado) {
		char[] caracteres = estado.toCharArray();
		
		for(int i = 0; i < estado.length(); i++){
			if(caracteres[i] != '*'){
				ahorcado.arriesgarLetra(String.valueOf(caracteres[i]));
			}
		}
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
	
	@Then("^resultado \"(.*?)\"$")
	public void resultado(String resultado) throws Throwable {
		 Assert.assertEquals(resultado, ahorcado.getEstadoJuego());
	}


}
