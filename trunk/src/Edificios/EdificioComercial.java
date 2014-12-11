package Edificios;

import java.awt.image.BufferedImage;

import aplicacion.Archivo;
import aplicacion.Imagen;
import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeComercio;
import Servicios.AdministradorServicios;

public class EdificioComercial extends Edificio {
	
	static int COSTO_CONSTRUCCION = 5;
	static int CONSUMO_ELECTRICO = 2;
	
	public EdificioComercial(Posicion unaPosicion){
		super(unaPosicion);
		this.costoConstruccion = COSTO_CONSTRUCCION;
		this.consumoElectrico = CONSUMO_ELECTRICO;
		this.puntosConstruccion = new PuntosDeComercio();
		
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		
		return administrador.poseeLosServiciosBasicos();
	}

	@Override
	public BufferedImage graficar() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.EdificioComercial);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.EdificioComercialDestruido);
		else
			return Imagen.loadImg(Archivo.EdificioComercialSinServicio);
	}
	
}