package controlador;

import java.awt.event.ActionEvent;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonResidencia extends BotonConstruccion{

	
	public BotonResidencia(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("EdificioResidencial",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearResidencia(vista.getPosicion());
	}


	
}
