package CentralesElectricas;

import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeCentralMineral;

public class CentralMineral extends CentralElectrica{
	static int COSTO_DE_CONSTRUCCION = 3000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 10;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 400;
	
	public CentralMineral(Posicion unaPosicion) {
		super(unaPosicion);
		this.radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		this.costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		this.capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		this.puntosDeConstruccion = new PuntosDeCentralMineral();
	}


}
