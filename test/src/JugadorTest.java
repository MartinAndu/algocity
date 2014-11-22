package src;

import static org.junit.Assert.*;
import org.junit.Test;
import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import Edificios.Posicion;
import Jugador.Jugador;
import Jugador.JugadorMedio;


public class JugadorTest {

	@Test
	public void jugadorIncrementoSuPoblacionSeVerificaSiHayGenteSinHogar() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(500, jugador.obtenerPoblacionSinHogar());
		
		jugador.poblacionSeIncrementoEnPorcetaje(50);
		
		assertEquals(750, jugador.obtenerPoblacionSinHogar());

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
		
		assertEquals(0, jugador.obtenerPresupuesto());

	}
	
	@Test
	public void jugadorSeAproboUnNuevoPresupuestoParaLaCiudad() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto());
		
		jugador.presupuestoSeIncrementoEnPorcentaje(50);
		
		assertEquals(7500, jugador.obtenerPresupuesto());
	}
	
	@Test
	public void jugadorCrearUnPozoDeAgua() {
		
		Jugador jugador = new JugadorMedio();
		
		assertEquals(5000, jugador.obtenerPresupuesto());
		
		Posicion posicion = new Posicion(2, 2);
		
		jugador.crearPozoDeAgua(posicion);
		
		assertEquals(4750, jugador.obtenerPresupuesto());
		
	}
}
