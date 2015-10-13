package skeleton.barcos;

import java.util.HashMap;
import java.util.Map;

import skeleton.barcos.factory.AcorazadoFactory;
import skeleton.barcos.factory.BarcoFactory;
import skeleton.barcos.factory.DestructorFactory;
import skeleton.barcos.factory.LanchaFactory;

public class CreadorBarcos {
	
	private Map<TipoBarcos, BarcoFactory> barcosPorTipo; 
	
	public CreadorBarcos(){
		
		barcosPorTipo = new HashMap<TipoBarcos, BarcoFactory>();
		
		barcosPorTipo.put(TipoBarcos.DESTRUCTOR, new DestructorFactory());
		barcosPorTipo.put(TipoBarcos.ACORAZADO, new AcorazadoFactory());
		barcosPorTipo.put(TipoBarcos.LANCHA, new LanchaFactory());
	}
	
	public Barco obtenerBarco(TipoBarcos tipoBarco){
		return barcosPorTipo.get(tipoBarco).construir();
	}
}