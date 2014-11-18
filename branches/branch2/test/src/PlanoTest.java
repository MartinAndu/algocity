package src;
import static org.junit.Assert.*;

import org.junit.Test;

import Edificios.Posicion;
import PlanoDireccion.Direccion;
import PlanoDireccion.NorEste;
import PlanoDireccion.Norte;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;


public class PlanoTest {

	@Test
	public void testPlanoCrear() {
		
		Plano plano = new Plano(100,100);
		assertNotNull(plano);
	}
	
	@Test 
	public void testPlanoRecorrerEntornoTenemosQueRecorrerOchoHectareas() {
		
		Plano plano = new Plano(7, 7);
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerEntorno(posicion, 1);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(8, i);
	}
	
	@Test
	public void testPlanoRecorrerEntornoNoDebePoseerHectareasRepetidas() {
		
		Plano plano = new Plano(7, 7);
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerEntorno(posicion, 2);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(24, i);
	}
	
	@Test
	public void testPlanoRecorrerEntornoDeTodoElPlano() {
		
		Plano plano = new Plano(7, 7);
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerEntorno(posicion, 3);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(48, i);
	}
	
	@Test
	public void testPlanoRecorrerLinealmenteDebePasarPorSeisHectareas() {
		
		Plano plano = new Plano(7, 7);
		Posicion posicion = new Posicion(1, 1);
		Direccion noreste = new NorEste();
		Recorrido recorrido = plano.recorrerLinealmente(posicion, noreste);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(6, i);
	}
	
	@Test
	public void testPlanoRecorrerZigZagDebePasarPorSeisHectareas() {
		
		Plano plano = new Plano(7, 7);
		Posicion posicion = new Posicion(1, 2);
		Direccion norte = new Norte();
		Recorrido recorrido = plano.recorrerEnZigZag(posicion, norte);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(6, i);
	}
	
	@Test
	public void testPlanoRecorrerAleatorioDebePasarPorDoceHectareas() {
		
		Plano plano = new Plano(7, 7);
		Recorrido recorrido = plano.generarRecorridolAleatorio();
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(12, i);
	}
	
	@Test
	public void testPlanoGenerarPosicionAleatoraDeberiaEstarEnCentro() {
		
		Plano plano = new Plano(8, 8);
		Posicion posicion = plano.generarPosicionAleatoria();
		int x = posicion.devolverCoordenadaX();
		int y = posicion.devolverCoordenadaY();
		
		assertEquals(4, x);
		assertEquals(4, y);
	}
	
	
	
}