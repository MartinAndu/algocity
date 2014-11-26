package Catastrofe;

import java.util.ArrayList;

import Edificios.Posicion;
import Edificios.Reconstruible;
import PlanoDireccion.Direccion;
import PlanoDireccion.SurEste;
import PlanoGeneradores.GeneradorPosicionDeterminista;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class Godzilla extends Catastrofe {
	
	ArrayList<Reconstruible> edificiosRotos;
	

	public Godzilla(){
		edificiosRotos = new ArrayList<Reconstruible>();
	}
	
	
	private Recorrido recorridoDeGodzilla(Plano plano,Posicion unaPosicion){
		//Tira un número al azar para el recorrido.
		int posibilidadDeRecorrido = (int)(Math.random()*10 + 1);
		
		//Como prueba, se posiciona en la coordenada (1,1) y recorre diagonalmente
		if (posibilidadDeRecorrido<3){
			//Hago zig-zag con direccion sureste
			return plano.recorrerLinealmente(unaPosicion,(Direccion) new SurEste()); 
		}
		return plano.recorrerEnZigZag(unaPosicion,(Direccion) new SurEste());
	}
	@Override
	public void destruirCiudad(Plano plano) {
		GeneradorPosicionDeterminista unGeneradorPosicionDeterminsta = new GeneradorPosicionDeterminista(plano.obtenerAncho(),plano.obtenerAlto()); 
		Posicion posicionAleatoriaEnElBorde = unGeneradorPosicionDeterminsta.generarPosicionEnBordePlano();
		Recorrido zonaRecorridaPorGodzilla = this.recorridoDeGodzilla(plano, posicionAleatoriaEnElBorde);
		
		while (zonaRecorridaPorGodzilla.tieneSiguiente()){
			Hectarea hectareaActual = zonaRecorridaPorGodzilla.siguiente();
			
			if(hectareaActual.poseeConstruccion()){
				hectareaActual.obtenerConstruccion().destruir();
				edificiosRotos.add((Reconstruible)hectareaActual.obtenerConstruccion());
			}
		}
	
	}

}
