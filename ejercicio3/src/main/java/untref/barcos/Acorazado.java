package untref.barcos;

public class Acorazado implements Barco{

	private int tamanio; 
	private int posicionesDañadas;
	
	public Acorazado(){
		this.tamanio = 2;
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
