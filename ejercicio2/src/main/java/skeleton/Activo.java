package skeleton;

public class Activo implements AhorcadoState{
	
	private String palabraSecreta;
	
	private String estadoPalabra;
	
	private int vidas;
	
	public Activo(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta.toLowerCase();
		this.estadoPalabra = generarEstadoPalabraInicial();
		this.vidas = 7;
	}

	private String generarEstadoPalabraInicial() {
		estadoPalabra = "*";
		for (int i = 0; i< palabraSecreta.length()-1; i++) {
			estadoPalabra += "*";
		}
		return estadoPalabra;
	}

	public String getEstadoPalabra() {
		return estadoPalabra;
	}
	
	public void arriesgarLetra(Ahorcado ahorcado, String letra){
		if(palabraSecreta.contains(letra.toLowerCase())){
				
			modificarEstadoPalabra(letra.toLowerCase());
		}else{
			decrementarVidas();
		}
	}

	private void decrementarVidas() {
		if(vidas > 0 ){
			vidas--;
		}
	}

	private void modificarEstadoPalabra(String letra) {
		char[] caracteres = estadoPalabra.toCharArray();
		
		for (int i = 0; i< palabraSecreta.length(); i++) {
			if(palabraSecreta.charAt(i) == letra.charAt(0)){
				caracteres[i] = letra.charAt(0);
			}
		}
		
		estadoPalabra = new String(caracteres); 
	}

	public int getVidas() {
		return vidas;
	}

	public String getEstado() {
		return "Sigo vivo";
	}

}
