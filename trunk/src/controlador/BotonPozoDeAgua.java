package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonPozoDeAgua extends BotonConstruccion{
	
	public BotonPozoDeAgua(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("PozoDeAgua",jugadorModelo,panelPlano);
		this.setToolTipText("Pozo de Agua $250");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearPozoDeAgua(posicion);
	}
}
