package Conectores;

import Edificios.Construccion;
import Edificios.Posicion;
import Edificios.Reconstruible;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public abstract class Conexion extends Construccion implements Reconstruible{

	public abstract void proveerServicioZona(Plano unPlano);
	public abstract boolean conectadoALaRed(Hectarea hectareaActual);
	public abstract void habilitarConexion();
	
	int radioDeDistribucion;
	boolean conectadoALaRed=false;;

	public Conexion(Posicion posicion) {
		super(posicion);
	}
	 


	@Override
	public int devolverConsumo() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
