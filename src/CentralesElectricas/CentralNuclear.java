package CentralesElectricas;

import Edificios.Posicion;

public class CentralNuclear extends CentralElectrica{
	static int COSTO_DE_CONSTRUCCION = 10000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 25;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 1000;
	static int PUNTOS_MAXIMOS_DE_CONSTRUCCION = 34000;
	
	public CentralNuclear(Posicion unaPosicion) {
		super(unaPosicion);
		
		radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		puntosMaximosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
		puntosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
	}


}
