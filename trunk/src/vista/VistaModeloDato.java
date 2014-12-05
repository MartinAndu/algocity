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
import Superficies.Superficie;


public class VistaModeloDato extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Posicion posicion;
	private Jugador jugadorModelo;
	
	private static Color AZUL = Color.BLUE;
	private static Color ROJO = Color.RED;

	
   public VistaModeloDato(Posicion posicion, Jugador jugadorModelo) {
        this.setPosicion(posicion);
        this.jugadorModelo = jugadorModelo;
        this.jugadorModelo.addObserver(this);
    	setPreferredSize(new Dimension(25,25));
        addMouseListener(new ControladorMouse(jugadorModelo, this));
    }
   
	@Override
	public void update(Observable o, Object obj) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	
	public void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        Superficie superficie = jugadorModelo.obtenerPlano().devolverHectarea(posicion).obtenerSuperficie();
        
        
        grafico.setColor(Color.GREEN);
        if (superficie.sePuedeConstruirUnPozoDeAgua()) 
        	grafico.setColor(AZUL);
        
        grafico.fillRect(0, 0, 25,25);
        grafico.drawRect(0,0, 25, 25);
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}



	
		

}