package src;

import org.junit.Assert;
import org.junit.Test;

import Administradores.AdministradorEventos;
import Administradores.AdministradorEventosDeterministico;
import Administradores.Evento;
import CatastrofeGenerador.GeneradorCatastrofe;
import CatastrofeGenerador.GeneradorCatastrofeDeterministico;

public class AdministradorEventosTest {

	@Test
	public void administradorEventosDebeCrearUnEvento(){
		
		AdministradorEventos admEventos = new AdministradorEventosDeterministico();
		
		GeneradorCatastrofe catastrofes = new GeneradorCatastrofeDeterministico();
		
		admEventos.agregarGeneradorEvento(catastrofes);
		
		Evento evento = admEventos.generarUnEvento();
		
		Assert.assertNotNull(evento);
	}
}
