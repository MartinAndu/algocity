package Poblacion;

public abstract class Poblacion {

	protected int capacidadHabitacionalCiudad;
	protected int cantHabitantesCiudad;

	public int cantHabitantesSinHogar() {
		if (this.capacidadHabitacionalCiudad >= this.cantHabitantesCiudad) {
			return 0;
		}else {
			return this.cantHabitantesCiudad - this.capacidadHabitacionalCiudad;
		}
	}

	public void incrementar(int porcentajeAIncrementar) {
		int cantHabitantesASumar = this.cantHabitantesCiudad * (porcentajeAIncrementar / 100);
		this.cantHabitantesCiudad += cantHabitantesASumar;
	}

	public int obtenerCantHabitantes() {
		return this.cantHabitantesCiudad;
	}

}
