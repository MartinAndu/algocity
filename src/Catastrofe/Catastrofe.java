package Catastrofe;


import java.util.ArrayList;

import Administradores.Evento;
import ConstruccionGeneral.Reconstruible;
import Jugador.Jugador;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public abstract class Catastrofe implements Evento {
	
	protected ArrayList<Hectarea> hectareasAfectadas;
	protected ArrayList<Reconstruible> estructurasDestruidas;
	
	public Catastrofe() {
		this.estructurasDestruidas = new ArrayList<Reconstruible>();
		
	}
	
	public abstract void destruirCiudad(Plano plano);

	public ArrayList<Reconstruible> darListaConstruccionesDestruidas() {
		return estructurasDestruidas;
	}
	
	public void ocurrir(Jugador jugador) {
		jugador.destruirConstruccionesPorCatastrofe(this);
	}
	
	public abstract void mostrarDestruccion(Jugador jugador);
	
}
