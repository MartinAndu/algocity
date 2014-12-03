package Ambientes;

import Administradores.AdministradorTurnosDeterministico;
import Jugador.Jugador;

public class AmbienteDeterministico extends Ambiente {

	public AmbienteDeterministico(Jugador jugador) {
		super(jugador);
		this.admTurnos = new AdministradorTurnosDeterministico();
	}

}
