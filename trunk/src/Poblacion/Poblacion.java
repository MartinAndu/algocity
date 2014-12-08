package Poblacion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class Poblacion {

	protected int cantHabitantesCiudad;

	public void incrementar(int porcentajeAIncrementar) {
		double porcentajeDouble = porcentajeAIncrementar;
		porcentajeDouble = (porcentajeAIncrementar / 100.0);
		int cantHabitantesASumar = (int) (this.cantHabitantesCiudad * porcentajeDouble);
		this.cantHabitantesCiudad += cantHabitantesASumar;
	}

	public int darCantHabitantes() {
		return this.cantHabitantesCiudad;
	}

	public Node serializar(Document doc) {
		Element elementoPoblacion = doc.createElement("Poblacion");
		String tipoPoblacion = (this.getClass()).getSimpleName();
		
		elementoPoblacion.setAttribute("tipoPoblacion", tipoPoblacion);
		elementoPoblacion.setAttribute("cantidadHabiantes", Integer.toString(cantHabitantesCiudad));
		
		return elementoPoblacion;
	}

	public static Poblacion hidratar(Node elementoPoblacion) {
		String tipoPoblacion = ((Element) elementoPoblacion).getAttribute("tipoPoblacion");
		
		int cantidadDeHabitantes = Integer.parseInt( ((Element)elementoPoblacion).getAttribute("cantidadHabiantes") );
		
		Poblacion nuevaPoblacion = null;
		
		if(tipoPoblacion.equals("PoblacionMedia")){
			nuevaPoblacion = new PoblacionMedia();
		}
		
		nuevaPoblacion.cantHabitantesCiudad = cantidadDeHabitantes;
		
		return nuevaPoblacion;
	}

}
