package Jugador;

public abstract class Presupuesto {
	protected int cantidadDeDinero;
	
	public int obtenerCantidadDeDinero(){
		return cantidadDeDinero;
	}
	
	public boolean alcanzaPara(int unCostoDeConstruccion){
		return (cantidadDeDinero >= unCostoDeConstruccion);
	}

	public void reducirPresupuesto(int unGasto){
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
