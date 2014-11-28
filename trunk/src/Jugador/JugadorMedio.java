package Jugador;

import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import Poblacion.PoblacionMedia;
import Presupuesto.PresupuestoMedio;


public class JugadorMedio extends Jugador {
	
	public JugadorMedio() {
		super();
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}

}
