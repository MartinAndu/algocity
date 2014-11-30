package Catastrofe;


import java.util.ArrayList;

import ConstruccionGeneral.Reconstruible;
import PlanoGeneral.Plano;

public abstract class Catastrofe {
	
	protected ArrayList<Reconstruible> estructurasDestruidas;

	public Catastrofe() {
		this.estructurasDestruidas = new ArrayList<Reconstruible>();
	}
	
	public abstract void destruirCiudad(Plano plano);

	public ArrayList<Reconstruible> obtenerListaDeEstructurasDestruidas() {
		return estructurasDestruidas;
	}

}
