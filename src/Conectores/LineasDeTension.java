package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public  class LineasDeTension extends Conexion{
	
	boolean conectadoALaRed;
	
	public void proveerServicioZona(Plano unPlano){
		 unPlano.devolverHectarea(unaPosicion).habilitarElectricidad();
	}
	
	public LineasDeTension(Hectarea unaHectarea) {
		super(unaHectarea);
		// TODO Auto-generated constructor stub
	}
	public boolean conectadoALaRed(Hectarea hectareaActual){
		//Verifica si hay linea de tensión en esa posicion
		return (hectareaActual.poseeServicioElectrico());
	}
	
	public boolean puedeProveerServicioZona(Plano unPlano){
		
		return true;
	}
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
	
	public void habilitarElectricidadSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()){
				LineasDeTension unaConexion=hectareaActual.obtenerLineaDeTension(); 
				if(unaConexion.conectadoALaRed(hectareaActual)){
					conectadoALaRed=true;
				}
			}
		}
	}

	
}
