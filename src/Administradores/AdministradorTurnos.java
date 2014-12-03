package Administradores;

public abstract class AdministradorTurnos {

	private int turnosQuePasaron;
	private int turnoParaActuar;

	public boolean esHoraDeUnEvento() {
		if (this.turnosQuePasaron == this.turnoParaActuar) {
			this.turnoParaActuar = this.generarUnTurno();
			this.turnosQuePasaron = 0;		
			return true;
		}
		
		return false;
	}

	protected abstract int generarUnTurno();

	public void pasoUnTurno() {
		(this.turnosQuePasaron)++;
	}

}
