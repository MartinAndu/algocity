package Conectores;

import CentralesElectricas.CentralElectrica;
import Edificios.Posicion;
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
	
	public void proveerServicioZona(Plano unPlano, Posicion unaPosicion) {
		
		boolean hayLineasDeTensionAlrededorDeLaHectarea = false;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		
		while (zonaCircundante.tieneSiguiente()){
			
			Hectarea hectareaActual = zonaCircundante.siguiente();
			LineasDeTension unaConexion = hectareaActual.obtenerLineaDeTension();
			
			//Verifica que al querer asignar una conexión en una hectárea, haya otras lineas de tensión alrededor
			if (unaConexion != null)
				hayLineasDeTensionAlrededorDeLaHectarea = true;
		}
		
		
		if (!hayLineasDeTensionAlrededorDeLaHectarea)
			throw new ExcepcionNoSePuedeConectarPorqueNoHayOtraLineaDeTensionAlrededor();
		
		int consumoElectrico=unPlano.devolverHectarea(unaPosicion).obtenerConstruccion().devolverConsumo();
		
		//Verifica que no se exceda al consumo permitido por la central eléctrica
		if (!excedeElConsumo(consumoElectrico) 
				&& !(unPlano.devolverHectarea(unaPosicion).obtenerConstruccion().esConstruibleSobreAgua())){
			conectadoALaRed = true;
			unPlano.devolverHectarea(unaPosicion).habilitarElectricidad();
		}
		
		
	
		
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
	}

	
}
