package PlanoGeneradores;

import Edificios.Posicion;
import PlanoGeneral.Plano;

public class GeneradorPosicionDeterminista extends GeneradorPosicion {

	public GeneradorPosicionDeterminista(int dimensionN, int dimensionM) {
		
		super(dimensionN, dimensionM);
	}

	@Override
	public Posicion generarPosicionEnBordePlano(Plano plano) {
		
		return new Posicion(1, 1);
	}

	@Override
	public Posicion generarPosicion() {
		
		int centroAncho = (this.ancho / 2);
		int centroAlto = (this.alto / 2);
		return new Posicion(centroAlto, centroAncho);
	}

}
