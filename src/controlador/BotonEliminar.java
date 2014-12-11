package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import aplicacion.Archivo;
import aplicacion.Imagen;
import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonEliminar extends JButton implements ActionListener{
	Jugador jugadorModelo;
	PanelPlano referenciaAlPlano;
	protected boolean vistaNormal;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BotonEliminar(Jugador jugadorModelo,PanelPlano referenciaAlPlano) {
		super("");
		this.setPreferredSize(new Dimension(30,30));
		this.addActionListener(this);
		this.jugadorModelo = jugadorModelo;
		this.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonEliminar)));
		this.referenciaAlPlano = referenciaAlPlano; 
	}

	public void prepararAccion(Posicion posicion){
		this.jugadorModelo.eliminarConstruccion(posicion);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
