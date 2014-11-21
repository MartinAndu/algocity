package Jugador;

import Bomberos.EstacionDeBomberos;
import Catastrofe.Catastrofe;
import PlanoGeneral.Plano;
import Poblacion.Poblacion;

public abstract class Jugador {

	protected Poblacion poblacion;
	protected Presupuesto presupuesto;
	private Plano plano;
	private EstacionDeBomberos estacionDeBomberos;
	
	public Jugador() {
		this.plano = new Plano(640, 480);
		this.estacionDeBomberos = new EstacionDeBomberos();
	}

	public int obtenerPoblacionSinHogar() {
		return poblacion.cantHabitantesSinHogar();
	}

	public void poblacionSeIncrementoEnPorcetaje(int porcentajeDeIncrementoPoblacional) {
		poblacion.incrementar(porcentajeDeIncrementoPoblacional);
		
	}

	public int obtenerPresupuesto() {
		return presupuesto.obtenerCantidadDeDinero();
	}

	public void huboUnaCatastrofe(Catastrofe catastrofe) {
		catastrofe.destruirCiudad(this.plano);
	}

	public void habilitarEstacionDeBomberos() {
		this.estacionDeBomberos.habilitar();		
	}

	public void pasoUnTurno() {
		this.estacionDeBomberos.realizarReparaciones();	
	}

	public void seCobraUnaComisionPorHabitante(int comisionPorHabitante) {
		int comisionTotal = comisionPorHabitante * this.poblacion.obtenerCantHabitantes();
		this.presupuesto.reducirPresupuesto(comisionTotal);
	}

	public void presupuestoSeIncrementoEnPorcentaje(int porcentaje) {
		this.presupuesto.incrementarEnPorcentaje(porcentaje);
	}


}
