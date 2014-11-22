package CentralesElectricas;

import Edificios.Posicion;
import PlanoGeneral.Plano;


public class CentralMineral extends CentralElectrica{
	static int COSTO_DE_CONSTRUCCION = 3000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 10;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 400;
	static int PORCENTAJE_REPARACION_POR_BOMBEROS = 10;
	
	public CentralMineral(Posicion unaPosicion){
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
