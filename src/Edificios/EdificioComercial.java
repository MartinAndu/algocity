package Edificios;


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
		this.idTipoDeConstruccion = "EdificioComercial"; 
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		
		return administrador.poseeLosServiciosBasicos();
	}
	
}