package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonTuberiaDeAgua extends BotonConstruccion{
	
	public BotonTuberiaDeAgua(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("TuberiaDeAgua",jugadorModelo,panelPlano);
		vistaNormal = false;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){		
		jugadorModelo.crearTuberiaDeAgua(vista.getPosicion());
	}	

}
