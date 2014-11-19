package Conectores;
import org.junit.Assert.*;
import org.junit.Test;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	ConexionDeAgua(Hectarea unaHectarea) {
		super(unaHectarea);
		// TODO Auto-generated constructor stub
	}

	boolean conectadoALaRed=false;

	public boolean conectadoALaRed() {
		return true;
		//return conectadoALaRed;
		
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

	public void habilitarAgua(){
		conectadoALaRed=true;
	}
	
	public void habilitarConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()){
				ConexionDeAgua unaConexion=hectareaActual.obtenerCanio();
				if(unaConexion.conectadoALaRed()){
					habilitarAgua();
				};
			}
		}
	}

}
