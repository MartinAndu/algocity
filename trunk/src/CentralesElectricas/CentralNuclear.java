package CentralesElectricas;

import Edificios.Posicion;
import PlanoGeneral.Plano;


public class CentralNuclear extends CentralElectrica{
	static int COSTO_DE_CONSTRUCCION = 10000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 25;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 1000;
	static int PORCENTAJE_REPARACION_POR_BOMBEROS = 3;
	
	public CentralNuclear(Posicion unaPosicion){
		radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		posicionConstruccion = unaPosicion;
		porcentajeDeConstruccion=100;
		
		puntosMaximosDeConstruccion=34000;
		puntosDeConstruccion=puntosMaximosDeConstruccion;
	}
	public void proveerElectricidadZona(Plano unPlano){
		
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
}
