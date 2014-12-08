package Jugador;

import Ambientes.Ambiente;
import Ambientes.AmbienteDeterministico;
import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import PlanoGeneral.PlanoDeterminista;
import Poblacion.PoblacionMedia;
import Presupuesto.PresupuestoMedio;


public class JugadorParaTest extends Jugador {
	
	public JugadorParaTest() {
		super();
		this.plano = new PlanoDeterminista();
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}

	@Override
	public Ambiente generarAmbiente() {
		return new AmbienteDeterministico(this);
	}

}
