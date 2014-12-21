package vista;

import java.awt.image.BufferedImage;

import Conectores.LineasDeTension;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaLineasDeTension extends VistaConstruccion {
	
	VistaLineasDeTension(){
		this.construccion = new LineasDeTension(null);
	}

	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.LineaDeTension);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.LineaDeTensionDestruida);
		return Imagen.loadImg(Archivo.LineaDeTensionSinServicio);
	}

}
