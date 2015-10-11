package skeleton.barcos;

public class Destructor implements Barco{

	private int tamanio; 
	
	public Destructor(){
		this.tamanio = 3;
	}
	
	public int getTamanio() {
		return this.tamanio;
	}

}
