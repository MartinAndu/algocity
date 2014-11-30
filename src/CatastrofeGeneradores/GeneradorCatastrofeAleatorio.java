package CatastrofeGeneradores;

import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import Catastrofe.Terremoto;


public class GeneradorCatastrofeAleatorio extends GeneradorCatastrofe{
	
	public Catastrofe generarCatastrofe() {
		
		int numeroAleatorio = (int)(Math.random() * 10 + 1); 

		if (numeroAleatorio < 7) {
			return new Godzilla();
		}
	
		return new Terremoto();
	}

}
