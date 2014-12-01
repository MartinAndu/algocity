package Edificios;

import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import PuntosConstruccion.PuntosDePozo;

public class PozoDeAgua extends Construccion {

	static int COSTO_CONSTRUCCION = 250;
	static int CONSUMO_ELECTRICO = 0;
	static String servicioQueTransmite="agua";
	int radioDeDistribucion=1;
	boolean conectadoALaRed=true;
	
	public PozoDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.puntosDeConstruccion = new PuntosDePozo();
		
		
	}
	
	@Override
	public int devolverConsumo() {
		return CONSUMO_ELECTRICO;
	}
	
	public void construirSobrePlano(Plano unPlano){
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerPozoDeAgua(this);
		proveerServicioZona(unPlano);
	}
	
	
	public void proveerServicioZona(Plano unPlano){
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
			hectareaActual.habilitarServicio(servicioQueTransmite);
		}
	}
	
	public void destruir(){
		//Godzilla no destruye el pozo de agua
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		// Terremoto no destruye el pozo de agua
		
	}
}
