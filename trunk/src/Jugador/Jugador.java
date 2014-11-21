package Jugador;

import Poblacion.Poblacion;

public abstract class Jugador {

	protected Poblacion poblacion;

	public Integer obtenerPoblacionSinHogar() {
		return poblacion.cantHabitantesSinHogar();
	}

	public void huboUnIncrementoEnLaPoblacion(Poblacion poblacionInmigrante) {
		poblacion.incrementar(poblacionInmigrante);
		
	}

	public Integer obtenerPresupuesto() {
		// TODO Auto-generated method stub
		return null;
	}

}
