package PlanoGeneral;

import PlanoGeneradores.GeneradorDireccionDeterminista;
import PlanoGeneradores.GeneradorPosicionDeterminista;
import PlanoGeneradores.GeneradorRecorridoDeterminista;
import SuperficiesGeneradores.GeneradorSuperficieDeterminista;

public class PlanoDeterminista extends Plano{

	public PlanoDeterminista(int dimensionN, int dimensionM) {
		super();
		this.generadorDireccion = new GeneradorDireccionDeterminista();
		this.generadorPosicion = new GeneradorPosicionDeterminista(dimensionN, dimensionM);
		this.generadorRecorrido = new GeneradorRecorridoDeterminista();
		this.generadorSuperficies = new GeneradorSuperficieDeterminista();
		this.construirPlano(dimensionN, dimensionM);
		
	}

}
