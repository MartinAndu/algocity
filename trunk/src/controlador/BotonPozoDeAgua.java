package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonPozoDeAgua extends BotonConstruccion{
	
	public BotonPozoDeAgua(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("PozoDeAgua",jugadorModelo,panelPlano);
		this.setToolTipText("Pozo de Agua");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearPozoDeAgua(vista.getPosicion());
	}
}
