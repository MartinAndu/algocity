package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonComercio extends BotonConstruccion{

	public BotonComercio(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("EdificioComercial",jugadorModelo,panelPlano);
		this.setToolTipText("Edificio Comercial");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearComercio(vista.getPosicion());
	}

}
