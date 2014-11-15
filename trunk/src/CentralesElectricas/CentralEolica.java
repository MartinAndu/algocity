package CentralesElectricas;

import Planos.Plano;

public class CentralEolica extends CentralElectrica {
	static int COSTO_DE_PRODUCCION=1000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS=4;
	static int CAPACIDAD_DE_ABASTECIMIENTO=100;
	
	public void proveerElectricidadZona(Plano unPlano){
		radioDeAbastecimientoEnHectareas=RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion=COSTO_DE_PRODUCCION;
		capacidadDeAbastecimientoEnMW=CAPACIDAD_DE_ABASTECIMIENTO;
	}
}
