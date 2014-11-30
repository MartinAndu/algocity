package PlanoGeneradores;

import PlanoDireccion.Direccion;
import PlanoDireccion.Este;
import PlanoDireccion.NorEste;
import PlanoDireccion.NorOeste;
import PlanoDireccion.Norte;
import PlanoDireccion.Oeste;
import PlanoDireccion.Sur;
import PlanoDireccion.SurEste;
import PlanoDireccion.SurOeste;

public class GeneradorDireccionAleatorio extends GeneradorDireccion {

	@Override
	public Direccion generarDireccion() {
		int numeroAleatorio = (int)(Math.random()*8 + 1); 
		
		switch (numeroAleatorio) {
		case 1:
			return new Norte();
		case 2:
			return new NorEste();
		case 3:
			return new Este();
		case 4:
			return new SurEste();
		case 5:
			return new Sur();
		case 6:
			return new SurOeste();
		case 7:
			return new Oeste();
		default:
			return new NorOeste();
		}
	}

}
