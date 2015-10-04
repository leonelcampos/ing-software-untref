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
		int posicionLetraEnPalabraSecreta = palabraSecreta.indexOf(letra);
		
		if(existeLetraEnPalabraSecreta(posicionLetraEnPalabraSecreta)){
				
			modificarEstadoPalabra(posicionLetraEnPalabraSecreta, letra.toLowerCase());
		}else{
			decrementarVidas();
		}
	}

	private void decrementarVidas() {
		if(vidas > 0 ){
			vidas--;
		}
	}

	private void modificarEstadoPalabra(int posicionLetraEnPalabraSecreta, String letra) {
		char[] caracteres = palabraSecreta.toCharArray();

		caracteres[posicionLetraEnPalabraSecreta] = letra.charAt(0);

		palabraSecreta = new String(caracteres); 
	}

	private boolean existeLetraEnPalabraSecreta(int posicionLetraEnPalabraSecreta) {
		return posicionLetraEnPalabraSecreta > -1;
	}

	public int getVidas() {
		return vidas;
	}

}
