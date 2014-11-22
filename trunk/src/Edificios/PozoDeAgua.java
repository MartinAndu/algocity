package Edificios;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class PozoDeAgua extends Construccion{

	static int COSTO_CONSTRUCCION = 250;
	static int CONSUMO_ELECTRICO = 0;
	
	public PozoDeAgua(Posicion unaPosicion){
		posicionConstruccion = unaPosicion;
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
	}
}
