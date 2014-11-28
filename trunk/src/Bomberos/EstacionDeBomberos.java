package Bomberos;

import java.util.ArrayList;
import java.util.List;

import Edificios.Reconstruible;
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
	
	public void agregarReconstruible(Reconstruible unReconstruible) {
		edificiosAReconstruir.add(unReconstruible);
	}

	public void realizarReparaciones() {
		if (!estacionHabilitada) {
			return;
		}
		
		for(Reconstruible edificioAReconstruir: edificiosAReconstruir){
			edificioAReconstruir.reconstruir(puntosDeReconstruccion);
		}
	}

	public void habilitar(Presupuesto presupuesto) {
		presupuesto.reducirPresupuesto(this.costoDeHabilitacion);
		this.estacionHabilitada = true;
	}
}
