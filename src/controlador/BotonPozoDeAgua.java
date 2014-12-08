package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonPozoDeAgua extends BotonConstruccion{
	public BotonPozoDeAgua(Jugador jugadorModelo) {
		super("PozoDeAgua",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearPozoDeAgua(posicion);
	}
}
