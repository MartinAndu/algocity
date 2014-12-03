package Catastrofe;


import java.util.ArrayList;

import Administradores.Evento;
import ConstruccionGeneral.Reconstruible;
import Jugador.Jugador;
import PlanoGeneral.Plano;

public abstract class Catastrofe implements Evento {
	
	protected ArrayList<Reconstruible> estructurasDestruidas;

	public Catastrofe() {
		this.estructurasDestruidas = new ArrayList<Reconstruible>();
	}
	
	public abstract void destruirCiudad(Plano plano);

	public ArrayList<Reconstruible> obtenerListaDeEstructurasDestruidas() {
		return estructurasDestruidas;
	}
	
	public void ocurrir(Jugador jugador) {
		jugador.huboUnaCatastrofe(this);
	}

}
