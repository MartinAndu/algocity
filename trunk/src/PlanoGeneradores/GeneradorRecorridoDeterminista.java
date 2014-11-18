package PlanoGeneradores;

import Edificios.Posicion;
import PlanoDireccion.Direccion;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class GeneradorRecorridoDeterminista extends GeneradorRecorrido {

	@Override
	public Recorrido gerenerarRecorrido(Plano plano, Posicion posicion,
			Direccion direccion) {
		
		return plano.recorrerEnZigZag(posicion, direccion);
	}

}
