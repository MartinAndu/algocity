package src;

import static org.junit.Assert.*;
import org.junit.Test;
import Catastrofe.Catastrofe;
import Catastrofe.Godzilla;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;
import Jugador.JugadorParaTest;


public class JugadorTest {
	
	@Test
	public void jugadorHuboUnaCatastrofeGodzillaSeReduceElPresupuestoPorRecuperarLaCiudad() {
		
		Jugador jugador = new JugadorParaTest();
		
		assertEquals(5000, jugador.darCantDineroEnPresupuesto());
		
		Catastrofe catastrofe = new Godzilla();
		jugador.destruirConstruccionesPorCatastrofe(catastrofe);
		jugador.habilitarEstacionDeBomberos();
		jugador.pasoUnTurno();
		
		assertEquals(3500, jugador.darCantDineroEnPresupuesto());
	}
	
	@Test
	public void jugadorSeCobraUnaComisionPorHabitante() {
		
		Jugador jugador = new JugadorParaTest();
		
		assertEquals(5000, jugador.darCantDineroEnPresupuesto());
		
		jugador.reducirPresupuestoPorHabitante(10);
		jugador.pasoUnTurno();

		
		assertEquals(0, jugador.darCantDineroEnPresupuesto());

	}
	
	@Test
	public void jugadorSeAproboUnNuevoPresupuestoParaLaCiudad() {
		
		Jugador jugador = new JugadorParaTest();
		
		assertEquals(5000, jugador.darCantDineroEnPresupuesto());
		
		jugador.incrementarPresupuestoEnPorcentaje(50);
		
		assertEquals(7500, jugador.darCantDineroEnPresupuesto());
	}
	
	@Test
	public void jugadorCrearUnPozoDeAgua() {
		
		Jugador jugador = new JugadorParaTest();
		
		assertEquals(5000, jugador.darCantDineroEnPresupuesto());
		
		Posicion posicion = new Posicion(1, 2);
		
		jugador.crearPozoDeAgua(posicion);
		
		assertEquals(4750, jugador.darCantDineroEnPresupuesto());
		
	}
	
	@Test
	public void jugadorCrearDosTuberiasDeAgua() {
		
		Jugador jugador = new JugadorParaTest();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);
		
		assertEquals(4745, jugador.darCantDineroEnPresupuesto());
		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		
		assertEquals(4740, jugador.darCantDineroEnPresupuesto());
	}
	
	@Test
	public void jugadorCrearUnaCentralElectrica() {
		
		Jugador jugador = new JugadorParaTest();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		Posicion unaPosicionMas = new Posicion(1, 5);
		jugador.crearCentralMineral(unaPosicionMas);
		
		assertEquals(1740, jugador.darCantDineroEnPresupuesto());
	}
	
	@Test
	public void jugadorCrearDosRutasEncimaDeLasTuberias() {
		
		Jugador jugador = new JugadorParaTest();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		Posicion unaPosicionMas = new Posicion(1, 5);
		jugador.crearCentralMineral(unaPosicionMas);
		jugador.crearRutaPavimentada(otraPosicion);
		jugador.crearRutaPavimentada(otraPosicionMas);
		
		assertEquals(1720, jugador.darCantDineroEnPresupuesto());
	}
	
	@Test
	public void jugadorCrearResidencia() {
		
		Jugador jugador = new JugadorParaTest();
		Posicion posicion = new Posicion(1, 2);
		jugador.crearPozoDeAgua(posicion);
		Posicion otraPosicion = new Posicion(1, 3);
		jugador.crearTuberiaDeAgua(otraPosicion);		
		Posicion otraPosicionMas = new Posicion(1, 4);
		jugador.crearTuberiaDeAgua(otraPosicionMas);
		Posicion unaPosicionMas = new Posicion(1, 5);
		jugador.crearCentralMineral(unaPosicionMas);
		jugador.crearRutaPavimentada(otraPosicion);
		jugador.crearRutaPavimentada(otraPosicionMas);
		Posicion posicionDeLaCasa = new Posicion(2, 4);
		jugador.crearResidencia(posicionDeLaCasa);
		
		assertEquals(1715, jugador.darCantDineroEnPresupuesto());
	}
	
}
