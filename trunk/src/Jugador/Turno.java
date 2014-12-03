package Jugador;

import Ambientes.Ambiente;

public class Turno implements Runnable{

	private Jugador jugador;
	private Ambiente ambiente;
	private Thread hilo;
	private boolean juegoContinua;

	public Turno(Jugador jugador, Ambiente ambiente) {
		this.jugador = jugador;
		this.ambiente = ambiente;
		this.hilo = new Thread(this);
		this.juegoContinua = true;
	}
		
		
	@Override
	public void run() {
		while (this.juegoContinua) {
			
		}
	}

}
