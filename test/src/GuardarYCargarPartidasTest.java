package src;

import junit.framework.Assert;

import org.junit.Test;

import ConstruccionGeneral.Posicion;
import Juego.AlgoCity;
import Jugador.Jugador;

public class GuardarYCargarPartidasTest {

	@Test
	public void elJuegoPuedeCargarUnJugadorAPartirDeSuPartidaGuardadaEnElXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugadorMedio("Jorge");
		Jugador unJugador2 = unJuego.crearJugadorMedio("Alberto");
		unJuego.crearJugadorMedio("Roberto");
		
		unJuego.guardarNombresJugadores();
		
		int presupuestoInicial = unJugador.darCantDineroEnPresupuesto();
		
		Posicion unaPosicion = new Posicion(2,2);
		
		unJugador.crearRutaPavimentada(unaPosicion);
		
		Assert.assertTrue(unJugador.darCantDineroEnPresupuesto() < presupuestoInicial);

		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador.
		unJugador2.guardarPartida();
	}
}