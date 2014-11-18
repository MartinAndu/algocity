package PlanoGeneral;

import java.util.ArrayList;
import java.util.Iterator;

public class Recorrido {
	
	private Iterator<Hectarea> iterador;
	private int longDelRecorrido;
	
	public Recorrido(ArrayList<Hectarea> recorrido) {
		
		this.longDelRecorrido =recorrido.size();
		this.iterador = recorrido.iterator();
	}
	
	public boolean tieneSiguiente() {

		return iterador.hasNext();
	}
	
	public Hectarea siguiente() {
		
		return iterador.next();
	}
	
	public int longDelRecorridoEnHectareas() {
		
		return this.longDelRecorrido;
	}

}
