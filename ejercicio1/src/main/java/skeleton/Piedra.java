package skeleton;

public class Piedra implements Mano{

	private int numeroDeJugador;
	
	public Piedra(int numeroDeJugador) {
		this.numeroDeJugador = numeroDeJugador;
	}

	@Override
	public int compararCon(Mano mano) {
		return mano.compararConPiedra(this);
	}

	@Override
	public int compararConPiedra(Mano mano) {
		return 0;
	}

	@Override
	public int compararConPapel(Mano mano) {
		return mano.getNumeroDeJugador();
	}

	@Override
	public int getNumeroDeJugador() {
		return numeroDeJugador;
	}

}
