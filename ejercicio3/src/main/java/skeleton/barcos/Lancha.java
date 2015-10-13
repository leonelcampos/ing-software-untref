package skeleton.barcos;


public class Lancha implements Barco{

	private int tamanio; 
	private int posicionesDañadas;
	
	public Lancha(){
		this.tamanio = 1;
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
