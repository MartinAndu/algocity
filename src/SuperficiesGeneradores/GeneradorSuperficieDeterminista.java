package SuperficiesGeneradores;

import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class GeneradorSuperficieDeterminista extends GeneradorSuperficie {
	
	private int alternador;

	public GeneradorSuperficieDeterminista() {
		this.alternador = 0;
	}
	public Superficie generarSuperficie() {
		this.alternador++;
		if ((alternador % 2) == 0) {
			return new SuperficieConAgua();
		}
		return new SuperficieConTerrenoLlano();
	}

}
