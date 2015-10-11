package skeleton.barcos.factory;

import java.util.HashMap;
import java.util.Map;

import skeleton.barcos.Acorazado;
import skeleton.barcos.Barco;
import skeleton.barcos.Destructor;
import skeleton.barcos.Lancha;
import skeleton.barcos.TipoBarcos;

public class FabricaBarcos {
	
	private Map<TipoBarcos, Barco> barcosPorTipo; 
	
	public FabricaBarcos(){
		
		barcosPorTipo = new HashMap<TipoBarcos, Barco>();
		
		barcosPorTipo.put(TipoBarcos.DESTRUCTOR, new Destructor());
		barcosPorTipo.put(TipoBarcos.ACORAZADO, new Acorazado());
		barcosPorTipo.put(TipoBarcos.LANCHA, new Lancha());
	}
	
	public Barco obtenerBarco(TipoBarcos tipoBarco){
		return barcosPorTipo.get(tipoBarco);
	}
}
