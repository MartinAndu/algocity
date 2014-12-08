package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import aplicacion.Imagen;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public abstract class BotonConstruccion extends JButton implements ActionListener{
	
	Jugador jugadorModelo;

	
	public BotonConstruccion(String nombreDeLaConstruccion,Jugador jugadorModelo) {
		super("");
		this.setPreferredSize(new Dimension(30,30));
		this.addActionListener(this);
		this.jugadorModelo = jugadorModelo;
		this.setIcon(new ImageIcon(Imagen.loadImg("Images/Walls/" + nombreDeLaConstruccion + ".jpg")));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void prepararConstruccion(Posicion posicion);
	
	@Override
	public void actionPerformed(ActionEvent e){
		this.jugadorModelo.obtenerControlador().establecerBotonConstruccionPresionado(this);
	}

}
