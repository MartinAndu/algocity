package Catastrofe;

import java.util.ArrayList;

import Jugador.Jugador;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class Godzilla extends Catastrofe {
	
	@Override
	public void destruirCiudad(Plano plano) {
		Recorrido zonaRecorridaPorGodzilla = plano.recorrerlAleatoriamenteDesdePosicionBorde();

		hectareasAfectadas = new ArrayList<Hectarea>();
		
		
		while (zonaRecorridaPorGodzilla.tieneSiguiente()){
			Hectarea hectareaActual = zonaRecorridaPorGodzilla.siguiente();
			hectareasAfectadas.add(hectareaActual);
			hectareaActual.destruir();
			estructurasDestruidas.addAll(hectareaActual.darListaDeReconstruibles());
		}
	
	}
	
	public void mostrarDestruccion(Jugador jugador){
		AnimacionCatastrofe animacion = new AnimacionCatastrofe(this.hectareasAfectadas,jugador);
		animacion.arrancar();
	}

}
