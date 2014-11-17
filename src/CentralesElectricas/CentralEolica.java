package CentralesElectricas;

import PlanoGeneral.Plano;

public class CentralEolica extends CentralElectrica {
	static int COSTO_DE_CONSTRUCCION = 1000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 4;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 100;
	
	public CentralEolica(){
		radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
	}
	public void proveerElectricidadZona(Plano unPlano){

	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
}
