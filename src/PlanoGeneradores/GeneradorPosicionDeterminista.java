package PlanoGeneradores;

import Edificios.Posicion;

public class GeneradorPosicionDeterminista extends GeneradorPosicion {

	public GeneradorPosicionDeterminista(int dimensionN, int dimensionM) {
		
		super(dimensionN, dimensionM);
	}

	@Override
	public Posicion generarPosicionEnBordePlano() {
		
		return new Posicion(1, 1);
	}

	@Override
	public Posicion generarPosicion() {
		
		int centroAncho = (this.ancho / 10);
		int centroAlto = (this.alto / 10);
		return new Posicion(centroAlto, centroAncho);
	}

}
