package Servicios;

public class AltaTension extends Tension {

	public AltaTension(String idProveedor) {
		super(idProveedor);
		this.idTension = "alta_tension";
	}

	@Override
	public boolean conviveCon(Servicio servicio) {
		Tension servicioElectrico = (Tension) servicio;
		if (this.idTension == servicioElectrico.idTension()) {
			return true;
		}
		
		return false;
	}

}
