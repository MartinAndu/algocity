package Jugador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import aplicacion.VistaControlador;

import vista.ListaDeVistas;
import controlador.ControladorMouse;
import Ambientes.Ambiente;
import Bomberos.EstacionDeBomberos;
import Catastrofe.Catastrofe;
import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import ConstruccionGeneral.Reconstruible;
import Constructor.Constructor;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionDineroInsuficiente;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import Poblacion.Poblacion;
import Presupuesto.Presupuesto;

public abstract class Jugador extends Observable{

	protected Poblacion poblacion;
	protected Presupuesto presupuesto;
	protected Plano plano;
	protected EstacionDeBomberos estacionDeBomberos;
	protected Constructor constructor;
	protected String nombreJugador;
	protected ControladorMouse controlador;
	protected Construccion construccionPreparada;
	private List<Construccion> construcciones;
	private VistaControlador vista;
	private int numeroDeDia;
	
	public Jugador() {
		this.construcciones = new ArrayList<Construccion>();
		numeroDeDia = 1;
	}

	public void establecerNombreJugador(String unNombre){
		this.nombreJugador = unNombre;
	}
	
	public int obtenerNumeroDeDia(){
		return this.numeroDeDia;
	}
	
	public abstract Ambiente generarAmbiente();

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
		elementoJugador.appendChild(this.plano.serializar(doc));
		
		return elementoJugador;
	}
	
	public static Jugador hidratar(Document doc) {
		Jugador nuevoJugador = new JugadorParaTest();
		Element elementoJugador = (Element)doc.getElementsByTagName("Jugador").item(0);
		
		nuevoJugador.nombreJugador = (elementoJugador).getAttribute("nombre");
		
		Presupuesto nuevoPresupuesto = Presupuesto.hidratar( elementoJugador.getElementsByTagName("Presupuesto").item(0) );
		nuevoJugador.presupuesto = nuevoPresupuesto;

		Poblacion nuevaPoblacion = Poblacion.hidratar( elementoJugador.getElementsByTagName("Poblacion").item(0) );
		nuevoJugador.poblacion = nuevaPoblacion;

		Plano nuevoPlano = Plano.hidratar( elementoJugador.getElementsByTagName("Plano").item(0) );
		nuevoJugador.plano = nuevoPlano;

		return nuevoJugador;
	}
	
	public int obtenerCantidadPoblacion(){
		return this.poblacion.darCantHabitantes();
	}
	
	public String obtenerNombre() {
		return nombreJugador;
	}

	public void incrementarPoblacionEnPorcentaje(int porcentajeDeIncrementoPoblacional) {
		poblacion.incrementar(porcentajeDeIncrementoPoblacional);
	}

	public int darCantDineroEnPresupuesto() {
		return presupuesto.obtenerCantidadDeDinero();
		
	}

	public void destruirConstruccionesPorCatastrofe(Catastrofe catastrofe) {
		JOptionPane.showMessageDialog(null, "¡Oh no ha pasado (un)" + catastrofe.getClass().getName() + "por la ciudad!" );
		catastrofe.destruirCiudad(this.plano);
		ArrayList<Reconstruible> reconstruibles = catastrofe.darListaConstruccionesDestruidas();
		estacionDeBomberos.agregarReconstruibles(reconstruibles);
		this.vista.graficarCambiosEstadoConstrucciones(this.construcciones);
		

		setChanged();
		this.notifyObservers();
	}

	public void habilitarEstacionDeBomberos() {
		try{
			this.estacionDeBomberos.habilitar(presupuesto);
			setChanged();
			this.notifyObservers();
		}catch(ExcepcionDineroInsuficiente e){}
	}

	public void pasoUnTurno() {
		this.estacionDeBomberos.realizarReparaciones();
		this.vista.graficarCambiosEstadoConstrucciones(this.construcciones);
		numeroDeDia++;
		setChanged();
		this.notifyObservers();
	}

	public void reducirPresupuestoPorHabitante(int comisionPorHabitante) {
		int comisionTotal = comisionPorHabitante * this.poblacion.darCantHabitantes();
		this.presupuesto.reducir(comisionTotal);
	}

	public void incrementarPresupuestoEnPorcentaje(int porcentaje) {
		this.presupuesto.incrementarEnPorcentaje(porcentaje);
	}

	public void crearPozoDeAgua(Posicion posicion) {
		PozoDeAgua pozo = this.constructor.construirPozoDeAgua(posicion);
		this.agregarAlPlano(pozo);
	}
	
	public void crearResidencia(Posicion posicion) {
		EdificioResidencial residencia = this.constructor.construirResidencia(posicion);
		this.agregarAlPlano(residencia);
	}
	
	public void crearIndustria(Posicion posicion) {
		EdificioIndustrial industria = this.constructor.construirIndustria(posicion);
		this.agregarAlPlano(industria);
	}
	
	public void crearComercio(Posicion posicion) {
		EdificioComercial comercio = this.constructor.construirComercio(posicion);
		this.agregarAlPlano(comercio);
	}

	public void crearLineaDeTension(Posicion posicion) {
		LineasDeTension linea = this.constructor.construirLineaDeTension(posicion);
		this.agregarAlPlano(linea);
	}
	
	public void crearTuberiaDeAgua(Posicion posicion) {
		ConexionDeAgua canio = this.constructor.construirTuberia(posicion);
		this.agregarAlPlano(canio);
	}
	
	public void crearRutaPavimentada(Posicion posicion) {
		RutaPavimentada ruta = this.constructor.construirRuta(posicion);
		this.agregarAlPlano(ruta);
	}
	
	public void crearCentralMineral(Posicion posicion) {
		CentralMineral central = this.constructor.construirCentralMineral(posicion);
		this.agregarAlPlano(central);
	}
	
	public void crearCentralNuclear(Posicion posicion) {
		CentralNuclear central = this.constructor.construirCentralNuclear(posicion);
		this.agregarAlPlano(central);
	}
	
	public void crearCentralEolica(Posicion posicion) {
		CentralEolica central = this.constructor.construirCentralEolica(posicion);
		this.agregarAlPlano(central);
	}
	
	private void agregarAlPlano(Construccion construccion) {
		try{
			this.presupuesto.reducir(construccion.darCosto());
			construccion.agregarAlPlano(this.plano);
			this.construcciones.add(construccion);
			this.vista.graficarCambiosEstadoConstrucciones(this.construcciones);
			//Interviene en la vista notificando que hubo cambio al observador


		}catch (ExcepcionDineroInsuficiente e){}
		
		setChanged();
		this.notifyObservers();

	}
	
	public void eliminarConstruccion(Posicion posicion) {
		try {
			Hectarea hectarea = this.plano.darHectarea(posicion);
			Construccion construccion = hectarea.quitarConstruccion();
			construccion.quitarDelPlano();
			this.construcciones.remove(construccion);
			this.vista.graficarCambiosEstadoConstrucciones(this.construcciones);
		} catch (NullPointerException e) {
		}
		
		setChanged();
	    this.notifyObservers();
	}

	public void reducirPresupuestoEnPorcentaje(int porcentajeDeReduccion) {
		this.presupuesto.reducirEnPorcentaje(porcentajeDeReduccion);
	}
	
	public Plano darPlano(){
		return this.plano;
	}
	
	public void establecerControlador(ControladorMouse controlador){
		this.controlador = controlador;
	}
	
	public ControladorMouse darControlador(){
		return this.controlador;
	}
	
	public void establecerVista(VistaControlador vista) {
		this.vista = vista;
	}
	
	

}
