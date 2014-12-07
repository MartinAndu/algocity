package Edificios;

import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeIndustria;
import Servicios.AdministradorServicios;

public class EdificioIndustrial extends Edificio {
	
	static final int COSTO_CONSTRUCCION = 10;
	static final int CONSUMO_ELECTRICO = 5;
	static final int CAPACIDAD_MAXIMA_EMPLEADOS = 25;
	
	public EdificioIndustrial(Posicion unaPosicion){
		super(unaPosicion);
		costoDeConstruccion = COSTO_CONSTRUCCION;
		consumoElectrico = CONSUMO_ELECTRICO;
		this.puntosDeConstruccion = new PuntosDeIndustria();

	}
	
	public int devolverCapacidadEmpleo(){
		return CAPACIDAD_MAXIMA_EMPLEADOS;
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		boolean poseeServicios = administrador.poseeElectricidad();
		poseeServicios &= administrador.poseeAccesoAlTransito();
		return poseeServicios;
	}
}