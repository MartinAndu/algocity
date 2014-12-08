package controlador;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralMineral extends BotonConstruccion{

	public BotonCentralMineral(Jugador jugadorModelo) {
		super("CentralMineral",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearCentralMineral(posicion);
	}

}
