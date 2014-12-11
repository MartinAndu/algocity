package Conectores;

import java.awt.image.BufferedImage;

import aplicacion.Archivo;
import aplicacion.Imagen;
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
	
	public BufferedImage graficar() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.TuberiaDeAgua);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.TuberiaDeAguaDestruida);
		return Imagen.loadImg(Archivo.TuberiaDeAguaSinServicio);
	}	
		
}
