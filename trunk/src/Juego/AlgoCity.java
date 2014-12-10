package Juego;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import aplicacion.VistaControlador;
import Ambientes.Ambiente;
import Excepciones.ExcepcionJugadorIngresadoVacio;
import Excepciones.ExcepcionJugadorYaExistente;
import Jugador.Jugador;
import Jugador.JugadorDificil;
import Jugador.JugadorFacil;
import Jugador.JugadorMedio;
import Jugador.JugadorParaTest;
import Jugador.Turno;

public class AlgoCity {
	ArrayList<Jugador> jugadores;
	ArrayList<String> nombresJugadores;
	private VistaControlador vistaControlador;
	private Jugador jugadorActual;
	private Turno turno;
	
	public AlgoCity(){
		this.nombresJugadores = new ArrayList<String>();
		this.levantarNombresJugadoresArchivo();
	}
	
	private void levantarNombresJugadoresArchivo() {
		//deberia levantar de archivo una lista de los nombres de los jugadores 
		//registrados
	}
	
	public void iniciar() {
		this.vistaControlador = new VistaControlador();
		this.vistaControlador.arrancar(this);
	}
	
	public ArrayList<String> darListaJugadoresRegistrados() {
		return this.nombresJugadores;
	}
	
	public Jugador cargarJugador(String nombreJugador) {
		//deberia cargar de archivo cuyo nombre, es el nombre del jugador
		//la partida correspondiente y devolverla
		return null;
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
	
	
	public void finalizar(Jugador jugador) {
		this.turno.terminar();
		
		try {
			jugador.guardarPartida();
		} catch (Exception e) {
		}//suponemos que guarda la partida en un archivo con su nombre
		
		this.guardarNombresJugadores();
	}

	private void guardarNombresJugadores() {
		//deberia guardar la lista actual de nombres de jugadores
	}

	///////////no lo toco pero los que se usan son los metodos de arriba...no se si
	///los que siguen alguno servira
	
	public Jugador crearJugador(String unNombre){
		Jugador nuevoJugador = new JugadorParaTest();
		nuevoJugador.establecerNombreJugador(unNombre);
		
		if(jugadores.contains(nuevoJugador)){
			throw new ExcepcionJugadorYaExistente();
		}
		jugadores.add(nuevoJugador);
		return nuevoJugador;
	}
	
	public void agregarJugador(Jugador unJugador){
		jugadores.add(unJugador);
	}
	
	public boolean hayJugadores(){
		return (!jugadores.isEmpty());
	}

	public void cargarPartidaJugador(String nombreArchivo) throws Exception { // (Dado el archivo de la partida de un jugador, lo manda a hidratar y lo agrega).
		File archivo = new File(nombreArchivo);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Jugador unJugadorCargado = Jugador.hidratar(doc); // Me devuelve una instancia del jugador hidratado.
		this.agregarJugador(unJugadorCargado);
	}
	
	public Jugador obtenerPrimerJugadorRegistrado(){
		return jugadores.get(0);
	}
}