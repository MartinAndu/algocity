package PlanoGeneradores;

import Edificios.Posicion;

public abstract class GeneradorPosicion {

	protected int alto;
	protected int ancho;

	public GeneradorPosicion(int dimensionN, int dimensionM) {
		
		this.alto = dimensionN;
		this.ancho = dimensionM;
	}
	
	public abstract Posicion generarPosicionEnBordePlano();

	public abstract Posicion generarPosicion();

}
