package Jugador;

import Bomberos.EstacionDeBomberos;
import Poblacion.PoblacionMedia;


public class JugadorMedio extends Jugador {
	
	public JugadorMedio() {
		super();
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
		this.constructor = new ConstructorMedio(this.presupuesto);
		this.estacionDeBomberos = new EstacionDeBomberos(this.presupuesto);
	}

}
