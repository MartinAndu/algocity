package Edificios;

import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import Estados.EstoyBien;
import Estados.EstoyDestruido;
import Estados.MeFaltaVarios;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import Servicios.AdministradorServicios;
import Superficies.Superficie;

public abstract class Edificio extends Construccion {
	
	protected int consumoElectrico;
	
	public Edificio(Posicion posicion) {
		super(posicion);
		this.idConstruccion = "edificio";
	}
	
	public int devolverConsumo(){
		return consumoElectrico;
	}

	public void construirSobrePlano(Plano unPlano){
		Hectarea hectarea = unPlano.devolverHectarea(posicionConstruccion);
		AdministradorServicios administrador = hectarea.serviciosAConsumir();
		
		if (!this.administradorPoseeServicioQueRequiero(administrador)) {
			throw new ExcepcionHectareaNoBrindaLosServiciosNecesarios();
		}
		hectarea.agregarConstruccion(this);
	}

	protected abstract boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador);

	@Override
	public void construirJuntoA(Construccion construccionAAgregar) {
		throw new ExcepcionHectareaYaContieneUnaConstruccion();
	}

	@Override
	public void construirseSobre(Superficie superficie) {
		if (!superficie.sePuedeConstruirUnEdificioOCentral()) {
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
	}
	
	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {
		
		if (!administradorServicios.poseeLosServiciosBasicos()) {
			this.estadoConstruccion = new MeFaltaVarios();
		}
	}
	
	@Override
	public void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada{
		try {
			this.puntosDeConstruccion.incrementar(puntosDeReconstruccion);
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
			this.estadoConstruccion = new EstoyBien();
			throw new ExceptionConstruccionComplemtamenteReparada();
		}
	}

	@Override
	public void destruir() {
		this.puntosDeConstruccion.decrementar();
		this.estadoConstruccion = new EstoyDestruido();
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		this.puntosDeConstruccion.decrementarEnPorcentaje(porcentaje);
		this.estadoConstruccion = new EstoyDestruido();		
	}

	@Override
	public void quitarDelPlano() {
	}
}
