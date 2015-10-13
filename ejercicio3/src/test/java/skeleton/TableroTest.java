
package skeleton;

import org.junit.Assert;
import org.junit.Test;

import skeleton.barcos.Barco;
import skeleton.barcos.CreadorBarcos;
import skeleton.barcos.TipoBarcos;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class TableroTest {
	
	@Test
	public void cuandoPosicionoUnBarcoEnUnaCoordenadaVerticalValidaEntoncesElBarcoSeGudarda(){
		
		Tablero tablero = new Tablero();
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		
		PosicionTablero posicionInicio = new PosicionTablero(2, 2);
		PosicionTablero posicionFinal = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicio, posicionFinal, TipoPosicionamiento.VERTICAL, destructor);
		
		PosicionTablero posicionBarco1 = new PosicionTablero(2, 2);
		PosicionTablero posicionBarco2 = new PosicionTablero(2, 3);
		PosicionTablero posicionBarco3 = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionBarco1 = tablero.posicionLibre(posicionBarco1);
		boolean resultadoPosicionBarco2 = tablero.posicionLibre(posicionBarco2);
		boolean resultadoPosicionBarco3 = tablero.posicionLibre(posicionBarco3);
		
		Assert.assertFalse(resultadoPosicionBarco1);
		Assert.assertFalse(resultadoPosicionBarco2);
		Assert.assertFalse(resultadoPosicionBarco3);
		Assert.assertTrue(resultadoPosicionamiento);
	}
	
	@Test
	public void cuandoPosicionoUnBarcoEnUnaCoordenadaOcupadaEntoncesElBarcoNoSeGudarda(){
		
		Tablero tablero = new Tablero();
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(2, 2);
		PosicionTablero posicionFinalDestructor = new PosicionTablero(2, 3);
		
		tablero.posicionarBarco(posicionInicioDestructor, posicionFinalDestructor, TipoPosicionamiento.VERTICAL, destructor);
		
		Barco acorazado = creadorBarcos.obtenerBarco(TipoBarcos.ACORAZADO);
		PosicionTablero posicionInicioAcorazado = new PosicionTablero(2, 2);
		PosicionTablero posicionFinalAcorazado = new PosicionTablero(2, 4);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioAcorazado, posicionFinalAcorazado, TipoPosicionamiento.VERTICAL, acorazado);
		
		Assert.assertFalse(resultadoPosicionamiento);
	}
	
	
	@Test
	public void cuandoPosicionoUnBarcoCuyaCoordenadaIntermediaEstaOcupadaEntoncesElBarcoNoSeGudarda(){
		
		Tablero tablero = new Tablero();
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco lancha = creadorBarcos.obtenerBarco(TipoBarcos.LANCHA);
		PosicionTablero posicionInicioLancha = new PosicionTablero(2, 4);
		PosicionTablero posicionFinalLancha = new PosicionTablero(2, 4);
		
		tablero.posicionarBarco(posicionInicioLancha, posicionFinalLancha, TipoPosicionamiento.VERTICAL, lancha);
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(2, 3);
		PosicionTablero posicionFinalDestructor = new PosicionTablero(2, 5);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioDestructor, posicionFinalDestructor, TipoPosicionamiento.VERTICAL, destructor);
		
		Assert.assertFalse(resultadoPosicionamiento);
	}
	
	@Test
	public void cuandoPosicionoUnBarcoEnUnaCoordenadaFueraDelTableroEntoncesElBarcoNoSeGudarda(){
		
		Tablero tablero = new Tablero();
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(11, 2);
		PosicionTablero posicionFinalDestructor = new PosicionTablero(11, 4);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioDestructor, posicionFinalDestructor, TipoPosicionamiento.HORIZONTAL, destructor);
		
		Assert.assertFalse(resultadoPosicionamiento);
	}
	
	@Test
	public void cuandoDisparoAUnaPosicionLibreEntoncesElDisparoFueFallido(){
		Tablero tablero = new Tablero();
		
		PosicionTablero posicionDeDisparo = new PosicionTablero(8,2);
		
		boolean resultadoDisparo = tablero.dispararEnPosicion(posicionDeDisparo);
		
		Assert.assertFalse(resultadoDisparo);
	}
	
	@Test
	public void cuandoDisparoAUnaPosicionOcupadaPorUnBarcoEntoncesElBarcoSufreUnPuntoDeDaño(){
		Tablero tablero = new Tablero();
		
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(4, 2);
		PosicionTablero posicionFinalDestructor = new PosicionTablero(6, 2);
		
		tablero.posicionarBarco(posicionInicioDestructor, posicionFinalDestructor, TipoPosicionamiento.HORIZONTAL, destructor);
		
		PosicionTablero posicionDeDisparo = new PosicionTablero(4,2);
		boolean resultadoDisparo = tablero.dispararEnPosicion(posicionDeDisparo);
		
		Assert.assertTrue(resultadoDisparo);
		Assert.assertEquals(1, destructor.posicionesDañadas());
	}

}

