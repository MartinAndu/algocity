package aplicacion;

import Juego.AlgoCity;

public class Main {
	public static void main(String args[]){
		VistaControlador vistaControlador = new VistaControlador();
		AlgoCity algoCity = new AlgoCity();
		vistaControlador.arrancar(algoCity);
	}
}
