package PlanoGeneradores;

import ConstruccionGeneral.Posicion;

public class GeneradorPosicionAleatorio extends GeneradorPosicion {

	public GeneradorPosicionAleatorio(int dimensionN, int dimensionM) {
		super(dimensionN, dimensionM);
	}

	@Override
	public Posicion generarPosicionEnBordePlano() {
		int numeroAleatorioX = (int)(Math.random() * this.ancho + 1); 
		int numeroAleatorioY = (int)(Math.random() * this.alto + 1); 
		
		if (numeroAleatorioX < numeroAleatorioY) {
			return new Posicion(numeroAleatorioX, 1);
		}

		return new Posicion(1, numeroAleatorioY);
	}

	@Override
	public Posicion generarPosicion() {
		int numeroAleatorioX = (int)(Math.random() * this.ancho + 1); 
		int numeroAleatorioY = (int)(Math.random() * this.alto + 1);
		
		return new Posicion(numeroAleatorioX, numeroAleatorioY);
	}

}
