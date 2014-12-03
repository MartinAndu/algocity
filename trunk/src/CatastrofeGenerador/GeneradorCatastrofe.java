package CatastrofeGenerador;

import Administradores.Evento;
import Administradores.GeneradorEvento;
import Catastrofe.Catastrofe;

public abstract class GeneradorCatastrofe implements GeneradorEvento{
	
	public abstract Catastrofe generarCatastrofe();
	
	public Evento generarUnEvento() {
		return (Evento) this.generarCatastrofe();
	}
}
