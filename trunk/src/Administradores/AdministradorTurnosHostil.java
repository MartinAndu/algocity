package Administradores;


public class AdministradorTurnosHostil extends AdministradorTurnos {

	@Override
	protected int generarUnTurno() {
		return (int)(Math.random() * 3 + 1); 
	}

}
