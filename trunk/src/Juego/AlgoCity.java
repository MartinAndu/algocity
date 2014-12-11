package Juego;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import aplicacion.VistaControlador;
import Ambientes.Ambiente;
import Excepciones.ExcepcionJugadorIngresadoVacio;
import Excepciones.ExcepcionJugadorYaExistente;
import Jugador.Jugador;
import Jugador.JugadorDificil;
import Jugador.JugadorFacil;
import Jugador.JugadorMedio;
import Jugador.Turno;

import java.util.Iterator;
import org.w3c.dom.Element;


public class AlgoCity {
	ArrayList<String> nombresJugadores;
	private VistaControlador vistaControlador;
	private Jugador jugadorActual;
	private Turno turno;
	
	public AlgoCity() throws Exception{
		this.nombresJugadores = new ArrayList<String>();
		//this.levantarNombresJugadoresArchivo("jugadores");
	}

	public AlgoCity levantarNombresJugadoresArchivo(String nombreArchivoJugadores) throws Exception{ // Levanta un archivo con la lista de nombres de jugadores registrados.
		File archivo = new File(nombreArchivoJugadores);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();

		return AlgoCity.hidratar(doc);
	}


	private Element guardarNombresJugadores() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element juegoSerializado = this.serializar(doc);
		
		doc.appendChild(juegoSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		String nombreArchivo = "jugadores.xml";
		
		File archivoDestino = new File(nombreArchivo);
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source,result);
		
    	return juegoSerializado;
	}
	
	private Element serializar(Document doc) {
    	Element elementoJuego = doc.createElement("Juego");

    	Iterator<String> it = this.nombresJugadores.iterator();
    	int i = 0;
    	while (it.hasNext()) {
    		String string = (String) it.next();
    		String numeroJugador = Integer.toString(i);
    		elementoJuego.setAttribute(numeroJugador, string);
			i++;
		}
    	return elementoJuego;
	}

	public static AlgoCity hidratar(Document doc) throws Exception {
		Element elementoJuego = (Element)doc.getElementsByTagName("Juego").item(0);

		AlgoCity juegoHidratado = new AlgoCity();
		ArrayList<String> nombresJugadoresHidratado = new ArrayList<String>();
		
		int cantidadJugadoresRegistrados = elementoJuego.getAttributes().getLength();
		
		for(int i = 0 ; i < (cantidadJugadoresRegistrados) ; i++){
			String numeroJugador = Integer.toString(i);
			String nombreJugador = elementoJuego.getAttribute(numeroJugador);
			nombresJugadoresHidratado.add(nombreJugador);			
		}
		
		juegoHidratado.nombresJugadores = nombresJugadoresHidratado;
		return juegoHidratado;
	}

	public void iniciar() {
		this.vistaControlador = new VistaControlador();
		this.vistaControlador.arrancar(this);
	}
	
	public ArrayList<String> darListaJugadoresRegistrados() {
		return this.nombresJugadores;
	}

	public Jugador cargarJugador(String nombreJugador) throws Exception{
		File archivo = new File(nombreJugador);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Jugador unJugadorCargado = Jugador.hidratar(doc); // Me devuelve una instancia del jugador hidratado.
		return unJugadorCargado;
	}
	
	public void verificarNombreJugador(String nombreJugador){
		
		if (nombreJugador.length() < 4){
			throw new ExcepcionJugadorIngresadoVacio();
		}
		if (jugadorEstaRegistrado(nombreJugador))
			throw new ExcepcionJugadorYaExistente();
	}
	
	public boolean jugadorEstaRegistrado(String nombreJugador) {
		///suponemos que nombreJugador no es un String vacio
		return this.nombresJugadores.contains(nombreJugador);
	}
	
	public Jugador crearJugadorDificil(String nombreJugador) {
		JugadorMedio jugador = new JugadorMedio();
		jugador.establecerNombreJugador(nombreJugador);
		this.nombresJugadores.add(nombreJugador);
		this.jugadorActual = jugador;
		return jugador;
	}
	
	public Jugador crearJugadorMedio(String nombreJugador) {
		JugadorDificil jugador = new JugadorDificil();
		jugador.establecerNombreJugador(nombreJugador);
		this.nombresJugadores.add(nombreJugador);
		this.jugadorActual = jugador;
		return jugador;
	}
	
	public Jugador crearJugadorFacil(String nombreJugador) {
		JugadorFacil jugador = new JugadorFacil();
		jugador.establecerNombreJugador(nombreJugador);
		this.nombresJugadores.add(nombreJugador);
		this.jugadorActual = jugador;
		return jugador;
	}
	

	public void jugar(Jugador jugador) {
		Ambiente ambiente = jugador.generarAmbiente();
		this.turno = new Turno(jugador, ambiente);
		this.turno.arrancar();
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}
	
	public void guardarPartida(){
		try{
			this.jugadorActual.guardarPartida();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo guardar la partida");
		}
	}
	
	
	public void finalizar(Jugador jugador) throws Exception {
		this.turno.terminar();
		
		try {
			jugador.guardarPartida();
		} catch (Exception e) {
		}//suponemos que guarda la partida en un archivo con su nombre
		
		this.guardarNombresJugadores();
	}
}