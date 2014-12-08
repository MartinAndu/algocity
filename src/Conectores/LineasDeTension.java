package Conectores;

import java.awt.image.BufferedImage;

import aplicacion.Imagen;
import ConstruccionGeneral.Posicion;
import Estados.MeFaltaLuz;
import PuntosConstruccion.PuntosDeLineaTension;
import Servicios.AdministradorServicios;
import Servicios.BajaTension;
import Servicios.Servicio;

public  class LineasDeTension extends Conexion{

	static int COSTO_CONSTRUCCION = 5;
	
	public LineasDeTension(Posicion unaPosicion) {
		super(unaPosicion);
		this.costoConstruccion = COSTO_CONSTRUCCION;
		this.puntosConstruccion = new PuntosDeLineaTension();
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		
		return administrador.poseeElectricidad();
	}

	@Override
	protected Servicio servicioAProveer() {
		return new BajaTension(idProveedor);
	}

	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {
		if (!administradorServicios.poseeElectricidad()) {
			this.estadoConstruccion = new MeFaltaLuz();
			this.quitarServicioZona();
		}		
	}
	
	public BufferedImage graficar() {
		return Imagen.loadImg("Images/Walls/LineaDeTension.jpg");
	}	
	
	
}
