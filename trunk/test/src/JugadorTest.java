package src;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;


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
		
		assertEquals(5000, jugador.obtenerPresupuesto);
		
		Catastrofe catastrofe = new Godzilla();
		jugador.huboUnaCatastrofe(catastrofe);
		jugador.pasoUnTurno();
		
		assertEquals(4500, jugador.obtenerPresupuesto);

	}
	
	@Test
	public void jugadorSeCobraUnaComisionPorHabitante() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto);
		
		jugador.seCobraUnaComisionPorHabitante(10);
		jugador.pasoUnTurno();
		
		assertEquals(3000, jugador.obtenerPresupuesto);

	}
	
	@Test
	public void jugadorSeAproboUnNuevoPresupuestoParaLaCiudad() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto);
		
		jugador.seAproboUnNuevoPresupuestoParaLaCiudad();
		
		assertEquals(7500, jugador.obtenerPresupuesto);
	}
	
	@Test
	public void jugadorSeAproboUnNuevoPresupuestoParaLaCiudad() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto);
		
		Presupuesto presupuesto = new PresupuestoEnAumento();
		
		jugador.seAproboUnNuevoPresupuestoParaLaCiudad(presupuesto);
		
		assertEquals(7500, jugador.obtenerPresupuesto);
	}
}
