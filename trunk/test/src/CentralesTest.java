package src;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.LineasDeTension;
import ConstruccionGeneral.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionCentralElectricaNoPoseeRedDeAgua;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;

public class CentralesTest {
	
	@Test
	public void centralesElectricasTiraExcepcionSiNoTienenAgua(){
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);
		
		//centrales alrededor del pozo
		CentralEolica centralEolica = new CentralEolica(new Posicion(1, 1));
		CentralMineral centralMineral = new CentralMineral(new Posicion(1, 3));
		
		//central lejos del pozo tira excepcion
		CentralNuclear centralNuclear = new CentralNuclear(new Posicion(3, 1));
		
		centralEolica.construirSobrePlano(plano);
		centralMineral.construirSobrePlano(plano);
		
		try {
			centralNuclear.construirSobrePlano(plano);
			fail();
		} catch (ExcepcionCentralElectricaNoPoseeRedDeAgua e) {
		}

	}
	
	@Test
	public void centralElectricaSeConstruyeSobreSuperficieDeAguaTiraExcepcion(){
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);
		
		CentralEolica centralEolica = new CentralEolica(new Posicion(2, 1));

		try {
			centralEolica.construirSobrePlano(plano);
			fail();
		} catch (ExcepcionNoSePuedeConstruirEnEsteTerreno e) {
		}
	}
	
	@Test
	public void centralElectricaProveeEnegiaALaZonaCircandanteDeCuatroHectareas(){
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);
		CentralEolica centralEolica = new CentralEolica(new Posicion(1, 3));
		centralEolica.construirSobrePlano(plano);
		
		LineasDeTension cable = new LineasDeTension(new Posicion(1, 7));
		LineasDeTension cable2 = new LineasDeTension(new Posicion(5, 3));
		
		//cables estan dentro de los limites de abastecimiento de la central
		//por tanto se pueden establecer en el plano
		cable.construirSobrePlano(plano);
		cable2.construirSobrePlano(plano);
		
		LineasDeTension cable3 = new LineasDeTension(new Posicion(6, 8));
		//cables3 no se encuantra en los limites de abastecimiento y tira
		//excepcion
		
		try {
			cable3.construirSobrePlano(plano);
			fail();
		} catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios e) {
		}
	}
	
	@Test
	public void centralElectricaQuitaEnergiaALaZonaProvista(){
		Plano plano = new PlanoDeterminista();
		PozoDeAgua pozo = new PozoDeAgua(new Posicion(1, 2));
		pozo.construirSobrePlano(plano);
		CentralEolica centralEolica = new CentralEolica(new Posicion(1, 3));
		centralEolica.construirSobrePlano(plano);
		LineasDeTension cable = new LineasDeTension(new Posicion(1, 7));
		LineasDeTension cable2 = new LineasDeTension(new Posicion(5, 3));
		cable.construirSobrePlano(plano);
		cable2.construirSobrePlano(plano);
		
		centralEolica.quitarDelPlano();
		
		Assert.assertEquals("me falta luz", (cable.estadoContruccion()).enString());
		Assert.assertEquals("me falta luz", (cable2.estadoContruccion()).enString());
		
	}
}
