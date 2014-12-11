package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import aplicacion.Imagen;
import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public abstract class BotonConstruccion extends BotonInteraccionPanel implements ActionListener{
	
	Jugador jugadorModelo;
	PanelPlano referenciaAlPlano;
	protected boolean vistaNormal;

	
	public BotonConstruccion(String nombreDeLaConstruccion,Jugador jugadorModelo,PanelPlano referenciaAlPlano) {
		this.setPreferredSize(new Dimension(100,30));
		this.addActionListener(this);
		this.jugadorModelo = jugadorModelo;
		this.setIcon(new ImageIcon(Imagen.loadImg("Images/Estructuras/" + nombreDeLaConstruccion + ".jpg")));
		this.referenciaAlPlano = referenciaAlPlano; 
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void prepararAccion(Posicion posicion);
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		referenciaAlPlano.establecerVistaNormal(vistaNormal);
		this.jugadorModelo.darControlador().establecerBotonConstruccionPresionado(this);
	}

}
