package CentralesElectricas;

import Edificios.Posicion;

public class CentralEolica extends CentralElectrica {
	static int COSTO_DE_CONSTRUCCION = 1000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 4;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 100;
	static int PUNTOS_MAXIMOS_DE_CONSTRUCCION = 7000;

	public CentralEolica(Posicion unaPosicion) {
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
