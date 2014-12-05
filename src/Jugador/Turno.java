package Jugador;

import Ambientes.Ambiente;

public class Turno implements Runnable{

	private Jugador jugador;
	private Ambiente ambiente;
	private Thread hilo;
	private boolean juegoContinua;
	private int duracion;
	
	public Turno(Jugador jugador, Ambiente ambiente) {
		this.jugador = jugador;
		this.ambiente = ambiente;
		this.hilo = new Thread(this);
		this.juegoContinua = true;
		this.duracion = 3000;
	}
		
		
	@Override
	public void run() {
		while (this.juegoContinua) {
			try {
				this.hilo.wait(duracion);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Soy el hilo ");
			//this.jugador.pasoUnTurno();
			//this.ambiente.pasoUnTurno();
		}
	}
	
	public void terminar() {
		this.juegoContinua = false;
	}

}
