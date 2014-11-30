package Poblacion;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
		this.cantHabitantesCiudad += cantHabitantesASumar;
	}

	public int obtenerCantHabitantes() {
		return this.cantHabitantesCiudad;
	}

	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Poblacion hidratar(Node item) {
		// TODO Auto-generated method stub
		return null;
	}

}
