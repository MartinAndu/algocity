package Edificios;


import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeResidencia;
import Servicios.AdministradorServicios;

public class EdificioResidencial extends Edificio {

	static int COSTO_CONSTRUCCION = 5;
	static int CONSUMO_ELECTRICO = 1;
	static int CAPACIDAD_MAXIMA_HABITANTES = 100;

	public EdificioResidencial(Posicion unaPosicion){
		super(unaPosicion);
		this.costoConstruccion = COSTO_CONSTRUCCION;
		this.consumoElectrico = CONSUMO_ELECTRICO;
		this.puntosConstruccion = new PuntosDeResidencia();
		this.idTipoDeConstruccion = "EdificioResidencial";
	}

	public int darCapacidadAlojamiento(){
		return CAPACIDAD_MAXIMA_HABITANTES;
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
	
		return administrador.poseeLosServiciosBasicos();
	}
	
}