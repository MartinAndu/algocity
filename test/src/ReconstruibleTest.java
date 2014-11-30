package src;
import static org.junit.Assert.fail;

import org.junit.Test;

import Conectores.LineasDeTension;
import ConstruccionGeneral.Destruible;
import ConstruccionGeneral.Posicion;
import ConstruccionGeneral.Reconstruible;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;

public class ReconstruibleTest {

	@Test
	public void reconstruibleReconstruirEnLineaDeTension() {
		
		Posicion unaPosicion = new Posicion(1, 1);
		Destruible lineaDestruible = new LineasDeTension(unaPosicion);
		lineaDestruible.destruirEnPorcentaje(50);
		Reconstruible lineaReconstruible = (Reconstruible) lineaDestruible;
		
		try {
			lineaReconstruible.reconstruir(1000);
			lineaReconstruible.reconstruir(1000);
			fail();
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
		}
	}
}
