
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
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicio, TipoPosicionamiento.VERTICAL, destructor);
		
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
		
		tablero.posicionarBarco(posicionInicioDestructor, TipoPosicionamiento.VERTICAL, destructor);
		
		Barco acorazado = creadorBarcos.obtenerBarco(TipoBarcos.ACORAZADO);
		PosicionTablero posicionInicioAcorazado = new PosicionTablero(2, 2);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioAcorazado, TipoPosicionamiento.VERTICAL, acorazado);
		
		Assert.assertFalse(resultadoPosicionamiento);
	}
	
	
	@Test
	public void cuandoPosicionoUnBarcoCuyaCoordenadaIntermediaEstaOcupadaEntoncesElBarcoNoSeGudarda(){
		
		Tablero tablero = new Tablero();
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco lancha = creadorBarcos.obtenerBarco(TipoBarcos.LANCHA);
		PosicionTablero posicionInicioLancha = new PosicionTablero(2, 4);
		
		tablero.posicionarBarco(posicionInicioLancha, TipoPosicionamiento.VERTICAL, lancha);
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(2, 3);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioDestructor, TipoPosicionamiento.VERTICAL, destructor);
		
		Assert.assertFalse(resultadoPosicionamiento);
	}
	
	@Test
	public void cuandoPosicionoUnBarcoEnUnaCoordenadaFueraDelTableroEntoncesElBarcoNoSeGudarda(){
		
		Tablero tablero = new Tablero();
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(11, 2);
		
		boolean resultadoPosicionamiento = tablero.posicionarBarco(posicionInicioDestructor, TipoPosicionamiento.HORIZONTAL, destructor);
		
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
		
		tablero.posicionarBarco(posicionInicioDestructor, TipoPosicionamiento.HORIZONTAL, destructor);
		
		PosicionTablero posicionDeDisparo = new PosicionTablero(4,2);
		boolean resultadoDisparo = tablero.dispararEnPosicion(posicionDeDisparo);
		
		Assert.assertTrue(resultadoDisparo);
		Assert.assertEquals(1, destructor.posicionesDañadas());
	}
	
	@Test
	public void cuandoDisparoAUnaPosicionOcupadaPorUnBarcoEntoncesLaPosicionSigueOcupada(){
		Tablero tablero = new Tablero();
		
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco destructor = creadorBarcos.obtenerBarco(TipoBarcos.DESTRUCTOR);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(4, 2);

		tablero.posicionarBarco(posicionInicioDestructor, TipoPosicionamiento.HORIZONTAL, destructor);
		
		PosicionTablero posicionDeDisparo = new PosicionTablero(4,2);
		tablero.dispararEnPosicion(posicionDeDisparo);
		
		Assert.assertFalse(tablero.posicionLibre(posicionDeDisparo));
	}

	
	@Test
	public void cuandoDisparoALaUltimaPosicionNoDaniadDeUnBarcoEntoncesEsEliminadoYBorradoDelMapa(){
		Tablero tablero = new Tablero();
		
		CreadorBarcos creadorBarcos = new CreadorBarcos();
		
		Barco acorazado = creadorBarcos.obtenerBarco(TipoBarcos.ACORAZADO);
		PosicionTablero posicionInicioDestructor = new PosicionTablero(4, 2);
		
		tablero.posicionarBarco(posicionInicioDestructor, TipoPosicionamiento.HORIZONTAL, acorazado);
		
		PosicionTablero posicionDeDisparo1 = new PosicionTablero(4,2);
		tablero.dispararEnPosicion(posicionDeDisparo1);
		
		PosicionTablero posicionDeDisparo2 = new PosicionTablero(5,2);
		tablero.dispararEnPosicion(posicionDeDisparo2);
		
		Assert.assertTrue(tablero.posicionLibre(posicionDeDisparo1));
		Assert.assertTrue(tablero.posicionLibre(posicionDeDisparo2));
	}

}

