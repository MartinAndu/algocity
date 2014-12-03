package Jugador;

import Ambientes.Ambiente;

public class Turno {

	private Jugador jugador;
	private Ambiente ambiente;

	public void establecerJugador(Jugador jugador) {
		this.jugador = jugador;
		
	}

	public void establecerAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
		
	}

}
