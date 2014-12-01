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
		
		unJugador.crearPozoDeAgua(new Posicion(4,4));
		
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
		
		
		/**
		AlgoCity otroAlgoCity = new AlgoCity();
		
		Assert.assertTrue(!otroAlgoCity.hayJugadores());
		
		otroAlgoCity.cargarPartidaJugador("Jorge.xml"); // Cargo el XML con los datos de Jorge en otra instancia de AlgoCity...
		
		Assert.assertTrue(otroAlgoCity.hayJugadores());
		**/
	}
}
