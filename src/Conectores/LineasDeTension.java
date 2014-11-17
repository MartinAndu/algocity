package Conectores;

import PlanoGeneral.Plano;

public abstract class LineasDeTension extends Conexion{
	
	public void proveerServicioZona(Plano unPlano){
		
	}
	public boolean puedeProveerServicioZona(Plano unPlano){
		return true;
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
}
