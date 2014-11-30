package Presupuesto;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;




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

	public Node serializar(Document doc) {
		Element elementoPresupuesto = doc.createElement("Presupuesto");
		
		elementoPresupuesto.setAttribute("dinero", Integer.toString(this.cantidadDeDinero));
		
		return elementoPresupuesto;
	}

	public static Presupuesto hidratar(Node elementoPresupuesto) {
		Presupuesto nuevoPresupuesto = new PresupuestoAlto(); // No importa cual se instancie, porque el dinero se establece ahora...
		
		nuevoPresupuesto.cantidadDeDinero = Integer.parseInt( ((Element)elementoPresupuesto).getAttribute("dinero") );
		
		return nuevoPresupuesto;
	}

}
