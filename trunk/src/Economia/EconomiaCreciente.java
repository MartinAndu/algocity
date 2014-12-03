package Economia;

import Jugador.Jugador;

public class EconomiaCreciente extends Economia {

	public EconomiaCreciente() {
		this.porcentajeDeCambioMax = 50;
	}
	@Override
	public void ocurrir(Jugador jugador) {
		int porcentajeDeCrecimiento = (int)(Math.random() * this.porcentajeDeCambioMax + 1); 
		jugador.presupuestoSeIncrementoEnPorcentaje(porcentajeDeCrecimiento);

	}

}
