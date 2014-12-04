package src;

import org.junit.Assert;
import org.junit.Test;

import Ambientes.Ambiente;
import Jugador.Jugador;
import Jugador.JugadorParaTest;
import Jugador.Turno;

public class TurnoTest {
	
	@Test
	public void turnoTestDesdeConsola() {
		Jugador jugador = new JugadorParaTest();
		Ambiente ambiente = jugador.generarAmbiente();
		Turno turno = new Turno(jugador, ambiente);
		try {
			Thread.sleep(61000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(turno);
	}
}
