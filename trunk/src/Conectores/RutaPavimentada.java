package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class RutaPavimentada extends Conexion{

	static int COSTO_CONSTRUCCION = 10;

	public RutaPavimentada(Posicion unaPosicion) {
		super(unaPosicion);
		posicionConstruccion = unaPosicion;
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
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
	public float porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void habilitarConexion() {
		// TODO Auto-generated method stub
		
	}
}
