package Catastrofe;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class Godzilla extends Catastrofe {
	
	
	@Override
	public void destruirCiudad(Plano plano) {
		Recorrido zonaRecorridaPorGodzilla = plano.recorrerlAleatoriamenteDesdePosicionBorde();
		
		while (zonaRecorridaPorGodzilla.tieneSiguiente()){
			Hectarea hectareaActual = zonaRecorridaPorGodzilla.siguiente();
			hectareaActual.destruir();
			estructurasDestruidas.addAll(hectareaActual.darListaDeReconstruibles());
		}
	
	}

}
