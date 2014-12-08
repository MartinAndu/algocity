package Superficies;

import java.awt.image.BufferedImage;

import aplicacion.Imagen;

public class SuperficieConAgua extends Superficie {
	
	public boolean sePuedeConstruirUnPozoDeAgua(){
		return true;
	}

	public boolean sePuedeConstruirUnEdificioOCentral() {
		return false;
	}

	@Override
	public boolean sePuedeConstruirUnaConexion() {
		return true;
	}

	@Override
	public BufferedImage graficar() {
		return (Imagen.loadImg("Images/Walls/SuperficieConAgua.jpg"));
	}
}
