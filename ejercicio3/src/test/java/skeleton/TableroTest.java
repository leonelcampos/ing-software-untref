
package skeleton;

import org.junit.Assert;
import org.junit.Test;

import skeleton.barcos.Barco;
import skeleton.barcos.TipoBarcos;
import skeleton.barcos.factory.FabricaBarcos;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class TableroTest {
	
	@Test
	public void CuandoPosicionoUnBarcoEnUnaCoordenadaVerticalValidaEntoncesElBarcoSeGudarda(){
		
		Tablero tablero = new Tablero();
		FabricaBarcos fabricaBarcos = new FabricaBarcos();
		
		Barco destructor = fabricaBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		
		PosicionTablero posicionInicio = new PosicionTablero(2, 2);
		PosicionTablero posicionFinal = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicio, posicionFinal, TipoPosicionamiento.VERTICAL, destructor);
		
		PosicionTablero posicionBarco1 = new PosicionTablero(2, 2);
		PosicionTablero posicionBarco2 = new PosicionTablero(2, 3);
		PosicionTablero posicionBarco3 = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionBarco1 = tablero.posicionLibre(posicionBarco1);
		boolean resultadoPosicionBarco2 = tablero.posicionLibre(posicionBarco2);
		boolean resultadoPosicionBarco3 = tablero.posicionLibre(posicionBarco3);
		
		Assert.assertTrue(resultadoPosicionBarco1);
		Assert.assertTrue(resultadoPosicionBarco2);
		Assert.assertTrue(resultadoPosicionBarco3);
		Assert.assertTrue(resultadoPosicionamiento);
	}
	
	@Test
	public void CuandoPosicionoUnBarcoEnUnaCoordenadaOcupadaEntoncesElBarcoNoSeGudarda(){
		
		Tablero tablero = new Tablero();
		FabricaBarcos fabricaBarcos = new FabricaBarcos();
		
		Barco destructor = fabricaBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(2, 2);
		PosicionTablero posicionFinalDestructor = new PosicionTablero(2, 4);
		
		tablero.posicionarBarco(posicionInicioDestructor, posicionFinalDestructor, TipoPosicionamiento.VERTICAL, destructor);
		
		Barco acorazado = fabricaBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioAcorazado = new PosicionTablero(2, 3);
		PosicionTablero posicionFinalAcorazado = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioAcorazado, posicionFinalAcorazado, TipoPosicionamiento.VERTICAL, acorazado);
		
		Assert.assertFalse(resultadoPosicionamiento);
	}
}

