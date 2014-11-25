package CentralesElectricas;

import Edificios.Posicion;

public class CentralMineral extends CentralElectrica{
	static int COSTO_DE_CONSTRUCCION = 3000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 10;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 400;
	static int PUNTOS_MAXIMOS_DE_CONSTRUCCION = 10000;
	
	public CentralMineral(Posicion unaPosicion) {
		super(unaPosicion);
		
		radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		puntosMaximosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
		puntosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
	}

	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
}
