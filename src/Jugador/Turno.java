package Jugador;

import Ambientes.Ambiente;

public class Turno implements Runnable{

	static final int DURACION_EN_MINUTOS = 5;
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
		this.duracion = (5 * 60) * 1000;
	}
		
		
	public void arrancar() {
		this.hilo.start();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (this.juegoContinua) {
			try {
				this.hilo.sleep(duracion);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Soy el hilo ");
			this.jugador.pasoUnTurno();
			this.ambiente.pasoUnTurno();
		}
	}
	
	public void terminar() {
		this.juegoContinua = false;
	}

}
