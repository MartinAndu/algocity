package Servicios;

import java.util.ArrayList;
import java.util.List;
public class AdministradorServicios {
	
	static final String AGUA = "agua";
	static final String ELECTRICIDAD = "electricidad";
	static final String TRANSITO = "transito";


	private List<Servicio> servicios;
	private List<String> listaDeServicios;
	private List<String> listaDeProveedores;
	
	public AdministradorServicios() {
		this.servicios = new ArrayList<Servicio>();
		this.listaDeServicios = new ArrayList<String>();
		this.listaDeProveedores = new ArrayList<String>();
	}

	public void agregarServicio(Servicio servicioAAgregar) {
		if (!this.listaDeServicios.contains(servicioAAgregar.idServicio())) {
			this.listaDeServicios.add(servicioAAgregar.idServicio());
			this.listaDeProveedores.add(servicioAAgregar.idProveedor());
			this.servicios.add(servicioAAgregar);
			return;
		}
		
		if (this.listaDeProveedores.contains(servicioAAgregar.idProveedor())) {
			return;
		}
		
		int indiceServicio = this.listaDeServicios.indexOf(servicioAAgregar.idServicio());
		Servicio servicio = this.servicios.get(indiceServicio);
		
		if (servicio.conviveCon(servicioAAgregar)) {
			this.listaDeServicios.add(servicioAAgregar.idServicio());
			this.listaDeProveedores.add(servicioAAgregar.idProveedor());
			this.servicios.add(servicioAAgregar);
			return;
		}
	}

	public boolean poseeAgua() {
		return this.poseo(AGUA);
	}
	
	public boolean poseeElectricidad() {
		return this.poseo(ELECTRICIDAD);
	}
	
	public boolean poseeAccesoAlTransito() {
		return this.poseo(TRANSITO);
	}
	
	private boolean poseo(String servicioString) {
		return this.listaDeServicios.contains(servicioString);
	}

	public boolean poseeLosServiciosBasicos() {
		boolean poseeServiciosBasicos = this.poseo(AGUA);
		poseeServiciosBasicos &= this.poseo(ELECTRICIDAD);
		poseeServiciosBasicos &= this.poseo(TRANSITO);
		return poseeServiciosBasicos;
	}

	public void quitarServicio(Servicio servicioAQuitar) {
		if (!(this.listaDeServicios.contains(servicioAQuitar.idServicio()))) {
			return;
		}
		
		if (!(this.listaDeProveedores.contains(servicioAQuitar.idProveedor()))) {
			
		}
		
		int indiceServicio = this.listaDeProveedores.indexOf(servicioAQuitar.idProveedor());
		this.listaDeProveedores.remove(indiceServicio);
		this.listaDeServicios.remove(indiceServicio);
		this.servicios.remove(indiceServicio);
		
	}

	

	

}
