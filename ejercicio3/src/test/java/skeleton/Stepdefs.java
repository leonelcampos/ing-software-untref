
package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private BatallaNaval batallaNaval;
	private boolean resultadoPosicionamiento; 
	
	@Given("^posicion \\((\\d+),(\\d+)\\) esta libre y posicion \\((\\d+),(\\d+)\\) esta libre$")
	public void posicion_esta_libre_y_posicion_esta_libre(int pos1X, int pos1Y, int pos2X, int pos2Y) throws Throwable {
		batallaNaval = new BatallaNaval();
		
		Assert.assertTrue(batallaNaval.laPosicionEstaLibre(pos1X, pos1Y));
		Assert.assertTrue(batallaNaval.laPosicionEstaLibre(pos2X, pos2Y));
	}

	@When("^jugador posiciona un \"(.*?)\" en la posicion \\((\\d+),(\\d+)\\) \"(.*?)\"$")
	public void jugador_posiciona_un_en_la_posicion(String tipoDeBarco, int posX, int posY, String posicionamiento) throws Throwable {
		resultadoPosicionamiento = batallaNaval.ubicarBarcoEn(tipoDeBarco, posX, posY, posicionamiento);
	}


	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente() throws Throwable {
		Assert.assertTrue(resultadoPosicionamiento);
	}
	
	@Given("^hay un barco en posicion \\((\\d+),(\\d+)\\)$")
	public void hay_un_barco_en_posicion(int posX, int posY) throws Throwable {
		batallaNaval = new BatallaNaval();
		resultadoPosicionamiento = batallaNaval.ubicarBarcoEn("LANCHA", posX, posY, "VERTICAL");
	}

	@Then("^posicion ocupada no se puede ubicar el barco alli$")
	public void posicion_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
		Assert.assertFalse(resultadoPosicionamiento);
	}

	

}

