package aplicacion;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controlador.BotonIndustria;
import controlador.BotonLineasDeTension;
import controlador.BotonPozoDeAgua;
import controlador.BotonResidencia;
import controlador.BotonRutaPavimentada;
import controlador.BotonTuberiaDeAgua;
import Jugador.Jugador;


public class PanelDeConstruccion extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelDeConstruccion(Jugador jugadorModelo,PanelPlano panelPlano){
		this.setLayout(new GridLayout(6,1));
		this.add(new BotonResidencia(jugadorModelo,panelPlano));
		this.add(new BotonIndustria(jugadorModelo,panelPlano));
		this.add(new BotonPozoDeAgua(jugadorModelo,panelPlano));
		this.add(new BotonTuberiaDeAgua(jugadorModelo,panelPlano));
		this.add(new BotonRutaPavimentada(jugadorModelo,panelPlano));
		this.add(new BotonLineasDeTension(jugadorModelo,panelPlano));
	}
	
}
