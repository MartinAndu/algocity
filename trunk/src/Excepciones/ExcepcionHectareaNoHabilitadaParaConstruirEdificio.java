package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionHectareaNoHabilitadaParaConstruirEdificio extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionHectareaNoHabilitadaParaConstruirEdificio(){
		JOptionPane.showMessageDialog(null, "Esta hectarea no está habilitada para construir el edificio");
	}
}
