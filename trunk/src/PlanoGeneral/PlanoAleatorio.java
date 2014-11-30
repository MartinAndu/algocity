package PlanoGeneral;

import PlanoGeneradores.GeneradorDireccionAleatorio;
import PlanoGeneradores.GeneradorPosicionAleatorio;
import PlanoGeneradores.GeneradorRecorridoAleatorio;
import SuperficiesGeneradores.GeneradorSuperficieAleatoria;


public class PlanoAleatorio extends Plano {

	public PlanoAleatorio(int dimensionN, int dimensionM) {
		super();
		this.generadorDireccion = new GeneradorDireccionAleatorio();
		this.generadorPosicion = new GeneradorPosicionAleatorio(dimensionN, dimensionM);
		this.generadorRecorrido = new GeneradorRecorridoAleatorio();
		this.generadorSuperficies = new GeneradorSuperficieAleatoria();
		this.construirPlano(dimensionN, dimensionM);

	}

}
