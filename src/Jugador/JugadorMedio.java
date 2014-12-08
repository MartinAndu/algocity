package Jugador;

import Ambientes.Ambiente;
import Ambientes.AmbienteEstable;
import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import PlanoGeneral.PlanoAleatorio;
import Poblacion.PoblacionMedia;
import Presupuesto.PresupuestoMedio;

public class JugadorMedio extends Jugador {

	public JugadorMedio() {
		super();
		this.plano = new PlanoAleatorio();
		this.poblacion = new PoblacionMedia();
		this.presupuesto = new PresupuestoMedio();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}

	@Override
	public Ambiente generarAmbiente() {
		return new AmbienteEstable(this);
	}

}
