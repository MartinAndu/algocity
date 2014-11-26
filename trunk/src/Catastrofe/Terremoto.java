package Catastrofe;

import java.util.ArrayList;


import Edificios.Posicion;
import Edificios.Reconstruible;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;


public class Terremoto extends Catastrofe{
	
	ArrayList<Reconstruible> edificiosRotos;
	
	
	
	public Terremoto(){
		edificiosRotos = new ArrayList<Reconstruible>();
	}
	
	public void destruirCiudad(Plano plano) {
		Posicion posicionAleatoria=plano.generarPosicionAleatoria();
		int distanciaDeImpacto=67;
		int danioAInflingir=3; 
		
			Recorrido zonaCircundante= plano.recorrerZonaCircundante(posicionAleatoria, distanciaDeImpacto);//
			Hectarea hectareaActual;
			edificiosRotos.clear();//borra los edificios rotos de antes pues pueden haber sido reparados ya.
			while (zonaCircundante.tieneSiguiente()){
				hectareaActual=zonaCircundante.siguiente();
				if(hectareaActual.poseeConstruccion()){

					hectareaActual.obtenerConstruccion().recibirDanio(200-danioAInflingir*zonaCircundante.distanciaDesdeDondeParti());
					edificiosRotos.add((Reconstruible)hectareaActual.obtenerConstruccion());
				}
			}
	}
	
	public ArrayList<Reconstruible> edificiosRotos(){
		
		return edificiosRotos;
	}
}
