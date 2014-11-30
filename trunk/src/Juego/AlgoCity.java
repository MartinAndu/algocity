package Juego;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import Excepciones.ExcepcionJugadorYaExistente;
import Jugador.Jugador;
import Jugador.JugadorParaTest;

public class AlgoCity {
	List<Jugador> jugadores;
	
	public AlgoCity(){
		jugadores = new ArrayList<Jugador>();
	}
	
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
}