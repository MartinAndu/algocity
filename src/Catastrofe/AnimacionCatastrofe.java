package Catastrofe;

import java.util.ArrayList;
import java.util.Iterator;


import Jugador.Jugador;
import PlanoGeneral.Hectarea;

public class AnimacionCatastrofe implements Runnable{

	static final int DURACION_EN_MINUTOS = 3;
	
	private Thread hilo;
	private int duracion;
	private ArrayList<Hectarea> hectareasDestruidas;
	private Jugador jugador;
	
	public AnimacionCatastrofe(ArrayList<Hectarea> hectareasDestruidas,Jugador jugador) {
		this.hilo = new Thread(this);
		this.duracion = (AnimacionCatastrofe.DURACION_EN_MINUTOS * 60);
		this.hectareasDestruidas = hectareasDestruidas;
		this.jugador = jugador;
	}
		
		
	public void arrancar() {
		this.hilo.start();
	}
	
	@Override
	public void run() {
		Iterator<Hectarea> it = this.hectareasDestruidas.iterator(); 
		while (it.hasNext()) {
			Hectarea hectareaDestruida = it.next();
			try {
				hectareaDestruida.hayUnaCatastrofeOcurriendo();
				jugador.avisarALaVistaQueGodzillaPaso();
				Thread.sleep(duracion);
				
			} catch (InterruptedException e) {
			}
		}
	}
	

}