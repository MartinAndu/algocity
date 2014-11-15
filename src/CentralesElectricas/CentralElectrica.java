package CentralesElectricas;

import Edificios.Construccion;
import Edificios.Destruible;
import Edificios.Reconstruible;
import Plano.Plano;



public abstract class CentralElectrica extends Construccion implements Reconstruible,Destruible {
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	
	abstract void proveerElectricidadZona(Plano unPlano);
}
