package src;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import Conectores.ConexionDeAgua;
import ConstruccionGeneral.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;

public class PozoTest {

	@Test
	public void pozoDeAguaTiraExcepcionCuandoSeCreaSobreUnaSuperficieLlana() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 1));
		
		try {
			pozo.construirSobrePlano(plano);
			fail();
		} catch (ExcepcionNoSePuedeConstruirEnEsteTerreno e) {
		}
		
	}
	
	@Test
	public void pozoDeAguaProveeAguaASuEntorno() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);

		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(1, 1));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(1, 3));
		
		//canios se puede localizar en el plano porque tiene acceso al agua
		canio.construirSobrePlano(plano);
		canio2.construirSobrePlano(plano);
		canio3.construirSobrePlano(plano);
		
		//canio no se puede localizar en plano porque no tiene acceso al agua
		ConexionDeAgua canio4 = new ConexionDeAgua(new Posicion(1, 5));
		
		try {
			canio4.construirSobrePlano(plano);
			fail();
		} catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios e) {
		}
	}
	
	@Test
	public void pozoDeAguaQuitarDelPlanoDejaSinAguaASuEntorno() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);

		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(1, 1));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(1, 3));
		
		//canios se puede localizar en el plano porque tiene acceso al agua
		canio.construirSobrePlano(plano);
		canio2.construirSobrePlano(plano);
		canio3.construirSobrePlano(plano);
		
		pozo.quitarDelPlano();
		
		Assert.assertEquals("me falta agua", (canio.estadoContruccion()).enString());
		Assert.assertEquals("me falta agua", (canio2.estadoContruccion()).enString());
		Assert.assertEquals("me falta agua", (canio3.estadoContruccion()).enString());

	}
}
