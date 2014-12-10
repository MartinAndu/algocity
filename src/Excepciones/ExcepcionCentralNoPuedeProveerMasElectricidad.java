package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionCentralNoPuedeProveerMasElectricidad extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8111324956351205739L;
	
	public ExcepcionCentralNoPuedeProveerMasElectricidad(){
		JOptionPane.showMessageDialog(null, "La Central electrica no puede proveer más electricidad");
	}
}
