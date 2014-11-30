package src;

import static org.junit.Assert.*;
import org.junit.Test;
import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import ConstruccionGeneral.Posicion;
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
		
		Posicion posicion = new Posicion(1, 2);
		
		jugador.crearPozoDeAgua(posicion);
		
		assertEquals(4750, jugador.obtenerPresupuesto());
		
	}
	
	@Test
	public void jugadorCrearDosTuberiasDeAgua() {
		
		Jugador jugador = new JugadorMedio();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);
		
		assertEquals(4745, jugador.obtenerPresupuesto());
		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		
		assertEquals(4740, jugador.obtenerPresupuesto());
	}
	
	@Test
	public void jugadorCrearUnaCentralElectrica() {
		
		Jugador jugador = new JugadorMedio();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		Posicion unaPosicionMas = new Posicion(1, 5);
		jugador.crearCentralElectricaMineral(unaPosicionMas);
		
		assertEquals(1740, jugador.obtenerPresupuesto());
	}
	
	@Test
	public void jugadorCrearDosRutasEncimaDeLasTuberias() {
		
		Jugador jugador = new JugadorMedio();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		Posicion unaPosicionMas = new Posicion(1, 5);
		jugador.crearCentralElectricaMineral(unaPosicionMas);
		jugador.crearRutaPavimentada(otraPosicion);
		jugador.crearRutaPavimentada(otraPosicionMas);
		
		assertEquals(1720, jugador.obtenerPresupuesto());
	}
	
	@Test
	public void jugadorCrearResidencia() {
		
		Jugador jugador = new JugadorMedio();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		Posicion unaPosicionMas = new Posicion(1, 5);
		jugador.crearCentralElectricaMineral(unaPosicionMas);
		jugador.crearRutaPavimentada(otraPosicion);
		jugador.crearRutaPavimentada(otraPosicionMas);
		Posicion posicionDeLaCasa = new Posicion(2, 3);
		jugador.crearResidencia(posicionDeLaCasa);
		
		assertEquals(1715, jugador.obtenerPresupuesto());
	}
	
}
