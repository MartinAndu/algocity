package Administradores;


public class AdministradorEventosAleatorio extends AdministradorEventos {

	@Override
	public Evento generarUnEvento() {
		int indiceGeneradorEvento =  (int)(Math.random() * (this.generadores.size())); 
	
		return (this.generadores.get(indiceGeneradorEvento)).generarUnEvento();

	}

}
