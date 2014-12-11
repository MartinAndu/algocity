package aplicacion;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controlador.BotonBomberos;
import controlador.BotonCentralEolica;
import controlador.BotonCentralMineral;
import controlador.BotonCentralNuclear;
import controlador.BotonComercio;
import controlador.BotonEliminar;
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
		this.setLayout(new GridLayout(12,2));
		this.add(new BotonResidencia(jugadorModelo,panelPlano));
		this.add(new BotonIndustria(jugadorModelo,panelPlano));
		this.add(new BotonComercio(jugadorModelo,panelPlano));
		this.add(new BotonPozoDeAgua(jugadorModelo,panelPlano));
		this.add(new BotonTuberiaDeAgua(jugadorModelo,panelPlano));
		this.add(new BotonRutaPavimentada(jugadorModelo,panelPlano));
		this.add(new BotonLineasDeTension(jugadorModelo,panelPlano));
		this.add(new BotonCentralNuclear(jugadorModelo,panelPlano));
		this.add(new BotonCentralEolica(jugadorModelo,panelPlano));
		this.add(new BotonCentralMineral(jugadorModelo,panelPlano));
		this.add(new BotonEliminar(jugadorModelo,panelPlano));
		this.add(new BotonBomberos(jugadorModelo,panelPlano));
	}
	
}
