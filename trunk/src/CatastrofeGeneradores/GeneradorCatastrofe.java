package CatastrofeGeneradores;

import Catastrofe.Catastrofe;

public abstract class GeneradorCatastrofe {
	static public int numeroAlternador = 0;
	
	public abstract Catastrofe generarCatastrofe();
}
