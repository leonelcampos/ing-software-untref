package untref.barcos;

import java.util.HashMap;
import java.util.Map;

import untref.barcos.factory.AcorazadoFactory;
import untref.barcos.factory.BarcoFactory;
import untref.barcos.factory.DestructorFactory;
import untref.barcos.factory.LanchaFactory;

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