package Excepciones;

import javax.swing.JOptionPane;


public class ExcepcionCentralElectricaNoPoseeRedDeAgua extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionCentralElectricaNoPoseeRedDeAgua(){
		JOptionPane.showMessageDialog(null, "La Central electrica no esta conectada a una red de agua");
	}

}
