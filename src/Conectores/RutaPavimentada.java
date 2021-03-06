package Conectores;

import ConstruccionGeneral.Posicion;
import Estados.EstoyBien;
import Estados.MeFaltaTransito;
import PuntosConstruccion.PuntosDeRuta;
import Servicios.AccesoTransito;
import Servicios.AdministradorServicios;
import Servicios.Servicio;

public class RutaPavimentada extends Conexion{

	static int COSTO_CONSTRUCCION = 10;

	public RutaPavimentada(Posicion unaPosicion) {
		super(unaPosicion);
		this.costoConstruccion = COSTO_CONSTRUCCION;
		this.puntosConstruccion = new PuntosDeRuta();
		this.idTipoDeConstruccion = "RutaPavimentada";
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		
		return true;
	}

	@Override
	protected Servicio servicioAProveer() {
		
		return new AccesoTransito(idProveedor);
	}

	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {

		if (!administradorServicios.poseeAccesoAlTransito()) {
			this.estadoConstruccion = new MeFaltaTransito();
			this.quitarServicioZona();
		}else {
			this.estadoConstruccion = new EstoyBien();
			this.proveerServicioZona();
		}
	}	
}
