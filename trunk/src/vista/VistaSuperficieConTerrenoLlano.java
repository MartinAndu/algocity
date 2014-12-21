package vista;

import java.awt.image.BufferedImage;

import aplicacion.Archivo;
import aplicacion.Imagen;
import Superficies.SuperficieConTerrenoLlano;

public class VistaSuperficieConTerrenoLlano extends VistaSuperficie {

	VistaSuperficieConTerrenoLlano(){
		this.superficie = new SuperficieConTerrenoLlano();
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaSuperficie() {
		return (Imagen.loadImg(Archivo.SuperficieConTerrenoLlano));
	}

}
