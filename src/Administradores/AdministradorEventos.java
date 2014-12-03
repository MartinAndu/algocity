package Administradores;

import java.util.ArrayList;
import java.util.List;

public abstract class AdministradorEventos {

	protected List<GeneradorEvento> generadores;

	public AdministradorEventos() {
		this.generadores = new ArrayList<GeneradorEvento>();
	}
	
	public abstract Evento generarUnEvento();

	public void agregarGeneradorEvento(GeneradorEvento generador) {
		this.generadores.add(generador);
	}


}
