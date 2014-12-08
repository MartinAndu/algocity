package src;
import static org.junit.Assert.fail;


import org.junit.Test;
import ConstruccionGeneral.Posicion;
import ConstruccionGeneral.Reconstruible;
import Edificios.EdificioResidencial;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;

public class ReconstruibleTest {

	@Test
	public void reconstruibleReconstruirEnLineaDeTension() {
		
		Posicion unaPosicion = new Posicion(1, 1);
		EdificioResidencial casa = new EdificioResidencial(unaPosicion);
		casa.destruirEnUnPorcentaje(50);
		Reconstruible casaReconstruible = (Reconstruible) casa;
		
		try {
			casaReconstruible.reconstruir(1000);
			casaReconstruible.reconstruir(1000);
			casaReconstruible.reconstruir(1000);
			casaReconstruible.reconstruir(1000);
			casaReconstruible.reconstruir(1000);

			fail();
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
		}
	}
}
