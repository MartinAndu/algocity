package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonLineasDeTension extends BotonConstruccion{
	
	public BotonLineasDeTension(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("LineaDeTension",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearLineaDeTension(vista.getPosicion());
	}
}
