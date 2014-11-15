package CentralesElectricas;

import Edificios.Construccion;
import Edificios.Destruible;
import Edificios.Reconstruible;


public abstract class CentralElectrica extends Construccion implements Reconstruible,Destruible {
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	
//	protected void proveerElectricidadZona(Plano unPlano);
}
