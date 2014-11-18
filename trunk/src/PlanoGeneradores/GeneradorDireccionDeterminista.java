package PlanoGeneradores;

import PlanoDireccion.Direccion;
import PlanoDireccion.NorEste;


public class GeneradorDireccionDeterminista extends GeneradorDireccion {

	@Override
	public Direccion generarDireccion() {
		
		return new NorEste();
	}

}
