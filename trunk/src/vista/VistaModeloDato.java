package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controlador.ControladorMouse;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;


public class VistaModeloDato extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Posicion posicion;
	private Jugador jugadorModelo;
	boolean vistaSubterranea;

	
   public VistaModeloDato(Posicion posicion, Jugador jugadorModelo) {
        this.setPosicion(posicion);
        ControladorMouse controlador = new ControladorMouse(jugadorModelo, this);
        
        jugadorModelo.establecerControlador(controlador);
        jugadorModelo.addObserver(this);
        this.jugadorModelo = jugadorModelo;
        
        int anchoX = jugadorModelo.darPlano().darAncho();
        int altoY = jugadorModelo.darPlano().darAlto();
    	setPreferredSize(new Dimension(anchoX,altoY));
    	
    	
    	vistaSubterranea = false;
        addMouseListener(controlador);
        
    }
   
	@Override
	public void update(Observable o, Object obj) {
		repaint();
	}
	
	public void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        
        this.setOpaque(false);
        jugadorModelo.darPlano().darHectarea(posicion).GraficarHectarea(grafico,this.vistaSubterranea);
	}
	
	
	public void verVistaNormal(){
		this.vistaSubterranea = false;
		repaint();
	}
	
	public void verVistaSubterranea(){
		this.vistaSubterranea = true;
		repaint();
	}
	

	
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}