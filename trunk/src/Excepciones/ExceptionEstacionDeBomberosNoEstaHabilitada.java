package Excepciones;

import javax.swing.JOptionPane;

public class ExceptionEstacionDeBomberosNoEstaHabilitada extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8604166595735703678L;

	public ExceptionEstacionDeBomberosNoEstaHabilitada(){
		JOptionPane.showMessageDialog(null, "La estaci�n de bomberos no est� habilitada");
	}
	
	
}
