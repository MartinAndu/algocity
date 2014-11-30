package Jugador;

import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import PlanoGeneral.PlanoDeterminista;
import Poblacion.PoblacionMedia;
import Presupuesto.PresupuestoMedio;


public class JugadorParaTest extends Jugador {
	
	public JugadorParaTest() {
		this.plano = new PlanoDeterminista(16, 16);
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}

}
