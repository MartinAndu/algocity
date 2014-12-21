package vista;

import java.awt.image.BufferedImage;

import CentralesElectricas.CentralEolica;
import aplicacion.Archivo;
import aplicacion.Imagen;

public class VistaCentralEolica extends VistaConstruccion{
	
	VistaCentralEolica(){
		this.construccion = new CentralEolica(null);
	}
	
	@Override
	public BufferedImage obtenerRepresentacionDeLaConstruccion() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.CentralEolica);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.CentralEolicaDestruida);
		return Imagen.loadImg(Archivo.CentralEolicaSinServicio);
		
	}

}
