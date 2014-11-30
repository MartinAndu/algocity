package Jugador;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Bomberos.EstacionDeBomberos;
import Catastrofe.Catastrofe;
import CentralesElectricas.CentralMineral;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Constructor.Constructor;
import Edificios.Construccion;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import Edificios.Reconstruible;
import PlanoGeneral.Plano;
import Poblacion.Poblacion;
import Presupuesto.Presupuesto;

public abstract class Jugador {

	protected Poblacion poblacion;
	protected Presupuesto presupuesto;
	protected Plano plano;
	protected EstacionDeBomberos estacionDeBomberos;
	protected Constructor constructor;
	protected String nombreJugador;
	
	public Jugador() {
		this.plano = new Plano(64, 32);
	}

	public void establecerNombreJugador(String unNombre){
		this.nombreJugador = unNombre;
	}

	public void guardarPartida() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element jugadorSerializado = this.serializar(doc);
		
		doc.appendChild(jugadorSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		String nombreArchivo = this.obtenerNombre() + ".xml";
		
		File archivoDestino = new File(nombreArchivo);
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source,result);
	}
	
	public Element serializar(Document doc) {
		Element elementoJugador = doc.createElement("Jugador");

		elementoJugador.setAttribute("nombre", this.nombreJugador);
		elementoJugador.appendChild(this.presupuesto.serializar(doc));
		elementoJugador.appendChild(this.poblacion.serializar(doc));
/**
		elementoJugador.appendChild(this.plano.serializar(doc));	
**/
		return elementoJugador;
	}
	
	public static Jugador hidratar(Document doc) {
		Jugador nuevoJugador = new JugadorMedio();
		Element elementoJugador = (Element)doc.getElementsByTagName("Jugador").item(0);
		
		nuevoJugador.nombreJugador = (elementoJugador).getAttribute("nombre");
		
		Presupuesto nuevoPresupuesto = Presupuesto.hidratar( elementoJugador.getElementsByTagName("Presupuesto").item(0) );
		nuevoJugador.presupuesto = nuevoPresupuesto;

		Poblacion nuevaPoblacion = Poblacion.hidratar( elementoJugador.getElementsByTagName("Poblacion").item(0) );
		nuevoJugador.poblacion = nuevaPoblacion;
/**
		Plano nuevoPlano = Plano.hidratar( elementoJugador.getElementsByTagName("Plano").item(0) );
		nuevoJugador.plano = nuevoPlano;
**/
		return nuevoJugador;
	}
	
	private String obtenerNombre() {
		return nombreJugador;
	}

	public int obtenerPoblacionSinHogar() {
		return poblacion.cantHabitantesSinHogar();
	}

	public void poblacionSeIncrementoEnPorcetaje(int porcentajeDeIncrementoPoblacional) {
		poblacion.incrementar(porcentajeDeIncrementoPoblacional);
		
	}

	public int obtenerPresupuesto() {
		return presupuesto.obtenerCantidadDeDinero();
	}

	public void huboUnaCatastrofe(Catastrofe catastrofe) {
		catastrofe.destruirCiudad(this.plano);
		ArrayList<Reconstruible> reconstruibles = catastrofe.obtenerListaDeEstructurasDestruidas();
		estacionDeBomberos.agregarReconstruibles(reconstruibles);
	}

	public void habilitarEstacionDeBomberos() {
		this.estacionDeBomberos.habilitar(presupuesto);		
	}

	public void pasoUnTurno() {
		this.estacionDeBomberos.realizarReparaciones();
	}

	public void seCobraUnaComisionPorHabitante(int comisionPorHabitante) {
		int comisionTotal = comisionPorHabitante * this.poblacion.obtenerCantHabitantes();
		this.presupuesto.reducirPresupuesto(comisionTotal);
	}

	public void presupuestoSeIncrementoEnPorcentaje(int porcentaje) {
		this.presupuesto.incrementarEnPorcentaje(porcentaje);
	}

	public void crearPozoDeAgua(Posicion posicion) {
		PozoDeAgua pozo = this.constructor.construirPozoDeAgua(posicion);
		pozo.construirSobrePlano(plano);	
		this.presupuesto.reducirPresupuesto(pozo.devolverCosto());
	}
	
	public void crearResidencia(Posicion posicion) {
		EdificioResidencial residencia = this.constructor.construirZonaResidencial(posicion);
		this.agregarAlPlano(residencia);
	}

	public void crearLineaDeTension(Posicion posicion) {
		LineasDeTension linea = this.constructor.construirLineaDeTension(posicion);
		this.agregarAlPlano(linea);
	}
	
	public void crearTuberiaDeAgua(Posicion posicion) {
		ConexionDeAgua canio = this.constructor.construirTuberia(posicion);
		this.agregarAlPlano(canio);
	}
	
	public void crearCentralElectricaMineral(Posicion posicion) {
		CentralMineral central = this.constructor.construirCentralMineral(posicion);
		this.agregarAlPlano(central);
	}
	
	public void crearRutaPavimentada(Posicion posicion) {
		RutaPavimentada ruta = this.constructor.construirRuta(posicion);
		this.agregarAlPlano(ruta);
	}
	
	private void agregarAlPlano(Construccion construccion) {
		construccion.construirSobrePlano(this.plano);
		this.presupuesto.reducirPresupuesto(construccion.devolverCosto());
	}

}
