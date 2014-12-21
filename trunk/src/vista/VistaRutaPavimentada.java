package vista;

import java.awt.image.BufferedImage;

import Conectores.RutaPavimentada;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaRutaPavimentada extends VistaConstruccion{
	
	VistaRutaPavimentada(){
		this.construccion = new RutaPavimentada(null);
	}

	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.RutaPavimentada);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.RutaPavimentadaDestruida);
		else
			return Imagen.loadImg(Archivo.RutaPavimentadaSinServicio);
	}

}
