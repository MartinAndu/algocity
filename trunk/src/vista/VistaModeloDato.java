package vista;

import java.awt.Color;
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
	

	
   public VistaModeloDato(Posicion posicion, Jugador jugadorModelo) {
        this.setPosicion(posicion);
        ControladorMouse controlador = new ControladorMouse(jugadorModelo, this);
        
        jugadorModelo.establecerControlador(controlador);
        jugadorModelo.addObserver(this);
        this.jugadorModelo = jugadorModelo;
        
        int anchoX = jugadorModelo.darPlano().darAncho();
        int altoY = jugadorModelo.darPlano().darAlto();
    	setPreferredSize(new Dimension(anchoX,altoY));
    	
    	
    	
        addMouseListener(controlador);
        
    }
   
	@Override
	public void update(Observable o, Object obj) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	
	public void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        
        jugadorModelo.darPlano().darHectarea(posicion).GraficarHectarea(grafico);
        
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}