package Jugador;

import Bomberos.EstacionDeBomberos;

import Catastrofe.Catastrofe;
import CentralesElectricas.CentralMineral;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
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
		this.plano = new Plano(320, 240);
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
		this.estacionDeBomberos.habilitar(presupuesto);		
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
		this.presupuesto.reducirPresupuesto(pozo.devolverCosto());
	}
	
	public void crearResidencia(Posicion posicion) {
		EdificioResidencial residencia = this.constructor.construirZonaResidencial(posicion);
		this.agregarAlPlano(residencia);
	}

	public void crearLineaDeTension(Posicion posicion) {
		LineasDeTension linea = this.constructor.construirLineaDeTension(posicion);
		this.agregarAlPlano(linea);
	}
	
	public void crearTuberiaDeAgua(Posicion posicion) {
		ConexionDeAgua canio = this.constructor.construirTuberia(posicion);
		this.agregarAlPlano(canio);
	}
	
	public void crearCentralElectricaMineral(Posicion posicion) {
		CentralMineral central = this.constructor.construirCentralMineral(posicion);
		this.agregarAlPlano(central);
	}
	
	public void crearRutaPavimentada(Posicion posicion) {
		RutaPavimentada ruta = this.constructor.construirRuta(posicion);
		this.agregarAlPlano(ruta);
	}
	
	private void agregarAlPlano(Construccion construccion) {
		construccion.construirSobrePlano(this.plano);
		this.presupuesto.reducirPresupuesto(construccion.devolverCosto());
		this.estacionDeBomberos.agregarReconstruible((Reconstruible)construccion);
	}

}
