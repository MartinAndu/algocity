package src;
import static org.junit.Assert.*;

import org.junit.Test;

import ConstruccionGeneral.Posicion;
import PlanoDireccion.Direccion;
import PlanoDireccion.NorEste;
import PlanoDireccion.Norte;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;
import PlanoGeneral.Recorrido;


public class PlanoTest {

	@Test
	public void testPlanoCrear() {
		
		Plano plano = new PlanoDeterminista();
		assertNotNull(plano);
	}
	
	@Test 
	public void testPlanoRecorrerEntornoTenemosQueRecorrerOchoHectareas() {
		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerZonaCircundante(posicion, 1);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(8, i);
	}
	
	@Test 
	public void testPlanoRecorrerZonaCircundanteDebeDarDistanciasUnoYDosHectareas() {
		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerZonaCircundante(posicion, 2);
		recorrido.siguiente();
		
		assertEquals(1, recorrido.distanciaDesdeDondeParti());
		
		for (int j = 0; j < 7; j++) {
			recorrido.siguiente();
		}
		
		assertEquals(1, recorrido.distanciaDesdeDondeParti());
		
		recorrido.siguiente();
		
		assertEquals(2, recorrido.distanciaDesdeDondeParti());
	}
	
	@Test
	public void testPlanoRecorrerEntornoNoDebePoseerHectareasRepetidas() {
		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerZonaCircundante(posicion, 2);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(24, i);
	}
	
	@Test
	public void testPlanoRecorrerEntornoDeTodoElPlano() {
		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = new Posicion(4, 4);
		
		Recorrido recorrido = plano.recorrerZonaCircundante(posicion, 3);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(48, i);
	}
	
	@Test
	public void testPlanoRecorrerLinealmenteDebePasarPorSeisHectareas() {
		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = new Posicion(1, 1);
		Direccion noreste = new NorEste();
		Recorrido recorrido = plano.recorrerLinealmente(posicion, noreste);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(79, i);
	}
	
	@Test
	public void testPlanoRecorrerZigZagDebePasarPorSeisHectareas() {
		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = new Posicion(1, 2);
		Direccion norte = new Norte();
		Recorrido recorrido = plano.recorrerEnZigZag(posicion, norte);
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(79, i);
	}
	
	@Test
	public void testPlanoRecorrerAleatorioDebePasarPorDoceHectareas() {
		
		Plano plano = new PlanoDeterminista();
		Recorrido recorrido = plano.generarRecorridolAleatorioDesdeUnaPosicionBorde();
		int i = 0;
		
		while (recorrido.tieneSiguiente()) {
			recorrido.siguiente();
			i++;
		}
		
		assertEquals(158, i);
	}
	
	@Test
	public void testPlanoGenerarPosicionAleatoriaDeberiaEstarEnPosicionCorrecta(){		
		Plano plano = new PlanoDeterminista();
		Posicion posicion = plano.generarPosicionAleatoria();
		int x = posicion.devolverCoordenadaX();
		int y = posicion.devolverCoordenadaY();
		
		assertEquals(10, x);
		assertEquals(10, y);
	}
	
	@Test 
	public void testPlanoRecorrerTodoElPlanoDesdeUnaPosicionAleatoria() {

		Plano plano = new PlanoDeterminista();
		Recorrido recorrido = plano.recorrerTodoDesdeUnaPosicionAleatoria();
		
		assertEquals(6399, recorrido.longDelRecorridoEnHectareas());
		
	}
	
	
	
}