package skeleton;

import skeleton.barcos.Barco;
import skeleton.barcos.CreadorBarcos;
import skeleton.barcos.TipoBarcos;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class BatallaNaval {
	
	private Tablero tablero;
	private CreadorBarcos fabricaBarcos;
	
	public BatallaNaval() {
		this.tablero = new Tablero();
		this.fabricaBarcos = new CreadorBarcos();
	}
	
	public boolean ubicarBarcoEn(String tipoBarco,int posX, int posY, String tipoPosicionamiento){
		
		Barco barco = fabricaBarcos.obtenerBarco(TipoBarcos.valueOf(tipoBarco.toUpperCase()));
		TipoPosicionamiento posicionamiento = TipoPosicionamiento.valueOf(tipoPosicionamiento.toUpperCase());
		
		PosicionTablero posicionInicial = new PosicionTablero(posX, posY);
		
		return tablero.posicionarBarco(posicionInicial, posicionamiento, barco);
	}
	
	public boolean laPosicionEstaLibre(int posX, int posY){
		PosicionTablero posicion = new PosicionTablero(posX, posY);
		
		return tablero.posicionLibre(posicion);
	}

	public boolean dispararEnLaPosicion(int posX, int posY) {
		PosicionTablero posicion = new PosicionTablero(posX, posY);
		
		return tablero.dispararEnPosicion(posicion);
	}
	
}
