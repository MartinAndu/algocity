package PlanoGeneral;

import java.util.ArrayList;
import java.util.Iterator;

public class Recorrido {
	
	private Iterator<Hectarea> iterador;
	private ArrayList<Hectarea> recorrido;
	private ArrayList<Integer> distancias;
	private Iterator<Integer> iteradorEnDistancias;
	private Integer distanciaMasAlejada;
	private Integer distanciaDesdeDondeParti;
	
	public Recorrido() {
		this.recorrido = new ArrayList<Hectarea>();
		this.distancias = new ArrayList<Integer>();
		this.iterador = recorrido.iterator();
		this.iteradorEnDistancias = distancias.iterator();
		this.distanciaMasAlejada = 0;
		this.distanciaDesdeDondeParti = 0;
	}
	
	public boolean tieneSiguiente() {

		return iterador.hasNext();
	}
	
	public Hectarea siguiente() {
		try {
			this.distanciaDesdeDondeParti = iteradorEnDistancias.next();
			return iterador.next();
		} catch (Exception e) {
			this.iterador = recorrido.iterator();
			this.iteradorEnDistancias = distancias.iterator();
			this.distanciaDesdeDondeParti = iteradorEnDistancias.next();
			return iterador.next();
		}
		
	}
	
	public int longDelRecorridoEnHectareas() {
		
		return this.recorrido.size();
	}

	public void agregar(Hectarea hectarea) {
		
		this.distanciaMasAlejada++;
		this.distancias.add(this.distanciaMasAlejada);
		this.recorrido.add(hectarea);
	}
	
	public void agregar(ArrayList<Hectarea> hectareas) {
		
		this.distanciaMasAlejada++;
		
		for (int i = 0; i < hectareas.size(); i++) {
			this.distancias.add(this.distanciaMasAlejada);
		}
		this.recorrido.addAll(hectareas);
	}
	
	public int distanciaDesdeDondeParti() {
		
		return distanciaDesdeDondeParti;
	}

}
