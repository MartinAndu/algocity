package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonIndustria extends BotonConstruccion{
	
	public BotonIndustria(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("EdificioIndustrial",jugadorModelo,panelPlano);
		this.setToolTipText("Edificio Industrial $10");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearIndustria(posicion);
	}

}
