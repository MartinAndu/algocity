package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionHectareaNoBrindaLosServiciosNecesarios extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionHectareaNoBrindaLosServiciosNecesarios(){
		JOptionPane.showMessageDialog(null, "No se puefe efectuar la construccion porque faltan los servicios necesarios");
	}
}
