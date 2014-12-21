package Conectores;


import ConstruccionGeneral.Posicion;
import Estados.EstoyBien;
import Estados.MeFaltaAgua;
import PuntosConstruccion.PuntosDeTuberia;
import Servicios.AdministradorServicios;
import Servicios.Agua;
import Servicios.Servicio;

public class ConexionDeAgua extends Conexion {
	static int COSTO_CONSTRUCCION = 5;
	
	public ConexionDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		this.costoConstruccion = COSTO_CONSTRUCCION;
		this.puntosConstruccion = new PuntosDeTuberia();
		this.esSubterraneo = true;
		this.idTipoDeConstruccion = "ConexionDeAgua";
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
		}else {
			this.estadoConstruccion = new EstoyBien();
			this.proveerServicioZona();
		}
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		return administrador.poseeAgua();
	}

		
}
