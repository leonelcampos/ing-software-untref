package skeleton.barcos.factory;

import skeleton.barcos.Acorazado;
import skeleton.barcos.Barco;

public class AcorazadoFactory implements BarcoFactory{
	
	public Barco construir() {
		return new Acorazado();
	}
}
