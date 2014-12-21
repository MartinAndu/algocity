package vista;

import java.awt.image.BufferedImage;

import CentralesElectricas.CentralNuclear;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaCentralNuclear extends VistaConstruccion{

	VistaCentralNuclear(){
		this.construccion = new CentralNuclear(null);
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.CentralNuclear);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.CentralNuclearDestruida);
		return Imagen.loadImg(Archivo.CentralNuclearSinServicio);
	}

}
