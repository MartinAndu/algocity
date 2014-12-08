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
		
		Jugador unJugador = unJuego.crearJugador("Jorge");
		
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
	}
	
	@Test
	public void elJuegoPuedeCargarUnJugadorAPartirDeSuPartidaGuardadaEnElXML() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugador("Jorge");
		
		int presupuestoInicial = unJugador.darCantDineroEnPresupuesto();
		
		Posicion unaPosicion = new Posicion(1,1);
		
		unJugador.crearTuberiaDeAgua(unaPosicion);
		unJugador.crearResidencia(unaPosicion);

		Assert.assertTrue(unJugador.darCantDineroEnPresupuesto() < presupuestoInicial);

		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); // Esto genera el XML con los datos del jugador Jorge.
		
		

		AlgoCity otroAlgoCity = new AlgoCity();
		
		Assert.assertTrue(!otroAlgoCity.hayJugadores());
		
		otroAlgoCity.cargarPartidaJugador("Jorge.xml"); // Cargo el XML con los datos de Jorge en otra instancia de AlgoCity...
		
		Assert.assertTrue(otroAlgoCity.hayJugadores());

		Jugador jorgeResucitado = otroAlgoCity.obtenerPrimerJugadorRegistrado();
		
		Assert.assertNotNull(jorgeResucitado);
		
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
	
	@Test
	public void probandoGuardarCargarJugadorConDiferentesConstruccionesEnElPlano() throws Exception{
		AlgoCity unJuego = new AlgoCity();
		
		Jugador unJugador = unJuego.crearJugador("Jorge");
		
		int presupuestoInicial = unJugador.darCantDineroEnPresupuesto();
		
		Posicion unaPosicion = new Posicion(1,1);
		
		unJugador.crearRutaPavimentada(unaPosicion);
		unJugador.crearCentralEolica(new Posicion(1,2));
		unJugador.crearPozoDeAgua(new Posicion(1,4));
		unJugador.crearTuberiaDeAgua(new Posicion(1,4));
		
		Assert.assertTrue(unJuego.hayJugadores());
		
		unJugador.guardarPartida(); 
		

		AlgoCity otroAlgoCity = new AlgoCity();
		
		Assert.assertTrue(!otroAlgoCity.hayJugadores());
		
		otroAlgoCity.cargarPartidaJugador("Jorge.xml");
		
		Assert.assertTrue(otroAlgoCity.hayJugadores());

		Jugador jorgeResucitado = otroAlgoCity.obtenerPrimerJugadorRegistrado();
		
		Assert.assertNotNull(jorgeResucitado);
		
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
