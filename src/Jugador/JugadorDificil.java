package Jugador;

import Ambientes.Ambiente;
import Ambientes.AmbienteHostil;
import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import PlanoGeneral.PlanoAleatorio;
import Poblacion.PoblacionAlta;
import Presupuesto.PresupuestoBajo;

public class JugadorDificil extends Jugador {

	public JugadorDificil() {
		super();
		this.plano = new PlanoAleatorio();
		this.poblacion = new PoblacionAlta();
		this.presupuesto = new PresupuestoBajo();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}
	@Override
	public Ambiente generarAmbiente() {
		return new AmbienteHostil(this);
	}

}
