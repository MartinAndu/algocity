package PlanoGeneradores;

import ConstruccionGeneral.Posicion;
import PlanoDireccion.Direccion;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class GeneradorRecorridoAleatorio extends GeneradorRecorrido {

	@Override
	public Recorrido gerenerarRecorrido(Plano plano, Posicion posicionBorde,
			Direccion direccion) {
		
		int numeroAleatorio = (int)(Math.random() * 10 + 1); 
		
		if (numeroAleatorio <= 10) {
			return plano.recorrerLinealmente(posicionBorde, direccion);
			
		}
		return plano.recorrerEnZigZag(posicionBorde, direccion);
	}

}
