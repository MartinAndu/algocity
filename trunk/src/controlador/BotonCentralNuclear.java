package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralNuclear extends BotonConstruccion{
	
	public BotonCentralNuclear(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("CentralNuclear",jugadorModelo,panelPlano);
		this.setToolTipText("Central Nuclear $10000");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearCentralNuclear(posicion);
	}
}
