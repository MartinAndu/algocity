package GeneradorEconomia;

import Administradores.Evento;
import Economia.EconomiaCreciente;
import Economia.EconomiaDecreciente;

public class GeneradorEconomiaAletario extends GeneradorEconomia {

	@Override
	public Evento generarUnEvento() {
		int numeroAleatorio = (int)(Math.random() * 10 + 1); 

		if (numeroAleatorio < 5) {
			return new EconomiaCreciente();
		}
	
		return new EconomiaDecreciente();
	}

}
