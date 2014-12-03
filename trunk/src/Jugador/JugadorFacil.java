package Jugador;

import Ambientes.Ambiente;
import Ambientes.AmbienteFavorable;
import Bomberos.EstacionDeBomberos;
import Constructor.ConstructorMedio;
import PlanoGeneral.PlanoAleatorio;
import Poblacion.PoblacionBaja;
import Presupuesto.PresupuestoAlto;

public class JugadorFacil extends Jugador {

	public JugadorFacil() {
		this.plano = new PlanoAleatorio();
		this.poblacion = new PoblacionBaja();
		this.presupuesto = new PresupuestoAlto();
		this.constructor = new ConstructorMedio();
		this.estacionDeBomberos = new EstacionDeBomberos();
	}
	@Override
	public Ambiente generarAmbiente() {
		return new AmbienteFavorable(this);
	}

}
