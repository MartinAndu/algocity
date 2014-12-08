package aplicacion;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controlador.BotonPozoDeAgua;
import controlador.BotonResidencia;
import Jugador.Jugador;


public class PanelDeConstruccion extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelDeConstruccion(Jugador jugadorModelo){
		this.setLayout(new GridLayout(6,1));
		this.add(new BotonResidencia(jugadorModelo));
		this.add(new BotonPozoDeAgua(jugadorModelo));
	}
	
}
