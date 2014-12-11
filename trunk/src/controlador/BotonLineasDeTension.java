package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonLineasDeTension extends BotonConstruccion{
	
	public BotonLineasDeTension(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("LineaDeTension",jugadorModelo,panelPlano);
		this.setToolTipText("Linea de Tension $5");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearLineaDeTension(posicion);
	}
}
