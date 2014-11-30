package src;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Bomberos.EstacionDeBomberos;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import ConstruccionGeneral.Posicion;
import ConstruccionGeneral.Reconstruible;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import Presupuesto.Presupuesto;
import Presupuesto.PresupuestoMedio;

public class EstacionDeBomberosTest {

	@Test
	public void estacionDeBomberosRealizarReparacionesDescuentaEdificiosAReparar() {
		
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		ArrayList<Reconstruible> reconstruibles = new ArrayList<Reconstruible>();
		Posicion unaPosicion = new Posicion(1, 1); 
		LineasDeTension linea = new LineasDeTension(unaPosicion);
		ConexionDeAgua canio = new ConexionDeAgua(unaPosicion);
		Presupuesto presupuesto = new PresupuestoMedio();
		linea.destruir();
		canio.destruir();
		reconstruibles.add((Reconstruible) linea);
		reconstruibles.add((Reconstruible) canio);
		bomberos.agregarReconstruibles(reconstruibles);
		bomberos.habilitar(presupuesto);
		bomberos.realizarReparaciones();
		bomberos.realizarReparaciones();
		
		try {
			linea.reconstruir(10000);
			fail();
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
		}
		
		try {
			canio.reconstruir(10000);
			fail();
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
		}
		
		
	}
}
