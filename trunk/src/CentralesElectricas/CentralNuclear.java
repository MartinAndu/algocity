package CentralesElectricas;

import planoGeneral.Plano;


public class CentralNuclear extends CentralElectrica{
	static int COSTO_DE_PRODUCCION=10000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS=25;
	static int CAPACIDAD_DE_ABASTECIMIENTO=1000;
	
	public void proveerElectricidadZona(Plano unPlano){
		radioDeAbastecimientoEnHectareas=RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion=COSTO_DE_PRODUCCION;
		capacidadDeAbastecimientoEnMW=CAPACIDAD_DE_ABASTECIMIENTO;
	}
}
