package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionHectareaYaContieneUnaConstruccion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionHectareaYaContieneUnaConstruccion(){
		JOptionPane.showMessageDialog(null, "La hectárea ya contiene una construccion");
	}
}
