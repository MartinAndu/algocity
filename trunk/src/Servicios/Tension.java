package Servicios;

public abstract class Tension extends Servicio {

	protected String idTension;
	
	public Tension(String idProveedor) {
		super(idProveedor);
		this.idServicio = "electricidad";
	}
	
	public String idTension() {
		return this.idTension;
	}

}
