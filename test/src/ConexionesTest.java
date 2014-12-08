package src;

import junit.framework.Assert;

import org.junit.Test;

import Conectores.ConexionDeAgua;
import ConstruccionGeneral.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;

public class ConexionesTest {

	@Test
	public void conexionDeAguaSeConstruyeSeguidasYLanzanExcepcionCuandoNo() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);
		
		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(3, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(4, 2));
		ConexionDeAgua canio4 = new ConexionDeAgua(new Posicion(6, 2));

		//Se construyen perfectamente
		canio.construirSobrePlano(plano);
		canio2.construirSobrePlano(plano);
		canio3.construirSobrePlano(plano);
		
		//tira excepcion
		try {
			canio4.construirSobrePlano(plano);
		} catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios e) {
		}

	}
	
	@Test
	public void conexionDeAguaSeConstruyeSeguidasYSiSeEliminaUnaLasSiguientesPierdenNoPuedenFuncionar() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);
		
		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(3, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(4, 2));
		ConexionDeAgua canio4 = new ConexionDeAgua(new Posicion(5, 2));

		//Se construyen perfectamente
		canio.construirSobrePlano(plano);
		canio2.construirSobrePlano(plano);
		canio3.construirSobrePlano(plano);
		canio4.construirSobrePlano(plano);
		
		canio2.quitarDelPlano();
		
		Assert.assertEquals("me falta agua", (canio3.estadoContruccion()).enString());
		Assert.assertEquals("me falta agua", (canio4.estadoContruccion()).enString());
		
		//El canio que antecede aun posee agua
		Assert.assertEquals("estoy bien", (canio.estadoContruccion()).enString());
	}
}
