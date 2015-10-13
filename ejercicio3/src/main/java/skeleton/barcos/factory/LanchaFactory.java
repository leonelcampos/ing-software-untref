package skeleton.barcos.factory;

import skeleton.barcos.Barco;
import skeleton.barcos.Lancha;

public class LanchaFactory implements BarcoFactory{
	
	@Override
	public Barco construir() {
		return new Lancha();
	}
}
