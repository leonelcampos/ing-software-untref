package untref.posicion;


public class PosicionTablero {
	
	private int posicionX;
	
	private int posicionY;
	
	public PosicionTablero(int posicionX, int posicionY){
		
		this.posicionX = posicionX;
		
		this.posicionY = posicionY;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}
	
	public boolean equals(Object a) {
		boolean respuesta= false;
		if(a instanceof PosicionTablero){
			PosicionTablero posicionTablero = (PosicionTablero) a; 
			if(posicionTablero.getPosicionX() == this.getPosicionX() && posicionTablero.getPosicionY() == this.getPosicionY()){
				respuesta= true;
			};
		}
		return respuesta;
	}
	
}
