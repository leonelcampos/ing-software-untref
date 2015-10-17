package untref.barcos.factory;

import untref.barcos.Barco;
import untref.barcos.Destructor;

public class DestructorFactory implements BarcoFactory{
	
	@Override
	public Barco construir() {
		return new Destructor();
	}
}
