package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionNoSePuedeConstruirEnEsteTerreno extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionNoSePuedeConstruirEnEsteTerreno(){
		JOptionPane.showMessageDialog(null, "No se puede construir sober este terreno");
	}

}
