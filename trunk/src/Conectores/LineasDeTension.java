package Conectores;

import CentralesElectricas.CentralElectrica;
import Edificios.Posicion;
import Excepciones.ExcepcionElConsumoElectricoDeLaHectareaExcedeALaCapacidadMaxima;
import Excepciones.ExcepcionNoSePuedeConectarPorqueNoHayOtraLineaDeTensionAlrededor;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public  class LineasDeTension extends Conexion{
	
	boolean conectadoALaRed;
	CentralElectrica centralElectricaALAQuePertenece;
	
	public void proveerServicioZona(Plano unPlano){
		 unPlano.devolverHectarea(posicionConstruccion).habilitarElectricidad();
	}
	
	public LineasDeTension(CentralElectrica unaCentralElectrica) {
		this.centralElectricaALAQuePertenece = unaCentralElectrica;
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
	
	private boolean excedeElConsumo(int consumoDeLaNuevaConexion){
		
		int consumoActual = this.centralElectricaALAQuePertenece.obtenerCapacidadDeAbastecimientoEnMW();
		int consumoMaximo = this.centralElectricaALAQuePertenece.obtenerCapacidadMaxDeAbastecimientoEnMW();
		
		consumoActual += consumoDeLaNuevaConexion;
		
		if (consumoActual > consumoMaximo)
			return false;
		
		return true;
	}
	
	public void habilitarElectricidadSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		
		
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		
		while (zonaCircundante.tieneSiguiente()){
			
			Hectarea hectareaActual = zonaCircundante.siguiente();
			LineasDeTension unaConexion = hectareaActual.obtenerLineaDeTension();
			
			//Verifica que al querer asignar una conexión en una hectárea, haya otras lineas de tensión alrededor
			if (unaConexion == null)
				throw new ExcepcionNoSePuedeConectarPorqueNoHayOtraLineaDeTensionAlrededor();
		}
		
		int consumoElectrico=unPlano.devolverHectarea(unaPosicion).obtenerConstruccion().devolverConsumo();
		
		//Verifica que no se exceda al consumo permitido por la central eléctrica
		if (excedeElConsumo(consumoElectrico))
			throw new ExcepcionElConsumoElectricoDeLaHectareaExcedeALaCapacidadMaxima();
		
		conectadoALaRed = true;
	
		
	}

	
}
