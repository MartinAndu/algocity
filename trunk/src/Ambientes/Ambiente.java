package Ambientes;

import Administradores.AdministradorEventosAleatorio;
import Administradores.AdministradorTurnos;
import Administradores.AdministradorEventos;
import Administradores.Evento;
import CatastrofeGenerador.GeneradorCatastrofe;
import CatastrofeGenerador.GeneradorCatastrofeAleatorio;
import GeneradorEconomia.GeneradorEconomia;
import GeneradorEconomia.GeneradorEconomiaAletario;
import Jugador.Jugador;

public abstract class Ambiente {

	protected AdministradorTurnos admTurnos;
	protected AdministradorEventos admEventos;
	protected Jugador jugadorAAmbientar;
	
	public Ambiente(Jugador jugador) {
		this.jugadorAAmbientar = jugador;
		this.admEventos = new AdministradorEventosAleatorio();
		
		GeneradorCatastrofe catastrofes = new GeneradorCatastrofeAleatorio();
		GeneradorEconomia economico = new GeneradorEconomiaAletario();
		
		this.admEventos.agregarGeneradorEvento(catastrofes);
		this.admEventos.agregarGeneradorEvento(economico);
	}
	
	public void pasoUnTurno() {
		this.admTurnos.pasoUnTurno();
		if (this.admTurnos.esHoraDeUnEvento()) {
			Evento evento = this.admEventos.generarUnEvento();
			evento.ocurrir(this.jugadorAAmbientar);
		}
	}

}
