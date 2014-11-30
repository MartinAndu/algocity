package Jugador;

import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import PlanoGeneral.PlanoAleatorio;
import Poblacion.PoblacionMedia;
import Presupuesto.PresupuestoMedio;

public class JugadorMedio extends Jugador {

	public JugadorMedio() {
		this.plano = new PlanoAleatorio(16, 16);
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}
}