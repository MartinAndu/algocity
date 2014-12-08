package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonComercio extends BotonConstruccion{

	public BotonComercio(Jugador jugadorModelo) {
		super("EdificioComercial",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearComercio(posicion);
	}

}
