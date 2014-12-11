package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralEolica extends BotonConstruccion{

	public BotonCentralEolica(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("CentralEolica",jugadorModelo,panelPlano);
		this.setToolTipText("Central Eolica $1000");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearCentralEolica(posicion);
	}

}
