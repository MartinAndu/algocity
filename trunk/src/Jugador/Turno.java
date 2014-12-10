package Jugador;

import Ambientes.Ambiente;

public class Turno implements Runnable{

	static final int DURACION_EN_MINUTOS = 5;
	private Jugador jugador;
	private Ambiente ambiente;
	private Thread hilo;
	private boolean juegoContinua;
	private int duracion;
	private int numeroDeDia;
	
	public Turno(Jugador jugador, Ambiente ambiente) {
		this.jugador = jugador;
		this.ambiente = ambiente;
		this.hilo = new Thread(this);
		this.juegoContinua = true;
		this.duracion = (Turno.DURACION_EN_MINUTOS * 60) * 1000;
		this.numeroDeDia = 1;
	}
		
		
	public void arrancar() {
		this.hilo.start();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(duracion);
			} catch (InterruptedException e) {
			}
			if (!this.juegoContinua) {
				break;
			}
			numeroDeDia++;
			this.jugador.pasoUnTurno();
			this.ambiente.pasoUnTurno();
		}
		numeroDeDia = 1;
	}
	
	public int obtenerNumeroDeDia(){
		return this.numeroDeDia;
	}
	
	public void terminar() {
		this.juegoContinua = false;
	}

}
