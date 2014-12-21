package vista;

import java.awt.image.BufferedImage;

import aplicacion.Archivo;
import aplicacion.Imagen;
import Superficies.SuperficieConAgua;

public class VistaSuperficieConAgua extends VistaSuperficie {

	
	VistaSuperficieConAgua(){
		this.superficie = new SuperficieConAgua();
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaSuperficie() {
		return (Imagen.loadImg(Archivo.SuperficieConAgua));
	}

}
