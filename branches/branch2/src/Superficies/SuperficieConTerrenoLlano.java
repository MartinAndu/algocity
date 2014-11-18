package Superficies;

import Edificios.Construccion;

public class SuperficieConTerrenoLlano extends Superficie{

	public SuperficieConTerrenoLlano(){
		
	}
	public boolean puedoConstruir(Construccion unaConstruccion){
		return unaConstruccion.esConstruibleSobreTierra();
	}
}
