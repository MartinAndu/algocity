package Conectores;

import PlanoGeneral.Plano;

public class LineasDeTension extends Conexion{
	
	public void proveerServicioZona(Plano unPlano){
		
	}
	public boolean puedeProveerServicioZona(Plano unPlano){
		return true;
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean esConstruibleSobreTierra() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean esConstruibleSobreAgua() {
		// TODO Auto-generated method stub
		return false;
	}
}
