package controlador;

import aplicacion.PanelPlano;
import vista.VistaModeloDato;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonRutaPavimentada extends BotonConstruccion{
	
	
	public BotonRutaPavimentada(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("RutaPavimentada",jugadorModelo,panelPlano);
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararConstruccion(VistaModeloDato vista){
		jugadorModelo.crearRutaPavimentada(vista.getPosicion());
	}	
}
