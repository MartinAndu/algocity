package vista;

import java.awt.image.BufferedImage;

import Superficies.Superficie;

public abstract class VistaSuperficie {
	public abstract BufferedImage obtenerRepresentacionDeLaSuperficie();
	protected Superficie superficie;
	
	public Superficie obtenerSuperficie(){
		return this.superficie;
	}
}
