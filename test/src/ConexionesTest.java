package src;

import junit.framework.Assert;

import org.junit.Test;

import Conectores.ConexionDeAgua;
import ConstruccionGeneral.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;

public class ConexionesTest {

	@Test
	public void conexionDeAguaSeConstruyeSeguidasYLanzanExcepcionCuandoNo() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.agregarAlPlano(plano);
		
		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(3, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(4, 2));
		ConexionDeAgua canio4 = new ConexionDeAgua(new Posicion(6, 2));

		//Se construyen perfectamente
		canio.agregarAlPlano(plano);
		canio2.agregarAlPlano(plano);
		canio3.agregarAlPlano(plano);
		
		//tira excepcion
		try {
			canio4.agregarAlPlano(plano);
		} catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios e) {
		}

	}
	
	@Test
	public void conexionDeAguaSeConstruyeSeguidasYSiSeEliminaUnaLasSiguientesPierdenNoPuedenFuncionar() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.agregarAlPlano(plano);
		
		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(3, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(4, 2));
		ConexionDeAgua canio4 = new ConexionDeAgua(new Posicion(5, 2));

		//Se construyen perfectamente
		canio.agregarAlPlano(plano);
		canio2.agregarAlPlano(plano);
		canio3.agregarAlPlano(plano);
		canio4.agregarAlPlano(plano);
		
		canio2.quitarDelPlano();
		
		Assert.assertEquals("me falta agua", (canio3.darEstadoContruccion()).enString());
		Assert.assertEquals("me falta agua", (canio4.darEstadoContruccion()).enString());
		
		//El canio que antecede aun posee agua
		Assert.assertEquals("estoy bien", (canio.darEstadoContruccion()).enString());
	}
	
	@Test
	public void conexionDeAguaSeConstruyeSeguidasSeEliminaFuenteYLuegoSeCOntruyeVerificarQuitaYAgregarServicios() {
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.agregarAlPlano(plano);
		
		ConexionDeAgua canio = new ConexionDeAgua(new Posicion(2, 2));
		ConexionDeAgua canio2 = new ConexionDeAgua(new Posicion(3, 2));
		ConexionDeAgua canio3 = new ConexionDeAgua(new Posicion(4, 2));

		//Se construyen perfectamente
		canio.agregarAlPlano(plano);
		canio2.agregarAlPlano(plano);
		canio3.agregarAlPlano(plano);
		
		Hectarea hectarea = plano.darHectarea(new Posicion(1, 2));
		PozoDeAgua pozoAquitar = (PozoDeAgua) hectarea.quitarConstruccion();
		pozoAquitar.quitarDelPlano();

		Assert.assertEquals("me falta agua", (canio.darEstadoContruccion()).enString());
		Assert.assertEquals("me falta agua", (canio2.darEstadoContruccion()).enString());
		Assert.assertEquals("me falta agua", (canio3.darEstadoContruccion()).enString());
		
		PozoDeAgua pozoAagregar = new PozoDeAgua(new Posicion(1, 2));
		pozoAagregar.agregarAlPlano(plano);
		
		Assert.assertEquals("estoy bien", (canio.darEstadoContruccion()).enString());
		Assert.assertEquals("estoy bien", (canio2.darEstadoContruccion()).enString());
		Assert.assertEquals("estoy bien", (canio3.darEstadoContruccion()).enString());

	}
}
