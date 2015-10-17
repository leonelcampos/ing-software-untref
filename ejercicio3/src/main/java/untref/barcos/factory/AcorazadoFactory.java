package untref.barcos.factory;

import untref.barcos.Acorazado;
import untref.barcos.Barco;

public class AcorazadoFactory implements BarcoFactory{
	
	public Barco construir() {
		return new Acorazado();
	}
}
