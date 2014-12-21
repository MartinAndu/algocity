package vista;

import java.awt.image.BufferedImage;

import Edificios.EdificioResidencial;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaEdificioResidencial extends VistaConstruccion{

	VistaEdificioResidencial(){
		this.construccion = new EdificioResidencial(null);
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.EdificioResidencial);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.EdificioResidencialDestruido);
		else
			return Imagen.loadImg(Archivo.EdificioResidencialSinServicio);
	}

}
