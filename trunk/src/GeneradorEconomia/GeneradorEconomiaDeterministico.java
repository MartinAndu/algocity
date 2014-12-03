package GeneradorEconomia;

import Administradores.Evento;
import Economia.EconomiaCreciente;

public class GeneradorEconomiaDeterministico extends GeneradorEconomia {

	public Evento generarUnEvento() {
		return new EconomiaCreciente();
	}

}
