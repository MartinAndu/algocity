package PlanoGeneradores;

import ConstruccionGeneral.Posicion;

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
		
		int centroAncho = (this.ancho / 8);
		int centroAlto = (this.alto / 8);
		return new Posicion(centroAlto, centroAncho);
	}

}
