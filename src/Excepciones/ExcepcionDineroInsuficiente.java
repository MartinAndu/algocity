package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionDineroInsuficiente extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8111324956381205739L;

	public ExcepcionDineroInsuficiente(){
		JOptionPane.showMessageDialog(null, "No hay dinero suficiente para efectual la construccion");
	}
}
