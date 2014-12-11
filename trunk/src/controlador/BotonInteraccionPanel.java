package controlador;

import javax.swing.JButton;

import ConstruccionGeneral.Posicion;

public abstract class BotonInteraccionPanel extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void prepararAccion(Posicion posicion);
	
}
