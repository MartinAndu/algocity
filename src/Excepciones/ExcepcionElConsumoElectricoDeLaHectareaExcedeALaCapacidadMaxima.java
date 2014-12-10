package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionElConsumoElectricoDeLaHectareaExcedeALaCapacidadMaxima extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionElConsumoElectricoDeLaHectareaExcedeALaCapacidadMaxima(){
		JOptionPane.showMessageDialog(null, "El consumo de la hectarea está sobrecargando la central");
	}
}
