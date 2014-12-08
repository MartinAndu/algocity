package src;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import Bomberos.EstacionDeBomberos;
import Conectores.ConexionDeAgua;
import ConstruccionGeneral.Posicion;
import ConstruccionGeneral.Reconstruible;
import Edificios.PozoDeAgua;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;
import Presupuesto.Presupuesto;
import Presupuesto.PresupuestoMedio;

public class EstacionDeBomberosTest {

	@Test
	public void estacionDeBomberosRealizarReparacionesDescuentaEdificiosAReparar() {
		
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		ArrayList<Reconstruible> reconstruibles = new ArrayList<Reconstruible>();
		Posicion posicion = new Posicion(1, 1); 
		Posicion posicion2 = new Posicion(1, 2);
		PozoDeAgua pozo = new PozoDeAgua(posicion2);
		ConexionDeAgua canio = new ConexionDeAgua(posicion);
		Presupuesto presupuesto = new PresupuestoMedio();
		Plano plano = new PlanoDeterminista();
		
		pozo.agregarAlPlano(plano);
		canio.agregarAlPlano(plano);
		
		canio.destruir();
		pozo.destruir();
		
		reconstruibles.add((Reconstruible) canio);
		reconstruibles.add(pozo);
		
		bomberos.agregarReconstruibles(reconstruibles);
		bomberos.habilitar(presupuesto);
		bomberos.realizarReparaciones();
		bomberos.realizarReparaciones();
		bomberos.realizarReparaciones();
		bomberos.realizarReparaciones();
		
		try {
			pozo.reconstruir(10000);
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
