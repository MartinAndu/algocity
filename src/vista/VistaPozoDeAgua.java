package vista;

import java.awt.image.BufferedImage;

import Edificios.PozoDeAgua;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaPozoDeAgua extends VistaConstruccion{
	
	VistaPozoDeAgua(){
		this.construccion = new PozoDeAgua(null);
	}

	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.PozoDeAgua);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.PozoDeAguaDestruido);
		else
			return Imagen.loadImg(Archivo.PozoDeAguaSinServicio);
	}

}
