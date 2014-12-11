package aplicacion;

import javax.swing.JOptionPane;

import Juego.AlgoCity;

public class Main {
	public static void main(String args[]){
		VistaControlador vistaControlador = new VistaControlador();
		try{
			AlgoCity algoCity = new AlgoCity();
			vistaControlador.arrancar(algoCity);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error en el inicio del juego");
		}
	}
}
