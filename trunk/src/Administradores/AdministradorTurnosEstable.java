package Administradores;


public class AdministradorTurnosEstable extends AdministradorTurnos {

	@Override
	protected int generarUnTurno() {
		return (int)(Math.random() * 6 + 1); 

	}

}
