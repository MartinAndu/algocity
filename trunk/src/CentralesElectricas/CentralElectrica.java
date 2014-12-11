package CentralesElectricas;

import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import Estados.EstoyBien;
import Estados.MeFaltaAgua;
import Excepciones.ExcepcionCentralElectricaNoPoseeRedDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import Servicios.AdministradorServicios;
import Servicios.AltaTension;
import Superficies.Superficie;

public abstract class CentralElectrica extends Construccion{
	
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	protected String idProveedor;
	private Plano plano;
	
	public CentralElectrica(Posicion posicion) {
		super(posicion);
		this.idConstruccion = "central";
		this.capacidadDeAbastecimientoEnMW = 0;
		this.idProveedor = java.util.UUID.randomUUID().toString(); 
	}
	
	public void agregarAlPlano(Plano unPlano){
		this.plano = unPlano;
		Hectarea hectarea = unPlano.darHectarea(this.posicionConstruccion);
		AdministradorServicios administrador = hectarea.serviciosAConsumir();
		
		if (!administrador.poseeAgua()) {
			throw new ExcepcionCentralElectricaNoPoseeRedDeAgua();
		}
		hectarea.agregarConstruccion(this);
		this.proveerElectricidadZona();
	}
	
	public void proveerElectricidadZona(){
		Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectarea = zonaCircundante.siguiente();
			hectarea.agregarServicioAProveer(new AltaTension(this.idProveedor));
		}	
	}
	
	public int obtenerCapacidadDeAbastecimientoEnMW(){
		return capacidadDeAbastecimientoEnMW;
	}
	
	public int obtenerCapacidadMaxDeAbastecimientoEnMW(){
		return capacidadMaxDeAbastecimientoEnMW;
	}
	
	public void setearCapacidadDeAbastecimientoEnMW(int capacidadParaAsignar){
		this.capacidadDeAbastecimientoEnMW = capacidadParaAsignar;
	}

	@Override
	public void verificarAfinidadConConstruccion(Construccion construccionAAgregar) {
		throw new ExcepcionHectareaYaContieneUnaConstruccion();
	}

	@Override
	public void verificarSuperficie(Superficie superficie) {
		if (!superficie.sePuedeConstruirUnEdificioOCentral()) {
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
	}

	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {
		if (!administradorServicios.poseeAgua()) {
			this.estadoConstruccion = new MeFaltaAgua();
			this.quitarElectricidadZona();
		}else {
			this.estadoConstruccion = new EstoyBien();
			this.proveerElectricidadZona();
		}
	}

	private void quitarElectricidadZona() {
		try {
			Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

			while (zonaCircundante.tieneSiguiente()){
				Hectarea hectarea = zonaCircundante.siguiente();
				hectarea.quitarServicioAProveer(new AltaTension(this.idProveedor));
			}
		} catch (NullPointerException e) {
		}
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada {
		try {
			this.puntosConstruccion.incrementar(puntosDeReconstruccion);
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
			this.estadoConstruccion = new EstoyBien();
			this.proveerElectricidadZona();
			throw new ExceptionConstruccionComplemtamenteReparada();
		}	
	}

	@Override
	public void destruir() {
		this.puntosConstruccion.decrementar();
		this.quitarElectricidadZona();
	}

	@Override
	public void destruirEnUnPorcentaje(int porcentaje) {
		this.puntosConstruccion.decrementarEnPorcentaje(porcentaje);
		this.quitarElectricidadZona();
	}

	@Override
	public void quitarDelPlano() {
		this.quitarElectricidadZona();
	}

	
}
