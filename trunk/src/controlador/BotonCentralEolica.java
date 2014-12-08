package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralEolica extends BotonConstruccion{

	public BotonCentralEolica(Jugador jugadorModelo) {
		super("CentralEolica",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearCentralEolica(posicion);
	}

}
