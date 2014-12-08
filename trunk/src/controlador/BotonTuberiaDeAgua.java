package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonTuberiaDeAgua extends BotonConstruccion{
	
	public BotonTuberiaDeAgua(Jugador jugadorModelo) {
		super("RutaPavimentada",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearTuberiaDeAgua(posicion);
	}	

}
