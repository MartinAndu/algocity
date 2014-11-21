package Jugador;

import Poblacion.PoblacionMedia;


public class JugadorMedio extends Jugador {
	
	public JugadorMedio() {
		super();
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
	}

}
