package Edificios;

import java.awt.image.BufferedImage;

import aplicacion.Imagen;
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
		this.costoConstruccion = COSTO_CONSTRUCCION;
		this.radioDeAbastecimientoEnHectareas = 1;
		this.idProveedor = java.util.UUID.randomUUID().toString(); 
		this.idConstruccion = "pozo";
		this.puntosConstruccion = new PuntosDePozo();	
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada{

		try {
			this.puntosConstruccion.incrementar(puntosDeReconstruccion);
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
		this.puntosConstruccion.decrementar();
		this.quitarServicioZona();		
	}

	

	@Override
	public void destruirEnUnPorcentaje(int porcentaje) {
		this.puntosConstruccion.decrementarEnPorcentaje(porcentaje);
		this.quitarServicioZona();
	}
	
	private void quitarServicioZona() {
		try {
			Recorrido zonaCircundante = this.plano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectarea = zonaCircundante.siguiente();
			hectarea.quitarServicioAProveer(new Agua(this.idProveedor));
		}	
		} catch (NullPointerException e) {
		}
					
	}
	
	@Override
	public void verificarSuperficie(Superficie superficie) {
		if (!superficie.sePuedeConstruirUnPozoDeAgua()) {
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
	}

	@Override
	public void verificarAfinidadConConstruccion(Construccion construccionAAgregar) {
		throw new ExcepcionHectareaYaContieneUnaConstruccion();
	}

	@Override
	public void verificarServicios(AdministradorServicios administradorServicios) {
	}

	@Override
	public void agregarAlPlano(Plano plano) {
		this.plano = plano;
		Hectarea hectarea = plano.darHectarea(this.posicionConstruccion);
		hectarea.agregarConstruccion(this);
		this.proveerServicioZona();		
	}

	@Override
	public void quitarDelPlano() {
		this.quitarServicioZona();
	}
	
	public BufferedImage graficar() {
		return Imagen.loadImg("Images/Walls/PozoDeAgua.jpg");
	}
}
