
package untref;

import org.junit.Assert;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import untref.BatallaNaval;

public class StepdefsBatallaNaval {
	
	private BatallaNaval batallaNaval;
	private boolean resultadoPosicionamiento; 
	private boolean resultadoDelDisparo; 
	
	@Given("^posicion \\((\\d+),(\\d+)\\) esta libre y posicion \\((\\d+),(\\d+)\\) esta libre$")
	public void posicion_esta_libre_y_posicion_esta_libre(int pos1X, int pos1Y, int pos2X, int pos2Y){
		batallaNaval = new BatallaNaval();
		
		Assert.assertTrue(batallaNaval.laPosicionEstaLibre(pos1X, pos1Y));
		Assert.assertTrue(batallaNaval.laPosicionEstaLibre(pos2X, pos2Y));
	}

	@When("^jugador posiciona un \"(.*?)\" en la posicion \\((\\d+),(\\d+)\\) \"(.*?)\"$")
	public void jugador_posiciona_un_en_la_posicion(String tipoDeBarco, int posX, int posY, String posicionamiento){
		resultadoPosicionamiento = batallaNaval.ubicarBarcoEn(tipoDeBarco, posX, posY, posicionamiento);
	}

	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente(){
		Assert.assertTrue(resultadoPosicionamiento);
	}
	
	@Given("^hay un barco en posicion \\((\\d+),(\\d+)\\)$")
	public void hay_un_barco_en_posicion(int posX, int posY) {
		batallaNaval = new BatallaNaval();
		resultadoPosicionamiento = batallaNaval.ubicarBarcoEn("LANCHA", posX, posY, "VERTICAL");
	}

	@Then("^posicion ocupada no se puede ubicar el barco alli$")
	public void posicion_ocupada_no_se_puede_ubicar_el_barco_alli(){
		acertarPosicionamientoErroneo();
	}
	
	@Given("^tablero es de 10x10$")
	public void tablero_es_de_x() {
		batallaNaval = new BatallaNaval();
	}

	@Then("^la posicion elegida no pertenece al tablero$")
	public void la_posicion_elegida_no_pertenece_al_tablero(){
		acertarPosicionamientoErroneo();
	}
	
	@Then("^la posicion elegida para el barco sobrepasa los limites del tablero$")
	public void la_posicion_elegida_para_el_barco_sobrepasa_los_limites_del_tablero(){
		acertarPosicionamientoErroneo();
	}
	
	private void acertarPosicionamientoErroneo() {
		Assert.assertFalse(resultadoPosicionamiento);
	}
	
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

