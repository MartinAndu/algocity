package Bomberos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ConstruccionGeneral.Reconstruible;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import Presupuesto.Presupuesto;


/*
 * Lista de puntosMaximosDeConstruccion segun el tipo de construccion:
 * Edificios residenciales:10% - 10000 puntos
 * Edificios comerciales:7% - 14285 puntos
 * Edificios industriales:3% - 33333 puntos
 * Centrales electricas eolicas:15% - 6666 puntos
 * Centrales electricas minerales:10% - 10000 puntos
 * Centrales electricas nucleares: 3% - 33333 puntos
 * Otros: A elegir cualquiera (multiplos de 1000). 
 * 
 */

public class EstacionDeBomberos {
	List<Reconstruible> edificiosAReconstruir;
	
	int puntosDeReconstruccion=1000;
	private int costoDeHabilitacion;
	private boolean estacionHabilitada;
	
	public EstacionDeBomberos(){
		this.costoDeHabilitacion = 1500;
		edificiosAReconstruir = new ArrayList<Reconstruible>();
		estacionHabilitada = false;
	}
	
	public void agregarReconstruibles(ArrayList<Reconstruible> reconstruibles) {
		edificiosAReconstruir.addAll(reconstruibles);
	}

	public void realizarReparaciones() {
		if (!estacionHabilitada) {
			return;
		}
		List<Reconstruible> reparados = new ArrayList<Reconstruible>();

		Iterator<Reconstruible> it = this.edificiosAReconstruir.iterator();
		
		while (it.hasNext()) {
			Reconstruible reconstruible = (Reconstruible) it.next();
			try {
				reconstruible.reconstruir(puntosDeReconstruccion);
			} catch (ExceptionConstruccionComplemtamenteReparada e) {
				reparados.add(reconstruible);
			}
		}
		
		Iterator<Reconstruible> itR = reparados.iterator();
		while (itR.hasNext()) {
			Reconstruible reconstruible = (Reconstruible) itR.next();
			this.edificiosAReconstruir.remove(reconstruible);
		}
	}

	public void habilitar(Presupuesto presupuesto) {
		presupuesto.reducir(this.costoDeHabilitacion);
		this.estacionHabilitada = true;
	}
}
