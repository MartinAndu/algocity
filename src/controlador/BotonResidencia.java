package controlador;

import java.awt.event.ActionEvent;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonResidencia extends BotonConstruccion{

	
	public BotonResidencia(Jugador jugadorModelo) {
		super("EdificioResidencial",jugadorModelo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(Posicion posicion){
		jugadorModelo.crearResidencia(posicion);
	}


	
}
