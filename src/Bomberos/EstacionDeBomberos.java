package Bomberos;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Reconstruible;

public class EstacionDeBomberos {
	ArrayList<Reconstruible> edificiosAReconstruir;
	protected int costoDeConstruccion;
	
	public EstacionDeBomberos(){
		edificiosAReconstruir = new ArrayList<Reconstruible>();
	}
	
	public void agregarReconstruible(Reconstruible unReconstruible) {
		edificiosAReconstruir.add(unReconstruible);
	}

	public void realizarReparaciones() {
		Iterator<Reconstruible> it = edificiosAReconstruir.iterator();
		while(it.hasNext()){
			Reconstruible edificioAReconstruir = (Reconstruible)it.next();
			edificioAReconstruir.reconstruir();
		}
	}
}
