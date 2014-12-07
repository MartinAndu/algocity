package Conectores;

import ConstruccionGeneral.Posicion;

import Estados.MeFaltaAgua;
import PuntosConstruccion.PuntosDeTuberia;
import Servicios.AdministradorServicios;
import Servicios.Agua;
import Servicios.Servicio;

public class ConexionDeAgua extends Conexion {
	static int COSTO_CONSTRUCCION = 5;
	
	public ConexionDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.puntosDeConstruccion = new PuntosDeTuberia();
	}

	@Override
	protected Servicio servicioAProveer() {
		return new Agua(this.idProveedor);
	}

	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {
		if (!administradorServicios.poseeAgua()) {
			this.estadoConstruccion = new MeFaltaAgua();
			this.quitarServicioZona();
		}
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		return administrador.poseeAgua();
	}
		
}
