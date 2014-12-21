package vista;

import java.awt.image.BufferedImage;

import Edificios.EdificioComercial;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaEdificioComercial extends VistaConstruccion{

	VistaEdificioComercial(){
		this.construccion = new EdificioComercial(null);
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.EdificioComercial);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.EdificioComercialDestruido);
		else
			return Imagen.loadImg(Archivo.EdificioComercialSinServicio);
	}

}
