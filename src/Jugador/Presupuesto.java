package Jugador;

import Excepciones.ExcepcionDineroInsuficiente;

public abstract class Presupuesto {
	protected int cantidadDeDinero;
	
	public int obtenerCantidadDeDinero(){
		return cantidadDeDinero;
	}
	
	public void reducirPresupuesto(int unGasto){
		if (unGasto > cantidadDeDinero) {
			throw new ExcepcionDineroInsuficiente();
		}
		cantidadDeDinero -= unGasto;
	}
	
	public void aumentarPresupuesto(int unaSuma){
		cantidadDeDinero += unaSuma;
	}

	public void incrementarEnPorcentaje(int porcentaje) {
		double porcentajeDouble = porcentaje;
		porcentajeDouble = porcentajeDouble / 100.0;
		int cantDinearoASumar = (int) (this.cantidadDeDinero * porcentajeDouble);
		this.cantidadDeDinero += cantDinearoASumar;
		
	}

}
