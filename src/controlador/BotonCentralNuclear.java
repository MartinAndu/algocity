package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonCentralNuclear extends BotonConstruccion{
	
	public BotonCentralNuclear(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("CentralNuclear",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearCentralNuclear(vista.getPosicion());
	}
}
