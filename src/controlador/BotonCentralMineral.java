package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralMineral extends BotonConstruccion{

	public BotonCentralMineral(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("CentralMineral",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearCentralMineral(vista.getPosicion());
	}

}
