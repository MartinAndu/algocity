package Catastrofe;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;


public class Terremoto extends Catastrofe{
	
	public void destruirCiudad(Plano plano) {
		Recorrido zonaCircundante= plano.recorrerTodoDesdeUnaPosicionAleatoria();
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual = zonaCircundante.siguiente();
			hectareaActual.destruirEnUnPorcentaje((int) (100 - (1.5 * zonaCircundante.distanciaDesdeDondeParti())));
			estructurasDestruidas.addAll(hectareaActual.darListaDeReconstruibles());
		}
	}

}
