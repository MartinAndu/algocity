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
		double porcentajeDouble = porcentajeAIncrementar;
		porcentajeDouble = (porcentajeAIncrementar / 100.0);
		int cantHabitantesASumar = (int) (this.cantHabitantesCiudad * porcentajeDouble);
		this.cantHabitantesCiudad = cantHabitantesASumar + this.cantHabitantesCiudad;
	}

	public int obtenerCantHabitantes() {
		return this.cantHabitantesCiudad;
	}

}
