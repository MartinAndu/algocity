package Edificios;

import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeComercio;
import Servicios.AdministradorServicios;

public class EdificioComercial extends Edificio {
	
	static int COSTO_CONSTRUCCION = 5;
	static int CONSUMO_ELECTRICO = 2;
	
	public EdificioComercial(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.consumoElectrico = CONSUMO_ELECTRICO;
		this.puntosDeConstruccion = new PuntosDeComercio();
		
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		
		return administrador.poseeLosServiciosBasicos();
	}
	
}