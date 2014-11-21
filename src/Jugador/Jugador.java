package Jugador;

import Bomberos.EstacionDeBomberos;
import Catastrofe.Catastrofe;
import Edificios.Construccion;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import Edificios.Reconstruible;
import PlanoGeneral.Plano;
import Poblacion.Poblacion;

public abstract class Jugador {

	protected Poblacion poblacion;
	protected Presupuesto presupuesto;
	protected Plano plano;
	protected EstacionDeBomberos estacionDeBomberos;
	protected Constructor constructor;
	
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

	public void crearPozoDeAgua(Posicion posicion) {
		PozoDeAgua pozo = this.constructor.construirPozoDeAgua(posicion);
		pozo.construirSobrePlano(plano);	
	}
	
	public void crearResidencia(Posicion posicion) {
		EdificioResidencial residencia = this.constructor.construirZonaResidencial(posicion);
		residencia.construirSobrePlano(plano);
		this.asegurarSuReparacion(residencia);
		
	}
	
	private void asegurarSuReparacion(Construccion construccion) {
		Reconstruible reconstruible = (Reconstruible) construccion;
		this.estacionDeBomberos.agregarReconstruible(reconstruible);
	}


}
