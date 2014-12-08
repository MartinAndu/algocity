package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralNuclear extends BotonConstruccion{
	
	public BotonCentralNuclear(Jugador jugadorModelo) {
		super("CentralNuclear",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearCentralNuclear(posicion);
	}
}
