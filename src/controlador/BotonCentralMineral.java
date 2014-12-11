package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralMineral extends BotonConstruccion{

	public BotonCentralMineral(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("CentralMineral",jugadorModelo,panelPlano);
		this.setToolTipText("Central Mineral $3000");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearCentralMineral(posicion);
	}

}
