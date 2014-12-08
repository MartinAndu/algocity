package Administradores;

public class AdministradorTurnos {

	private int turnosQuePasaron;
	private int turnoParaActuar;
	protected int turnoMax;

	public AdministradorTurnos() {
		this.turnoParaActuar = this.generarUnTurno();
	}
	
	public boolean esHoraDeUnEvento() {
		if (this.turnosQuePasaron == this.turnoParaActuar) {
			this.turnoParaActuar = this.generarUnTurno();
			this.turnosQuePasaron = 0;		
			return true;
		}
		
		return false;
	}

	protected int generarUnTurno(){
		return (int)(Math.random() * this.turnoMax + 1); 
	}

	public void pasoUnTurno() {
		(this.turnosQuePasaron)++;
	}

}
