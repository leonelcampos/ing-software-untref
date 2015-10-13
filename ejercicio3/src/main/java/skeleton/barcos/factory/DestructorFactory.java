package skeleton.barcos.factory;

import skeleton.barcos.Barco;
import skeleton.barcos.Destructor;

public class DestructorFactory implements BarcoFactory{
	
	@Override
	public Barco construir() {
		return new Destructor();
	}
}
