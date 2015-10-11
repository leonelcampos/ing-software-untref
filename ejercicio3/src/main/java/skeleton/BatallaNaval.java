package skeleton;

import skeleton.barcos.Barco;
import skeleton.barcos.TipoBarcos;
import skeleton.barcos.factory.FabricaBarcos;
import skeleton.posicion.PosicionTablero;
import skeleton.posicion.TipoPosicionamiento;

public class BatallaNaval {
	
	private Tablero tablero;
	private FabricaBarcos fabricaBarcos;
	
	public BatallaNaval() {
		this.tablero = new Tablero();
		this.fabricaBarcos = new FabricaBarcos();
	}
	
	public boolean ubicarBarcoEn(String tipoBarco,int posX, int posY, String tipoPosicionamiento){
		
		Barco barco = fabricaBarcos.obtenerBarco(TipoBarcos.valueOf(tipoBarco.toUpperCase()));
		TipoPosicionamiento posicionamiento = TipoPosicionamiento.valueOf(tipoPosicionamiento.toUpperCase());
		
		PosicionTablero posicionInicial = new PosicionTablero(posX, posY);
		PosicionTablero posicionFinal = generarPosicionFin(posicionInicial, posicionamiento, barco);
		
		return tablero.posicionarBarco(posicionInicial, posicionFinal, posicionamiento, barco);
	}
	
	private PosicionTablero generarPosicionFin(PosicionTablero posicionInicio, TipoPosicionamiento tipoPosicionamiento,
			Barco barco) {

		PosicionTablero posicionFin;

		if (tipoPosicionamiento.equals(TipoPosicionamiento.HORIZONTAL)) {
			posicionFin = new PosicionTablero(posicionInicio.getPosicionX() + barco.getTamanio(),
					posicionInicio.getPosicionY());
		} else {
			posicionFin = new PosicionTablero(posicionInicio.getPosicionX(),
					posicionInicio.getPosicionY() + barco.getTamanio());
		}
		return posicionFin;
	}
	
	public boolean laPosicionEstaLibre(int posX, int posY){
		PosicionTablero posicion = new PosicionTablero(posX, posY);
		
		return tablero.posicionLibre(posicion);
	}
	
}
