package vista;

import java.awt.image.BufferedImage;

import Conectores.ConexionDeAgua;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaConexionDeAgua extends VistaConstruccion {

	VistaConexionDeAgua(){
		this.construccion = new ConexionDeAgua(null);
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.TuberiaDeAgua);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.TuberiaDeAguaDestruida);
		return Imagen.loadImg(Archivo.TuberiaDeAguaSinServicio);
	}

}
