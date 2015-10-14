package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsDispararBarcos {
	
	private BatallaNaval batallaNaval;
	private boolean resultadoDelDisparo; 

	@Given("^no hay barcos en posicion \\((\\d+),(\\d+)\\)$")
	public void no_hay_barcos_en_posicion(int posX, int posY) throws Throwable {
		batallaNaval = new BatallaNaval();
		Assert.assertTrue(batallaNaval.laPosicionEstaLibre(posX, posY));
	}

	@When("^disparo a la posicion \\((\\d+),(\\d+)\\)$")
	public void disparo_a_la_posicion(int posX, int posY) throws Throwable {
	    resultadoDelDisparo = batallaNaval.dispararEnLaPosicion(posX, posY);
	}
	
	@Given("^Existe un barco en posicion \\((\\d+),(\\d+)\\)$")
	public void existe_un_barco_en_posicion(int posX, int posY) throws Throwable {
		batallaNaval = new BatallaNaval();
		System.out.println(posX+posY);
		boolean resultadoPosicionamiento = batallaNaval.ubicarBarcoEn("LANCHA", posX, posY, "VERTICAL");
		Assert.assertTrue(resultadoPosicionamiento);
	}
	
	@Then("^el disparo dio en el agua$")
	public void el_disparo_dio_en_el_agua() throws Throwable {
		Assert.assertFalse(resultadoDelDisparo);
	}
	
	@Then("^el disparo dio en el blanco$")
	public void el_disparo_dio_en_el_blanco() throws Throwable {
		Assert.assertTrue(resultadoDelDisparo);
	}
	
	@Then("^el barco desaparece de la posicion \\((\\d+),(\\d+)\\)$")
	public void el_barco_desaparece_de_la_posicion(int posX, int posY) throws Throwable {
		Assert.assertTrue(batallaNaval.laPosicionEstaLibre(posX, posY));
	}
}
