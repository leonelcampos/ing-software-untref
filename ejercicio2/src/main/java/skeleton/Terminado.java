package skeleton;

public class Terminado implements AhorcadoState{
	
	private String estadoPalabra;
	
	private String palabraSecreta;
	
	private int vidas; 
	
	public Terminado(String palabraSecreta, String estadoPalabra, int vidas){
		this.estadoPalabra = estadoPalabra;
		this.palabraSecreta = palabraSecreta;
		this.vidas = vidas;
	}

	public void arriesgarLetra(Ahorcado ahorcado, String letra) {
		if(vidas > 0){
			System.out.println("El juego ha terminado. Has ganado!");
			System.out.println("La palabra secreta era "+palabraSecreta );
		}else{
			System.out.println("El juego ha terminado. Has perdido!");
			System.out.println("La palabra secreta era "+palabraSecreta );
		}
	}

	public String getEstadoPalabra() {
		return estadoPalabra;
	}

	public int getVidas() {
		return vidas;
	}

}
