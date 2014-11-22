package SuperficiesGeneradores;

import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class GeneradorSuperficieAleatoria extends GeneradorSuperficie {

	public Superficie generarSuperficie() {
		
		int numeroAleatorio = (int)(Math.random()*10 + 1); // Puede ser un numero entre el 1 y el 10.

		if (numeroAleatorio < 3){ // numero menor que 3, poca probabilidad, superficie con agua...
			return new SuperficieConAgua();
		}
		// numero entre 3 y 10, mucha probabilidad, superficie con tierra...
		return new SuperficieConTerrenoLlano();
	}
}