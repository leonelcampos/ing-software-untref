package skeleton;

import org.junit.Assert;
import org.junit.Test;

import skeleton.barcos.Barco;
import skeleton.barcos.Destructor;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class TableroTest {
	
	@Test
	public void CuandoPosicionoUnBarcoEnUnaCoordenadaVerticalValidaEntoncesElBarcoSeGudarda(){
		
		Tablero tablero = new Tablero();
		
		Barco destructor = new Destructor();
		
		PosicionTablero posicionInicio = new PosicionTablero(2, 2);
		PosicionTablero posicionFinal = new PosicionTablero(2, 4);
		
		boolean resultadoBarcoGuardado = tablero.posicionarBarco(posicionInicio, posicionFinal, TipoPosicionamiento.VERTICAL, destructor);
		
		PosicionTablero posicionBarco1 = new PosicionTablero(2, 2);
		PosicionTablero posicionBarco2 = new PosicionTablero(2, 3);
		PosicionTablero posicionBarco3 = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionBarco1 = tablero.posicionLibre(posicionBarco1);
		boolean resultadoPosicionBarco2 = tablero.posicionLibre(posicionBarco2);
		boolean resultadoPosicionBarco3 = tablero.posicionLibre(posicionBarco3);
		
		Assert.assertTrue(resultadoPosicionBarco1);
		Assert.assertTrue(resultadoPosicionBarco2);
		Assert.assertTrue(resultadoPosicionBarco3);
		Assert.assertTrue(resultadoBarcoGuardado);
	}
}
