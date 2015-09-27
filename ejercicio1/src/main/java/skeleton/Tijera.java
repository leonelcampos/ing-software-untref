package skeleton;

public class Tijera implements Mano{
	
	private int numeroDeJugador;
	

	public Tijera(int numeroDeJugador) {
		this.numeroDeJugador = numeroDeJugador;
	}

	@Override
	public int compararCon(Mano mano) {
		return mano.compararCon(this);
	}

	@Override
	public int compararConPiedra(Mano mano) {
		return mano.getNumeroDeJugador();
	}

	@Override
	public int compararConPapel(Mano mano) {
		return numeroDeJugador;
	}

	@Override
	public int getNumeroDeJugador() {
		return numeroDeJugador;
	}

}
