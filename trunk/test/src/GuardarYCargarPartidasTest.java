package src;

import junit.framework.Assert;

import org.junit.Test;

import Juego.AlgoCity;
import Jugador.Jugador;

public class GuardarYCargarPartidasTest {
	
	@Test
	public void jugadorPuedeGuardarPartidaYSeGeneraDocumentoXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugador("Jorge");
		
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // ojo que esto genera un .xml cada vez que se corre el test !!
	}
	
	@Test
	public void elJuegoPuedeCargarUnJugadorAPartirDeSuPartidaGuardadaEnElXML() throws Exception{
		// Este test depende de que el anterior cree el archivo de la partida de "Jorge", pero los test deben ser independientes entre si!
		AlgoCity unJuego = new AlgoCity();
		
		Assert.assertTrue(!unJuego.hayJugadores());
		
		unJuego.cargarPartidaJugador("Jorge.xml");
		
		Assert.assertTrue(unJuego.hayJugadores());
	}
}
