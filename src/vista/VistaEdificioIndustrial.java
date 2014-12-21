package vista;

import java.awt.image.BufferedImage;

import Edificios.EdificioIndustrial;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaEdificioIndustrial extends VistaConstruccion{

	VistaEdificioIndustrial(){
		this.construccion = new EdificioIndustrial(null);
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.EdificioIndustrial);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.EdificioIndustrialDestruido);
		else
			return Imagen.loadImg(Archivo.EdificioIndustrialSinServicio);
	}

}
