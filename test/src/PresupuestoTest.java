package src;

import junit.framework.Assert;
import org.junit.Test;
import Presupuesto.Presupuesto;
import Presupuesto.PresupuestoBajo;

public class PresupuestoTest {

	@Test
	public void presupuestoBajoContieneSumaCorrecta() {
		Presupuesto presupuestoPobre = new PresupuestoBajo();
		int cantidadDinero = presupuestoPobre.obtenerCantidadDeDinero();
		Assert.assertTrue(cantidadDinero < 15000);
	}
	
	@Test
	public void presupuestoAumentaYReduceElDineroCorrectamente(){
		Presupuesto presupuestoPobre = new PresupuestoBajo();
		int cantidadDinero = presupuestoPobre.obtenerCantidadDeDinero();
		int sumaAAgregar = 2000;
		presupuestoPobre.incrementar(sumaAAgregar);
		int presupuestoEsperado = cantidadDinero + sumaAAgregar;
		int cantidadDineroAlAumentarSuma = presupuestoPobre.obtenerCantidadDeDinero();
		
		Assert.assertEquals(presupuestoEsperado, cantidadDineroAlAumentarSuma);
		
		presupuestoPobre.reducir(sumaAAgregar);
		Assert.assertEquals(presupuestoPobre.obtenerCantidadDeDinero(), cantidadDinero);
	}

}
