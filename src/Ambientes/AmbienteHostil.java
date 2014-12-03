package Ambientes;

import Administradores.AdministradorTurnosHostil;
import Jugador.Jugador;

public class AmbienteHostil extends Ambiente {

	public AmbienteHostil(Jugador jugador) {
		super(jugador);
		this.admTurnos = new AdministradorTurnosHostil();
	}

}
