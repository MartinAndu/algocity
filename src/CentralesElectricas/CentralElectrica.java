package CentralesElectricas;

import Edificios.Construccion;
import Edificios.Destruible;
import Edificios.Reconstruible;
import PlanoGeneral.Plano;



public abstract  class CentralElectrica extends Construccion implements Reconstruible,Destruible {
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	
	protected abstract void proveerElectricidadZona(Plano unPlano);
	
	public int obtenerRadioDeAbastecimientoEnHectareas(){
		return radioDeAbastecimientoEnHectareas;
	}
	
	public int obtenerCapacidadDeAbastecimientoEnMW(){
		return capacidadDeAbastecimientoEnMW;
	}
	
	public int obtenerCapacidadMaxDeAbastecimientoEnMW(){
		return capacidadMaxDeAbastecimientoEnMW;
	}
	
	
	public void acumularCapacidadDeAbastecimiento(){
		//Recibe la cuota de energia consumia por los edificios y la va acumulando
		
	}
	
	public boolean esConstruibleSobreTierra(){
		return true;
	}
	
	public boolean esConstruibleSobreAgua(){
		return false;
	}

	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
	
}
