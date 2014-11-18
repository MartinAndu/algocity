package PlanoGeneradores;

import Edificios.Posicion;
import PlanoGeneral.Plano;

public class GeneradorPosicionDeterminista extends GeneradorPosicion {

	@Override
	public Posicion generarPosicionEnBordePlano(Plano plano) {
		return new Posicion(1, 1);
	}

}
