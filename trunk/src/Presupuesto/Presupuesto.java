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
		
		String tipoPresupuesto = (this.getClass()).getSimpleName();
		
		elementoPresupuesto.setAttribute("dinero", Integer.toString(this.cantidadDeDinero));
		elementoPresupuesto.setAttribute("tipoPresupuesto", tipoPresupuesto);
		
		return elementoPresupuesto;
	}

	public static Presupuesto hidratar(Node elementoPresupuesto) {
		String tipoPresupuesto = ((Element)elementoPresupuesto).getAttribute("tipoPresupuesto");
		
		Presupuesto nuevoPresupuesto = null;
		
		if(tipoPresupuesto.equals("PresupuestoAlto")){
			nuevoPresupuesto = new PresupuestoAlto();
		}
		else if(tipoPresupuesto.equals("PresupuestoMedio")){
			nuevoPresupuesto = new PresupuestoMedio();
		}
		else if(tipoPresupuesto.equals("PresupuestoBajo")){
			nuevoPresupuesto = new PresupuestoBajo();
		}
		
		nuevoPresupuesto.cantidadDeDinero = Integer.parseInt( ((Element)elementoPresupuesto).getAttribute("dinero") );
		
		return nuevoPresupuesto;
	}

	public void reducirEnPorcentaje(int porcentajeDeReduccion) {
		double porcentajeDouble = porcentajeDeReduccion;
		porcentajeDouble = porcentajeDouble / 100.0;
		int cantDinearoARestar = (int) (this.cantidadDeDinero * porcentajeDouble);
		this.cantidadDeDinero += cantDinearoARestar;		
	}
}
