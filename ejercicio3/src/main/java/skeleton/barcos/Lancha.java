package skeleton.barcos;


public class Lancha implements Barco{

	private int tamanio; 
	
	public Lancha(){
		this.tamanio = 2;
	}
	
	public int getTamanio() {
		return this.tamanio;
	}
}
