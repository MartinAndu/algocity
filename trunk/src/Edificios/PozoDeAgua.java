package Edificios;

import ConstruccionGeneral.Construccion;

import ConstruccionGeneral.Posicion;
import Estados.EstoyBien;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import PuntosConstruccion.PuntosDePozo;
import Servicios.AdministradorServicios;
import Servicios.Agua;
import Superficies.Superficie;

public class PozoDeAgua extends Construccion {

	static int COSTO_CONSTRUCCION = 250;
	private Plano plano;
	private int radioDeAbastecimientoEnHectareas;
	private String idProveedor;
	
	public PozoDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.radioDeAbastecimientoEnHectareas = 1;
		this.idProveedor = java.util.UUID.randomUUID().toString(); 
		this.idConstruccion = "pozo";
		this.puntosDeConstruccion = new PuntosDePozo();	
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada{

		try {
			this.puntosDeConstruccion.incrementar(puntosDeReconstruccion);
		} catch (ExceptionConstruccionComplemtamenteReparada e) {
			this.estadoConstruccion = new EstoyBien();
			this.proveerServicioZona();
			throw new ExceptionConstruccionComplemtamenteReparada();
		}
		
		
	}

	private void proveerServicioZona() {
		Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectarea = zonaCircundante.siguiente();
			hectarea.agregarServicioAProveer(new Agua(this.idProveedor));
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
	
	private void quitarServicioZona() {
		Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectarea = zonaCircundante.siguiente();
			hectarea.quitarServicioAProveer(new Agua(this.idProveedor));
		}				
	}
	
	@Override
	public void construirseSobre(Superficie superficie) {
		if (!superficie.sePuedeConstruirUnPozoDeAgua()) {
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
	}

	@Override
	public void construirJuntoA(Construccion construccionAAgregar) {
		throw new ExcepcionHectareaYaContieneUnaConstruccion();
	}

	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {
	}

	@Override
	public void construirSobrePlano(Plano plano) {
		this.plano = plano;
		Hectarea hectarea = plano.devolverHectarea(this.posicionConstruccion);
		hectarea.agregarConstruccion(this);
		this.proveerServicioZona();		
	}

	@Override
	public void quitarDelPlano() {
		this.quitarServicioZona();
	}
	
}
