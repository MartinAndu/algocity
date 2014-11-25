package Conectores;

import CentralesElectricas.CentralElectrica;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public  class LineasDeTension extends Conexion{

	CentralElectrica centralElectricaALAQuePertenece;
	static int COSTO_CONSTRUCCION = 5;
	static int RADIO_DE_DISTRIBUCION = 1;
	
	public LineasDeTension(Posicion unaPosicion) {
		super(unaPosicion);
		
		radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		costoDeConstruccion = COSTO_CONSTRUCCION;
	}
	
	public void proveerServicioZona(Plano unPlano){
		 unPlano.devolverHectarea(posicionConstruccion).habilitarElectricidad();
	}
	
	public void establecerCentralQueProveeEnergia(CentralElectrica unaCentralElectrica){
		this.centralElectricaALAQuePertenece = unaCentralElectrica;
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
			return true;
		
		return false;
	}
	
	public void proveerServicioZona(Plano unPlano, Posicion unaPosicion) {
		boolean hayLineasDeTensionAlrededor = false;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		
		//Verifica si hay lineas de tension al rededor
		while (zonaCircundante.tieneSiguiente() && !hayLineasDeTensionAlrededor){
			Hectarea hectareaActual = zonaCircundante.siguiente();
			hayLineasDeTensionAlrededor = hectareaActual.obtenerLineaDeTension().conectadoALaRed(hectareaActual);
		}
		
		
		int consumoElectrico=unPlano.devolverHectarea(unaPosicion).obtenerConstruccion().devolverConsumo();
		boolean sePuedeConstruirSobreAgua = unPlano.devolverHectarea(unaPosicion).obtenerConstruccion().esConstruibleSobreAgua();
		
		//Verifica que no se exceda al consumo permitido por la central el�ctrica
		// y verifica tambien que no se est� construyendo sober una superficei de agua
		conectadoALaRed = !(excedeElConsumo(consumoElectrico)) 
							&& !(sePuedeConstruirSobreAgua)
								&& hayLineasDeTensionAlrededor;
		if (conectadoALaRed)
			unPlano.devolverHectarea(unaPosicion).establecerConexion(this);
			
	
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean conectadoALaRed(Hectarea hectareaActual) {
		return (conectadoALaRed);
	}

	@Override
	public void habilitarConexion() {
		conectadoALaRed = true;
	}

	
}
