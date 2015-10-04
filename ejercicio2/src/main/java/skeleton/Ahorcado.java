package skeleton;

public class Ahorcado {
	
	private String palabraSecreta;
	
	private AhorcadoState estado;
	
	public Ahorcado(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		this.estado = new Activo(palabraSecreta);
	}

	public void arriesgarLetra(String letra) {
		estado.arriesgarLetra(this, letra);
		
		evaluarEstado();
	}

	private void evaluarEstado() {
		if(estado.getEstadoPalabra().equals(palabraSecreta) || estado.getVidas() == 0){
			
			estado = new Terminado(palabraSecreta , estado.getEstadoPalabra(), estado.getVidas());
		}
	}
	
	public String getEstadoPalabra(){
		return estado.getEstadoPalabra();
	}
	
	public int getVidas(){
		return estado.getVidas();
	}
	
	public String getEstado(){
		return estado.getEstado();
	}
}
