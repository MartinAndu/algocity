package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonComercio extends BotonConstruccion{

	public BotonComercio(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("EdificioComercial",jugadorModelo,panelPlano);
		this.setToolTipText("Edificio Comercial $5");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearComercio(posicion);
	}

}
