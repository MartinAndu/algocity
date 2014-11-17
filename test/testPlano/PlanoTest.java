package testPlano;
import static org.junit.Assert.*;
import org.junit.Test;

import Edificios.Posicion;

import planoGeneral.Plano;
import planoGeneral.Recorrido;


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
	
	
	
}
