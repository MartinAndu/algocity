package Bomberos;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Reconstruible;
import Jugador.Presupuesto;

public class EstacionDeBomberos {
	ArrayList<Reconstruible> edificiosAReconstruir;
	
	int puntosDeReconstruccion=3;
	private Presupuesto presupuesto;
	private int costoDeHabilitacion;
	
	public EstacionDeBomberos(Presupuesto presupuesto){
		this.presupuesto = presupuesto;
		this.costoDeHabilitacion = 1500;
		edificiosAReconstruir = new ArrayList<Reconstruible>();
	}
	
	public void agregarReconstruible(Reconstruible unReconstruible) {
		edificiosAReconstruir.add(unReconstruible);
	}

	public void realizarReparaciones() {
		Iterator<Reconstruible> it = edificiosAReconstruir.iterator();
		
		while (it.hasNext())
			((Reconstruible) it).reconstruir(puntosDeReconstruccion);
	}

	public void habilitar() {
		if (this.presupuesto.alcanzaPara(costoDeHabilitacion)) {
			this.presupuesto.reducirPresupuesto(costoDeHabilitacion);
		}
	}
}
