package controlador;

import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonRutaPavimentada extends BotonConstruccion{
	
	
	public BotonRutaPavimentada(Jugador jugadorModelo,PanelPlano panelPlano) {
		super("RutaPavimentada",jugadorModelo,panelPlano);
		this.setToolTipText("Ruta Pavimentada $10");
		vistaNormal = true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void prepararAccion(Posicion posicion){
		jugadorModelo.crearRutaPavimentada(posicion);
	}	
}
