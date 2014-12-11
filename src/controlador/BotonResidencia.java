package controlador;

import java.awt.event.ActionEvent;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonResidencia extends BotonConstruccion{

	
	public BotonResidencia(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("EdificioResidencial",jugadorModelo,panelPlano);
		this.setToolTipText("Edificio Residencial $5");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearResidencia(posicion);
	}


	
}
