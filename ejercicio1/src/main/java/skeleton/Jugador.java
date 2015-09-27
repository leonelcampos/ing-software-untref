package skeleton;

public class Jugador {

	private int id;
	
	private Mano mano;
	
	public Jugador(int id, Mano mano) {
		this.id = id;
		this.mano = mano;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mano getMano() {
		return mano;
	}

	public void setMano(Mano mano) {
		this.mano = mano;
	}
	
	
}
