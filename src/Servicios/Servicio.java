package Servicios;

public abstract class Servicio {

	protected String idProveedor;
	protected String idServicio;
	
	public Servicio(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String idProveedor() {
		return this.idProveedor;
	}

	public String idServicio() {
		return this.idServicio;
	}
	
	public abstract boolean conviveCon(Servicio servicio);
}
