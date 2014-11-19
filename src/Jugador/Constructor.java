package Jugador;

import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Excepciones.ExcepcionDineroInsuficiente;
import PlanoGeneral.Plano;

public class Constructor {
	 // Estas instanciaciones estan mal, son cosas que se van a obtener del Jugador que tiene el constructor, pero por ahora hago esto.
	Plano miPlano = new Plano(10,10);
	Presupuesto miPresupuesto = new PresupuestoAlto();
	
	public void construirZonaResidencial(Posicion unaPosicion){
		Edificio unResidencial = new EdificioResidencial();
		int costoDeUnResidencial = unResidencial.devolverCosto();
		
		if (!miPresupuesto.alcanzaPara(costoDeUnResidencial)){
			throw new ExcepcionDineroInsuficiente();
		}

		(miPlano.devolverHectarea(unaPosicion)).establecerEdificio(unResidencial);
		
		miPresupuesto.reducirPresupuesto(costoDeUnResidencial);

	}	
		
		
}
