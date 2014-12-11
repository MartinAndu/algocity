package src;

import junit.framework.Assert;

import org.junit.Test;

import ConstruccionGeneral.Posicion;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Juego.AlgoCity;
import Jugador.Jugador;

public class GuardarYCargarPartidasTest {
	
	@Test
	public void jugadorPuedeGuardarPartidaYSeGeneraDocumentoXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();

		Jugador unJugador = unJuego.crearJugadorMedio("Jorge");
		
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJuego.guardarNombresJugadores();
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
	}

	@Test
	public void elJuegoPuedeCargarUnJugadorAPartirDeSuPartidaGuardadaEnElXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugadorMedio("Jorge");
		Jugador unJugador2 = unJuego.crearJugadorMedio("Alberto");
		Jugador unJugador3 = unJuego.crearJugadorMedio("Roberto");
		
		unJuego.guardarNombresJugadores();
		
		int presupuestoInicial = unJugador.darCantDineroEnPresupuesto();
		
		Posicion unaPosicion = new Posicion(1,1);
		
		unJugador.crearTuberiaDeAgua(unaPosicion);
		unJugador.crearResidencia(unaPosicion);

		Assert.assertTrue(unJugador.darCantDineroEnPresupuesto() < presupuestoInicial);

		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
		
		

		AlgoCity otroAlgoCity = new AlgoCity();
		
		Assert.assertTrue(!otroAlgoCity.hayJugadores());
		
		otroAlgoCity.cargarJugador("Jorge.xml"); // Cargo el XML con los datos de Jorge en otra instancia de AlgoCity...
		
		Assert.assertTrue(otroAlgoCity.hayJugadores());

		String nombreDelResucitado = otroAlgoCity.obtenerNombrePrimerJugadorRegistrado();
		
		Assert.assertNotNull(nombreDelResucitado);
		
		Jugador jorgeResucitado = otroAlgoCity.cargarJugador(nombreDelResucitado);
		
		boolean excepcionAtrapada = false;
		try{
			jorgeResucitado.crearResidencia(new Posicion(1,1));
		}
		catch (ExcepcionHectareaYaContieneUnaConstruccion excepcion){
			excepcionAtrapada = true;
		}
        
        Assert.assertTrue(excepcionAtrapada);
		
		Assert.assertTrue(jorgeResucitado.darCantDineroEnPresupuesto() < presupuestoInicial);

	}

}