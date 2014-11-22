package Bomberos;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Reconstruible;
import Jugador.Presupuesto;


/*
 * Lista de puntosMaximosDeConstruccion segun el tipo de construccion:
 * Edificios residenciales:10% - 10000 puntos
 * Edificios comerciales:7% - 15000 puntos
 * Edificios industriales:3% - 34000 puntos
 * Centrales electricas eolicas:15% - 7000 puntos
 * Centrales electricas minerales:10% - 10000 puntos
 * Centrales electricas nucleares: 3% - 34000 puntos
 * Otros: A elegir cualquiera (multiplos de 1000). 
 * 
 */

public class EstacionDeBomberos {
	ArrayList<Reconstruible> edificiosAReconstruir;
	
	int puntosDeReconstruccion=1000;
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
