package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionJugadorYaExistente extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1074725800231710726L;
	
	public ExcepcionJugadorYaExistente(){
		JOptionPane.showMessageDialog(null, "Jugador ya existente");
	}

}
