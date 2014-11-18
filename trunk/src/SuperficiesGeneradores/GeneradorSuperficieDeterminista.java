package SuperficiesGeneradores;

import Superficies.Superficie;
import Superficies.SuperficieConTerrenoLlano;

public class GeneradorSuperficieDeterminista extends GeneradorSuperficie {

	@Override
	public Superficie generarSuperficie() {
		
		return new SuperficieConTerrenoLlano();
	}

}
