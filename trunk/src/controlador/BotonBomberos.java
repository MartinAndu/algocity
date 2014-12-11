package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Jugador.Jugador;
import aplicacion.Archivo;
import aplicacion.Imagen;
import aplicacion.PanelPlano;

public class BotonBomberos extends JButton implements ActionListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Jugador jugadorModelo;
	PanelPlano referenciaAlPlano;
	protected boolean vistaNormal;

	
	
	public BotonBomberos(Jugador jugadorModelo,PanelPlano referenciaAlPlano) {
		super("");
		this.setPreferredSize(new Dimension(30,30));
		this.addActionListener(this);
		this.jugadorModelo = jugadorModelo;
		this.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonBomberos)));
		this.setToolTipText("Habilitar estacion de bomberos $1500");
		this.referenciaAlPlano = referenciaAlPlano; 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
