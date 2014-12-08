package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonIndustria extends BotonConstruccion{
	
	public BotonIndustria(Jugador jugadorModelo) {
		super("EdificioIndustrial",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearIndustria(posicion);
	}

}
