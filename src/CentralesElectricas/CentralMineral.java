package CentralesElectricas;

import planoGeneral.Plano;


public class CentralMineral extends CentralElectrica{
	static int COSTO_DE_PRODUCCION=3000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS=10;
	static int CAPACIDAD_DE_ABASTECIMIENTO=400;
	
	public void proveerElectricidadZona(Plano unPlano){
		radioDeAbastecimientoEnHectareas=RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion=COSTO_DE_PRODUCCION;
		capacidadDeAbastecimientoEnMW=CAPACIDAD_DE_ABASTECIMIENTO;
	}
}
