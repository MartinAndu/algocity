package Excepciones;

import javax.swing.JOptionPane;

public class ExceptionConstruccionComplemtamenteReparada extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 56871033512000181L;

	public ExceptionConstruccionComplemtamenteReparada(){
		JOptionPane.showMessageDialog(null, "La Construccion est� completamente reparada");
	}
}