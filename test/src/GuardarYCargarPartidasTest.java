package src;

import junit.framework.Assert;

import org.junit.Test;

import ConstruccionGeneral.Posicion;
import Juego.AlgoCity;
import Jugador.Jugador;

public class GuardarYCargarPartidasTest {
	
	@Test
	public void jugadorPuedeGuardarPartidaYSeGeneraDocumentoXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugador("Jorge");
		
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
	}
	
	@Test
	public void elJuegoPuedeCargarUnJugadorAPartirDeSuPartidaGuardadaEnElXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugador("Jorge");
		
		int presupuestoInicial = unJugador.obtenerPresupuesto();
		/**
		unJugador.crearPozoDeAgua(new Posicion(4,4));
		
		unJugador.crearResidencia(new Posicion(1,1));
		
		Assert.assertTrue(unJugador.obtenerPresupuesto() < presupuestoInicial);
		**/
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
		
		

		AlgoCity otroAlgoCity = new AlgoCity();
		
		Assert.assertTrue(!otroAlgoCity.hayJugadores());
		
		otroAlgoCity.cargarPartidaJugador("Jorge.xml"); // Cargo el XML con los datos de Jorge en otra instancia de AlgoCity...
		
		Assert.assertTrue(otroAlgoCity.hayJugadores());

		Jugador jorgeResucitado = otroAlgoCity.obtenerPrimerJugadorRegistrado();
		Assert.assertNotNull(jorgeResucitado);
		/**
		jorgeResucitado.crearResidencia(new Posicion(1,1));
		
		Assert.assertTrue(jorgeResucitado.obtenerPresupuesto() < presupuestoInicial);
		**/
	}
}
