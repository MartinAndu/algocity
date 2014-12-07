package Conectores;

import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import Estados.EstoyBien;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import Servicios.AdministradorServicios;
import Servicios.Servicio;
import Superficies.Superficie;

public abstract class Conexion extends Construccion {

	static final int RADIO_DE_DISTRIBUCION = 1;
	protected Plano plano;
	private int radioDeAbastecimientoEnHectareas;
	protected String idProveedor;

	public Conexion(Posicion posicion) {
		super(posicion);
		this.idConstruccion = "conexion";
		this.radioDeAbastecimientoEnHectareas = Conexion.RADIO_DE_DISTRIBUCION;
		this.idProveedor = java.util.UUID.randomUUID().toString(); 
	}
	
	public void construirSobrePlano(Plano unPlano){
		this.plano = unPlano;
		Hectarea hectarea = unPlano.devolverHectarea(this.posicionConstruccion);
		AdministradorServicios administrador = hectarea.serviciosAConsumir();
		
		if (!this.administradorPoseeServicioQueRequiero(administrador)) {
			throw new ExcepcionHectareaNoBrindaLosServiciosNecesarios();
		}
		hectarea.agregarConstruccion(this);
		this.proveerServicioZona();
	}

	protected abstract boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador);

	public void proveerServicioZona(){
		Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectarea = zonaCircundante.siguiente();
			hectarea.agregarServicioAProveer(this.servicioAProveer());
		}	
	}

	protected abstract Servicio servicioAProveer();

	@Override
	public void construirJuntoA(Construccion construccionAAgregar) {
		if (this.idConstruccion != construccionAAgregar.idConstruccion()) {
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
	}

	@Override
	public void construirseSobre(Superficie superficie) {
		if (!superficie.sePuedeConstruirUnaConexion()) {
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
	}

	@Override
	public abstract void verificarServicios(AdministradorServicios administradorServicios);
	

	protected void quitarServicioZona() {
		Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectarea = zonaCircundante.siguiente();
			hectarea.quitarServicioAProveer(this.servicioAProveer());
		}		
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada {
		try {
			this.puntosDeConstruccion.incrementar(puntosDeReconstruccion);
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
			this.estadoConstruccion = new EstoyBien();
			this.proveerServicioZona();
			throw new ExceptionConstruccionComplemtamenteReparada();
		}	
	}

	@Override
	public void destruir() {
		this.puntosDeConstruccion.decrementar();
		this.quitarServicioZona();
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		this.puntosDeConstruccion.decrementarEnPorcentaje(porcentaje);
		this.quitarServicioZona();
	}
	
	@Override
	public void quitarDelPlano() {
		this.quitarServicioZona();
	}
}
