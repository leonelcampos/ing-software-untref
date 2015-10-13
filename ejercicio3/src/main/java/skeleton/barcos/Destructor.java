package skeleton.barcos;

public class Destructor implements Barco{

	private int tamanio; 
	private int posicionesDañadas;
	
	public Destructor(){
		this.tamanio = 3;
		this.posicionesDañadas = 0;
	}
	
	public int getTamanio() {
		return this.tamanio;
	}

	@Override
	public int posicionesDañadas() {
		return this.posicionesDañadas;
	}

	@Override
	public void aumentarDaño() {
		if(this.posicionesDañadas < tamanio){
			this.posicionesDañadas++;
		}
	}
}
