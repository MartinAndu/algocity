package vista;

import java.awt.image.BufferedImage;

import CentralesElectricas.CentralMineral;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaCentralMineral extends VistaConstruccion{
	
	VistaCentralMineral(){
		this.construccion = new CentralMineral(null);
	}

	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.CentralMineral);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.CentralMineralDestruida);
		return Imagen.loadImg(Archivo.CentralMineralSinServicio);
	}

}
