package PlanoGeneral;

import java.util.ArrayList;
import java.util.Iterator;

public class Recorrido {
	
	private Iterator<Hectarea> iterador;
	
	public Recorrido(ArrayList<Hectarea> recorrido) {
		
		this.iterador = recorrido.iterator();
	}
	
	public boolean tieneSiguiente() {

		return iterador.hasNext();
	}
	
	public Hectarea siguiente() {
		
		return iterador.next();
	}

}
