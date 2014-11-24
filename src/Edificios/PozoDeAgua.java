package Edificios;

import Conectores.ConexionDeAgua;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class PozoDeAgua extends Construccion{

	static int COSTO_CONSTRUCCION = 250;
	static int CONSUMO_ELECTRICO = 0;
	
	public PozoDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		posicionConstruccion = unaPosicion;
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
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
		int radioDeDistribucion=3;
		
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAgua();
		}
	}
}
