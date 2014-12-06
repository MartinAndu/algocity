package Servicios;

public class BajaTension extends Tension {

	public BajaTension(String idProveedor) {
		super(idProveedor);
		this.idTension = "baja_tension";
	}

	@Override
	public boolean conviveCon(Servicio servicio) {
		Tension servicioElectrico = (Tension) servicio;
		if (this.idTension == servicioElectrico.idTension()) {
			return false;
		}
		
		return true;
	}

}
