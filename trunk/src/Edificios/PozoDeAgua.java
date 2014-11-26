package Edificios;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class PozoDeAgua extends Construccion{

	static int COSTO_CONSTRUCCION = 250;
	static int CONSUMO_ELECTRICO = 0;
	
	public PozoDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		
		costoDeConstruccion = COSTO_CONSTRUCCION;
	}
	
	public boolean esConstruibleSobreTierra(){
		return false;
	}
	
	public boolean esConstruibleSobreAgua(){
		return true;
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
					hectareaActual.habilitarAgua();
		}
	}
	
	public void destruir(){
		//Godzilla no destruye el pozo de agua
	}
}
