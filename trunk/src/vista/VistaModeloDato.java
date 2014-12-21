package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import aplicacion.Archivo;
import aplicacion.Imagen;
import controlador.ControladorMouse;
import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import Jugador.Jugador;
import PlanoGeneral.Hectarea;
import Superficies.Superficie;


public class VistaModeloDato extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Posicion posicion;
	private Jugador jugadorModelo;
	boolean vistaSubterranea;
	private ListaDeVistasConstrucciones representacionesDeConstrucciones;
	private ListaDeVistasSuperficies representacionesDeSuperficies;

	
   public VistaModeloDato(Posicion posicion, Jugador jugadorModelo) {
        this.setPosicion(posicion);
        ControladorMouse controlador = new ControladorMouse(jugadorModelo, this);
        
        jugadorModelo.establecerControlador(controlador);
        jugadorModelo.addObserver(this);
        this.jugadorModelo = jugadorModelo;
        this.representacionesDeConstrucciones = new ListaDeVistasConstrucciones();
        this.representacionesDeSuperficies = new ListaDeVistasSuperficies();
        
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
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        this.setOpaque(false);
        //jugadorModelo.darPlano().darHectarea(posicion).GraficarHectarea(grafico,this.vistaSubterranea);
        Hectarea hectareaActual = jugadorModelo.darPlano().darHectarea(posicion);
        Superficie superficieActual = hectareaActual.darSuperficie();
        ArrayList<Construccion> construcciones = hectareaActual.obtenerConstrucciones();
        
        Construccion construccion = null;
		
		if (hectareaActual.obtenerEstadoCatastrofe()){
			g.drawImage(Imagen.loadImg("Images/Walls/Godzilla.jpg"),0,0,null);
			hectareaActual.seAcaboLaCatastrofe();
		}else{
			if (vistaSubterranea){
				g.drawImage(Imagen.loadImg(Archivo.SuperficieSubterranea), 0, 0, null);
				if (superficieActual.sePuedeConstruirUnPozoDeAgua())
					g.drawImage(representacionesDeSuperficies.obtenerVistaSuperficie(superficieActual).obtenerRepresentacionDeLaSuperficie(), 0, 0, null);
				
				if (construcciones.size() > 0){
					Iterator<Construccion> it = construcciones.iterator();
					while (it.hasNext()) {
						construccion = (Construccion) it.next();
						
						if (construccion.esConstruibleBajoTierra())
							g.drawImage(representacionesDeConstrucciones.obtenerVistaConstruccion(construccion).obtenerRepresentacionDeLaConstruccion(), 0, 0, null);
					}
				}
				
			}
			else{
				g.drawImage(representacionesDeSuperficies.obtenerVistaSuperficie(superficieActual).obtenerRepresentacionDeLaSuperficie(), 0, 0, null);
				if (construcciones.size() > 0){
					
					Iterator<Construccion> it = construcciones.iterator();
			    	while (it.hasNext()) {
						construccion = (Construccion) it.next();
						if (!construccion.esConstruibleBajoTierra())
							g.drawImage(representacionesDeConstrucciones.obtenerVistaConstruccion(construccion).obtenerRepresentacionDeLaConstruccion(), 0, 0, null);
					}
			    	
				}
			}
		}
		

        
        
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