package SuperficiesGeneradores;

import Superficies.Superficie;

public abstract class GeneradorSuperficie {
	static public int numeroAlternador = 0;

	public abstract Superficie generarSuperficie();
}
