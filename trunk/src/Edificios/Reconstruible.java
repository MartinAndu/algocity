package Edificios;

import Excepciones.ExceptionConstruccionComplemtamenteReparada;

public interface Reconstruible {		

		public abstract void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada;
	
}
