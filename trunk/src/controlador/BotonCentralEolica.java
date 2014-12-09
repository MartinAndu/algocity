package controlador;

import java.awt.event.ActionEvent;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralEolica extends BotonConstruccion{

	public BotonCentralEolica(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("CentralEolica",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearCentralEolica(vista.getPosicion());
	}

}
