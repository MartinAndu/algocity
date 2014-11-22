package Bomberos;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Reconstruible;
import Jugador.Presupuesto;

public class EstacionDeBomberos {
	ArrayList<Reconstruible> edificiosAReconstruir;
	int puntosDeReconstruccion=3;
	private Presupuesto presupuesto;
	
	public EstacionDeBomberos(Presupuesto presupuesto){
		this.presupuesto = presupuesto;
		edificiosAReconstruir = new ArrayList<Reconstruible>();
	}
	
	public void agregarReconstruible(Reconstruible unReconstruible) {
		edificiosAReconstruir.add(unReconstruible);
	}

	public void realizarReparaciones() {
		Iterator<Reconstruible> it = edificiosAReconstruir.iterator();
		for(Reconstruible edificioAReconstruir:it){
			edificioAReconstruir.reconstruir(puntosDeReconstruccion);
		}
	}

	public void habilitar() {
		//debe comunicarse con presupuesto para saber si es posible su habilitacion.
		//comienza a reparar en el siguiente turno.
	}
}
