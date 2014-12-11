package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonTuberiaDeAgua extends BotonConstruccion{
	
	public BotonTuberiaDeAgua(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("TuberiaDeAgua",jugadorModelo,panelPlano);
		this.setToolTipText("Tuberia de Agua $5");
		vistaNormal = false;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){		
		jugadorModelo.crearTuberiaDeAgua(posicion);
	}	

}
