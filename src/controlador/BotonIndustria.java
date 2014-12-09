package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonIndustria extends BotonConstruccion{
	
	public BotonIndustria(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("EdificioIndustrial",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearIndustria(vista.getPosicion());
	}

}
