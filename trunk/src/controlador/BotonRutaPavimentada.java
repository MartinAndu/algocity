package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonRutaPavimentada extends BotonConstruccion{
	
	
	public BotonRutaPavimentada(Jugador jugadorModelo) {
		super("RutaPavimentada",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearRutaPavimentada(posicion);
	}	
}
