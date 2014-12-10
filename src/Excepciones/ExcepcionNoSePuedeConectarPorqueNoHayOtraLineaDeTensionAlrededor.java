package Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionNoSePuedeConectarPorqueNoHayOtraLineaDeTensionAlrededor extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionNoSePuedeConectarPorqueNoHayOtraLineaDeTensionAlrededor(){
		JOptionPane.showMessageDialog(null, "No se pueste establecer la conexion porque no hay lineas de tension alrededor");
	}

}
