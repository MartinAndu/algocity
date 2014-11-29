package CatastrofeGeneradores;

import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import Catastrofe.Terremoto;


public class GeneradorCatastrofeDeterministico extends GeneradorCatastrofe{

	private int alternador;

	public Catastrofe generarCatastrofe() {
		this.alternador++;
		
		if ((this.alternador % 2) == 0) {
			return new Godzilla();
		}
		return new Terremoto();
	}
}
