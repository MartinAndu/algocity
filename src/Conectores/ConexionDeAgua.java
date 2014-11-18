package Conectores;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;

import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	boolean conectadoALaRed=false;

	public boolean conectadoALaRed() {
		return conectadoALaRed;
		
	}
	public boolean esConstruibleSobreAgua(){
		
		return true;
	}
	public boolean esConstruibleSobreTierra(){
		
		return true;
	}
	
	public void proveerServicioZona(Plano unPlano){
		
	}
	public boolean puedeProveerServicioZona(Plano unPlano){
		return true;
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}

	public void habilitarAgua(Plano unPlano) {
		Recorrido zonaCircundante= unPlano.recorrerEntorno(unaPosicion, 1);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()){
				ConexionDeAgua unaConexion=hectareaActual.obtenerCanio();
				if(unaConexion.conectadoALaRed()){
					conectadoALaRed=true;
				};
			}
		}
	}

}
