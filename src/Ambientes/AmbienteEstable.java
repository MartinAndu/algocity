package Ambientes;

import Administradores.AdministradorTurnosEstable;
import Jugador.Jugador;

public class AmbienteEstable extends Ambiente {

	public AmbienteEstable(Jugador jugador) {
		super(jugador);
		this.admTurnos = new AdministradorTurnosEstable();
	}

}
