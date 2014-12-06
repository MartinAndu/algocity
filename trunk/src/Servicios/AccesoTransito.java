package Servicios;

public class AccesoTransito extends Servicio {

	public AccesoTransito(String idProveedor) {
		super(idProveedor);
		this.idServicio = "transito";
	}

	@Override
	public boolean conviveCon(Servicio servicio) {
		return false;
	}

}
