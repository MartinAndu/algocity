package Catastrofe;

import Bomberos.EstacionDeBomberos;
import Edificios.Posicion;
import Edificios.Reconstruible;
import PlanoGeneradores.GeneradorPosicionDeterminista;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

/*
 * Hay que pasarle la estacion de bomberos de alguna forma y las dimensiones del plano
 */

public class Terremoto extends Catastrofe{
	int alto;
	int ancho;
	
	public Terremoto(/*int altoDePlano,int anchoDePlano*/){
		alto=6;//altoDePlano;
		ancho=6;//anchoDePlano;
		//Habria que pasarle por referencia las dimensiones del plano
	}
	public void destruirCiudad(Plano plano) {
		Posicion posicionAleatoria=(new GeneradorPosicionDeterminista(alto,ancho)).generarPosicion();
		int distanciaDeImpacto=67;
		int danioAInflingir=3; 
		EstacionDeBomberos unaEstacionDeBomberos=new EstacionDeBomberos();//Esto se saca, hay que pasarle por referencia en algun lugar quien es la estacion de bomberos.
			Recorrido zonaCircundante= plano.recorrerZonaCircundante(posicionAleatoria, distanciaDeImpacto);//


			while (zonaCircundante.tieneSiguiente()){
				Hectarea hectareaActual=zonaCircundante.siguiente();
					if(hectareaActual.poseeConstruccion()){

						hectareaActual.obtenerConstruccion().recibirDanio(201-danioAInflingir*zonaCircundante.distanciaDesdeDondeParti());
						unaEstacionDeBomberos.agregarReconstruible((Reconstruible)hectareaActual.obtenerConstruccion());
					}
			}
	}
}
