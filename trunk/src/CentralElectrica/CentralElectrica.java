package CentralElectrica;

import algo3.tp2.Construccion;
import algo3.tp2.Destruible;
import algo3.tp2.Reconstruible;


public abstract class CentralElectrica extends Construccion implements Reconstruible,Destruible {
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	
//	protected void proveerElectricidadZona(Plano unPlano);
}
