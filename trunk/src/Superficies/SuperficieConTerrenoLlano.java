package Superficies;

import java.awt.image.BufferedImage;

import aplicacion.Imagen;

public class SuperficieConTerrenoLlano extends Superficie{

	public boolean sePuedeConstruirUnPozoDeAgua(){
		return false;
	}

	public boolean sePuedeConstruirUnEdificioOCentral() {
		return true;
	}

	@Override
	public boolean sePuedeConstruirUnaConexion() {
		return true;
	}

	@Override
	public BufferedImage graficar() {
		return (Imagen.loadImg("Images/Walls/SuperficieConTerrenoLlano.png"));
	}
}
