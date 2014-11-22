package SuperficiesGeneradores;

import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class GeneradorSuperficieDeterminista extends GeneradorSuperficie {

	public Superficie generarSuperficie() {
		if (numeroAlternador == 0){
			this.numeroAlternador += 1;
			return new SuperficieConAgua();
		}
		this.numeroAlternador -= 1;
		return new SuperficieConTerrenoLlano();
	}

}
