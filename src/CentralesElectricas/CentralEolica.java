package CentralesElectricas;

import Edificios.Posicion;
import PlanoGeneral.Plano;

public class CentralEolica extends CentralElectrica {
	static int COSTO_DE_CONSTRUCCION = 1000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 4;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 100;
	static int PORCENTAJE_REPARACION_POR_BOMBEROS = 15;
	
	
	
	public CentralEolica(Posicion unaPosicion){
		radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		posicionConstruccion = unaPosicion;
	}
	public void proveerElectricidadZona(Plano unPlano){
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
}
