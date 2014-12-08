package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonLineasDeTension extends BotonConstruccion{
	
	public BotonLineasDeTension(Jugador jugadorModelo) {
		super("LineaDeTension",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearLineaDeTension(posicion);
	}
}
