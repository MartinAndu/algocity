package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class RutaPavimentada extends Conexion{

	public RutaPavimentada(Posicion unaPosicion) {
		posicionConstruccion = unaPosicion;
	}

	@Override
	public void proveerServicioZona(Plano unPlano) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean conectadoALaRed(Hectarea hectareaActual) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
	}
}
