package Conectores;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public  class LineasDeTension extends Conexion{
	public void proveerServicioZona(Plano unPlano){
		 unPlano.devolverHectarea(unaPosicion).habilitarElectricidad();
	}
	
	public LineasDeTension(Hectarea unaHectarea) {
		super(unaHectarea);
		// TODO Auto-generated constructor stub
	}
	public boolean puedeProveerServicioZona(Plano unPlano){
		return true;
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
}
