package untref.barcos.factory;

import untref.barcos.Barco;
import untref.barcos.Lancha;

public class LanchaFactory implements BarcoFactory{
	
	@Override
	public Barco construir() {
		return new Lancha();
	}
}
