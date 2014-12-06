package Servicios;

public class Agua extends Servicio {
	
	public Agua(String idProveedor) {
		super(idProveedor);
		this.idServicio = "agua";
	}

	@Override
	public boolean conviveCon(Servicio servicio) {
		return false;
	}


}
