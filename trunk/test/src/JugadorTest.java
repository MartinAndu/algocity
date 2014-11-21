package src;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;

import Edificios.Posicion;
import Jugador.Jugador;
import Jugador.JugadorMedio;
import Poblacion.Poblacion;


public class JugadorTest {

	@Test
	public void jugadorIncrementoSuPoblacionSeVerificaSiHayGenteSinHogar() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(0, jugador.obtenerPoblacionSinHogar());
		
		Poblacion poblacion = new PoblacionInmigrante();
		jugador.huboUnIncrementoEnLaPoblacion(poblacion);
		
		assertEquals(200, jugador.obtenerPoblacionSinHogar());

	}
	
	@Test
	public void jugadorHuboUnaCatastrofeGodzillaSeReduceElPresupuestoPorRecuperarLaCiudad() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto());
		
		Catastrofe catastrofe = new Godzilla();
		jugador.huboUnaCatastrofe(catastrofe);
		jugador.habilitarEstacionDeBomberos();
		jugador.pasoUnTurno();
		
		assertEquals(3500, jugador.obtenerPresupuesto());

	}
	
	@Test
	public void jugadorSeCobraUnaComisionPorHabitante() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto());
		
		jugador.seCobraUnaComisionPorHabitante(10);
		jugador.pasoUnTurno();
		
		assertEquals(3000, jugador.obtenerPresupuesto());

	}
	
	@Test
	public void jugadorSeAproboUnNuevoPresupuestoParaLaCiudad() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto());
		
		jugador.seAproboUnNuevoPresupuestoParaLaCiudad();
		
		assertEquals(7500, jugador.obtenerPresupuesto());
	}
	
	//Concidero un Plano que cuyas superficies alternan al modo de tablero de ajedrez
	//entre superficies de agua y llanas.
	//Tambien concidero que la posicion de pruebas poseen la superficie requerida a menos que 
	//se especifique lo contrario.
			
	@Test
	public void jugadorConstruyeUnPozoDeAguaSobreUnaSuperficieDeAgua() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto());
		
		Posicion posicion = new Posicion(1, 1);
		jugador.construirPozoDeAgua(posicion);
		
		assertEquals(4750, jugador.obtenerPresupuesto());
	}
}
