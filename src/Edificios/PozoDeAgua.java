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
		int radioDeDistribucion=1;
		
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarServicio("agua");
		}
	}
	
	public void destruir(){
		//Godzilla no destruye el pozo de agua
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		// TODO Auto-generated method stub
		
	}
}
