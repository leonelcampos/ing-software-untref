package skeleton.barcos;

public class Acorazado implements Barco{

	private int tamanio; 
	
	public Acorazado(){
		this.tamanio = 2;
	}
	
	public int getTamanio() {
		return this.tamanio;
	}

}
