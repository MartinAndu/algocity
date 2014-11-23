package SuperficiesGeneradores;

import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class GeneradorSuperficieDeterminista extends GeneradorSuperficie {

	public GeneradorSuperficieDeterminista(){
		numeroAlternador=0;
	}
	public Superficie generarSuperficie() {
		
		if (numeroAlternador == 0){
			GeneradorSuperficieDeterminista.numeroAlternador += 1;
			return new SuperficieConTerrenoLlano();
		}
		GeneradorSuperficieDeterminista.numeroAlternador -= 1;
		return new SuperficieConAgua();
	}

}
