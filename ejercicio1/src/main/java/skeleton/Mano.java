package skeleton;

public interface Mano {

	int compararCon(Mano mano);

	int compararConPiedra(Mano mano);

	int compararConPapel(Mano mano);
	
	int getNumeroDeJugador();

}
