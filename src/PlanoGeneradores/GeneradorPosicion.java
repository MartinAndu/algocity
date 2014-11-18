package PlanoGeneradores;

import Edificios.Posicion;
import PlanoGeneral.Plano;

public abstract class GeneradorPosicion {

	protected int alto;
	protected int ancho;

	public GeneradorPosicion(int dimensionN, int dimensionM) {
		
		this.alto = dimensionN;
		this.ancho = dimensionM;
	}
	
	public abstract Posicion generarPosicionEnBordePlano(Plano plano);

	public abstract Posicion generarPosicion();

}
