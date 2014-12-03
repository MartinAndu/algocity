package Administradores;


public class AdministradorTurnosFavorable extends AdministradorTurnos {

	@Override
	protected int generarUnTurno() {
		return (int)(Math.random() * 9 + 1); 

	}

}
