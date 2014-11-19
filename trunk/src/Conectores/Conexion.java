package Conectores;

import Edificios.Construccion;
import Edificios.Reconstruible;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public abstract   class Conexion extends Construccion implements Reconstruible{
	
	public abstract void proveerServicioZona(Plano unPlano);
	 
	 Conexion(Hectarea unaHectarea){
		 unaHectarea.establecerConexion(this);
	 }

	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int devolverConsumo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean esConstruibleSobreAgua() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esConstruibleSobreTierra() {
		// TODO Auto-generated method stub
		return false;
	}
}
