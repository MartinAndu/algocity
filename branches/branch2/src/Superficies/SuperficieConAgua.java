package Superficies;

import Edificios.Construccion;

public class SuperficieConAgua extends Superficie {
	
	public boolean puedoConstruir(Construccion unaConstruccion){
		return unaConstruccion.esConstruibleSobreAgua();
	}
}
