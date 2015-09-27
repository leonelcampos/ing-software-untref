package skeleton;

public class Papel implements Mano{

	private int numeroDeJugador;
	
	public Papel(int numeroDeJugador) {
		this.numeroDeJugador = numeroDeJugador;
	}

	@Override
	public int compararCon(Mano mano) {
		return mano.compararConPapel(this);
	}

	@Override
	public int compararConPiedra(Mano mano) {
		return this.numeroDeJugador;
	}

	@Override
	public int compararConPapel(Mano mano) {
		return 0;
	}

	@Override
	public int getNumeroDeJugador() {
		return numeroDeJugador;
	}

	@Override
	public int compararConTijera(Mano mano) {
		return mano.getNumeroDeJugador();
	}

}
