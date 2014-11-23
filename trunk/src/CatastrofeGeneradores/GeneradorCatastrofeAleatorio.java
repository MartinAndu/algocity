package CatastrofeGeneradores;

import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import Catastrofe.Terremoto;


public class GeneradorCatastrofeAleatorio extends GeneradorCatastrofe{
	
	public Catastrofe generarCatastrofe() {
		
		int numeroAleatorio = (int)(Math.random()*10 + 1); // Puede ser un numero entre el 1 y el 10.

		if (numeroAleatorio < 3) // numero menor que 3, poca probabilidad, superficie con agua...
			return new Godzilla();
		
		// numero entre 3 y 10, mucha probabilidad, superficie con tierra...
		return new Terremoto();
	}

}
