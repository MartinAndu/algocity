package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import aplicacion.Archivo;
import aplicacion.Imagen;
import aplicacion.PanelPlano;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;

public class BotonEliminar extends BotonInteraccionPanel implements ActionListener{
	Jugador jugadorModelo;
	PanelPlano referenciaAlPlano;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BotonEliminar(Jugador jugadorModelo,PanelPlano referenciaAlPlano) {
		this.setPreferredSize(new Dimension(30,30));
		this.addActionListener(this);
		this.jugadorModelo = jugadorModelo;
		this.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonEliminar)));
		this.setToolTipText("Eliminar Construccion");
		this.referenciaAlPlano = referenciaAlPlano; 
	}

	public void prepararAccion(Posicion posicion){
		this.jugadorModelo.eliminarConstruccion(posicion);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.jugadorModelo.darControlador().establecerBotonConstruccionPresionado(this);
	}

}
