package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionJugadorIngresadoVacio extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6413983492775960569L;
	
	public ExcepcionJugadorIngresadoVacio(){
		JOptionPane.showMessageDialog(null, "No puede ingresar un nombre vacio o de menos de 4 caracteres");
	}
}
