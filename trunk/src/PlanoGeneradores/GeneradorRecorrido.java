package PlanoGeneradores;

import ConstruccionGeneral.Posicion;
import PlanoDireccion.Direccion;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public abstract class GeneradorRecorrido {

	public abstract Recorrido gerenerarRecorrido(Plano plano, Posicion posicionBorde,
			Direccion direccion);

}
