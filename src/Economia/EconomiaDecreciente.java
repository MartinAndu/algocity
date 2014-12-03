package Economia;

import Jugador.Jugador;

public class EconomiaDecreciente extends Economia {

	public EconomiaDecreciente() {
		this.porcentajeDeCambioMax = 50;
	}
	@Override
	public void ocurrir(Jugador jugador) {
		int porcentajeDeReduccion = (int)(Math.random() * this.porcentajeDeCambioMax + 1); 
		jugador.presupuestoSeRedujoEnPorcentaje(porcentajeDeReduccion);
	}

}
