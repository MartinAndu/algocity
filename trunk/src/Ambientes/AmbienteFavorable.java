package Ambientes;

import Administradores.AdministradorTurnosFavorable;
import Jugador.Jugador;

public class AmbienteFavorable extends Ambiente {

	public AmbienteFavorable(Jugador jugador) {
		super(jugador);
		this.admTurnos = new AdministradorTurnosFavorable();
	}

}
