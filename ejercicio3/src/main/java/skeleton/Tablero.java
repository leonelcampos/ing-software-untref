package skeleton;

import skeleton.barcos.Barco;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class Tablero {

	private Integer mapa[][];
	
	public Tablero() {
		mapa = new Integer[10][10];
		inicializarTablero();
	}

	private void inicializarTablero() {

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = 0;
			}
		}
	}

	public boolean posicionarBarco(PosicionTablero posicionInicio, PosicionTablero posicionFinal,
			TipoPosicionamiento tipoPosicionamiento, Barco barco) {

		boolean coordenadasValidas = validarCoordenadas(posicionInicio, posicionFinal);
		boolean posicionamientoExitoso = true;
		
		if (coordenadasValidas) {

			posicionamientoExitoso = guardarPosicionBarco(posicionInicio, posicionFinal);
		}
		
		return coordenadasValidas && posicionamientoExitoso;
	}

	private boolean guardarPosicionBarco(PosicionTablero posicionInicio, PosicionTablero posicionFinal) {
		for (int i = posicionInicio.getPosicionX() - 1; i < posicionFinal.getPosicionX(); i++) {
			for (int j = posicionInicio.getPosicionY() - 1; j < posicionFinal.getPosicionY(); j++) {

				if (mapa[i][j] == 0) {
					mapa[i][j] = 1;
					
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean posicionLibre(PosicionTablero posicion) {

		if (mapa[posicion.getPosicionX()-1][posicion.getPosicionY()-1] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean dispararEnPosicion(PosicionTablero posicion){
		if(posicionLibre(posicion)){
			return false; 
		}else{
			return true;
		}
	}

	private boolean validarCoordenadas(PosicionTablero posicionInicio, PosicionTablero posicionFin) {

		if (validarCoordenadasMinimas(posicionInicio, posicionFin)
				|| validarCoordenadasMaximas(posicionInicio, posicionFin)) {

			return false;
		}
		return true;
	}

	private boolean validarCoordenadasMaximas(PosicionTablero posicionInicio, PosicionTablero posicionFin) {
		return posicionInicio.getPosicionX() > 10 || posicionInicio.getPosicionY() > 10
				|| posicionFin.getPosicionX() > 10 || posicionFin.getPosicionY() > 10;
	}

	private boolean validarCoordenadasMinimas(PosicionTablero posicionInicio, PosicionTablero posicionFin) {
		return posicionInicio.getPosicionX() < 1 || posicionInicio.getPosicionY() < 1 || posicionFin.getPosicionX() < 1
				|| posicionFin.getPosicionY() < 1;
	}
}
