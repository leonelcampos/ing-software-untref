package skeleton;

import skeleton.barcos.Barco;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class Tablero {

	private Integer tablero[][];

	public Tablero() {
		tablero = new Integer[10][10];
		inicializarTablero();
	}

	private void inicializarTablero() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = 0;
			}
		}
	}

	public boolean posicionarBarco(PosicionTablero posicionInicio, PosicionTablero posicionFinal, TipoPosicionamiento tipoPosicionamiento,
			Barco barco) {

		boolean posicionamientoExitoso = true;

		posicionamientoExitoso = validarPosicionamientoExitoso(posicionInicio, posicionFinal);

		return posicionamientoExitoso;
	}

	private boolean validarPosicionamientoExitoso(PosicionTablero posicionInicio, PosicionTablero posicionFin) {

		for (int i = posicionInicio.getPosicionX() - 1; i < posicionFin.getPosicionX(); i++) {
			for (int j = posicionInicio.getPosicionY() - 1; j < posicionFin.getPosicionY(); j++) {

				if (tablero[i][j] == 0) {
					tablero[i][j] = 1;

				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean posicionLibre(PosicionTablero posicion) {
		
		if(tablero[posicion.getPosicionX()][posicion.getPosicionY()] == 0){
			return true;
		}else{
			return false;
		}
	}

}