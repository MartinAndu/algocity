package CatastrofeGeneradores;

import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import Catastrofe.Terremoto;


public class GeneradorCatastrofeDeterministico extends GeneradorCatastrofe{

	public Catastrofe generarCatastrofe() {
		if (numeroAlternador == 0){
			GeneradorCatastrofeDeterministico.numeroAlternador += 1;
			return new Godzilla();
		}
		GeneradorCatastrofeDeterministico.numeroAlternador -= 1;
		return new Terremoto();
	}
}
