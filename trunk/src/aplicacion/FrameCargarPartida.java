package aplicacion;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Juego.AlgoCity;
import Jugador.Jugador;

public class FrameCargarPartida extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelBotones;
	private JButton cargarPartida,volver;
	@SuppressWarnings("rawtypes")
	private JComboBox listaSeleccionableDeJugadores;
	private Menu panelImagen;
	private AlgoCity algoCity;
	private VistaControlador vistaAnterior;
	
	
	public FrameCargarPartida(AlgoCity algoCity,VistaControlador vistaAnterior){
		super("Menu Cargar Partida");
		this.algoCity = algoCity;
		this.vistaAnterior = vistaAnterior;
		inicializarVentana();
	}
	
	private void inicializarVentana(){
		this.setBounds(0,0,1024,500);
		
		
    	Container c= getContentPane();
    	
    	cargarListaJugadores();
    	crearPanelBotones();
    	inicializarPanelImagen();


    	c.add(listaSeleccionableDeJugadores);
    	c.add(panelBotones);
    	c.add(panelImagen);
    	
    
    	this.setContentPane(c);
	}
	
	private void inicializarPanelImagen(){
		panelImagen = new Menu();
		panelImagen.setBounds(0,0,1024,500);
		new Imagen();
		panelImagen.setBackground(Imagen.loadImg("Images/Walls/FondoAlgoCity.jpg"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void cargarListaJugadores(){
		
		listaSeleccionableDeJugadores = new JComboBox();
		listaSeleccionableDeJugadores.setBounds(400, 50, 300, 50);
		
		

		
		try {
			algoCity.levantarNombresJugadoresArchivo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> nombresJugadores = algoCity.darListaJugadoresRegistrados();
		
		Iterator<String> it = nombresJugadores.iterator();
		while (it.hasNext()){
			String nombre = (String) it.next();
			listaSeleccionableDeJugadores.addItem(nombre);
		}

		
	}
	
	private void crearPanelBotones(){
		panelBotones = new JPanel();
		panelBotones.setBounds(250,150,600,265);
		panelBotones.setLayout(new GridLayout(2,1));
		

		cargarPartida = new JButton();
		cargarPartida.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonContinuarPartida)));
		cargarPartida.addActionListener(this);
		panelBotones.add(cargarPartida);
		

		volver = new JButton();
		volver.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonVolver)));
		volver.addActionListener(this);
		panelBotones.add(volver);
		
	}
	
	public void establecerVistaOrigen(VistaControlador vistaAnterior){
		this.vistaAnterior = vistaAnterior;
	}
	
	public void mostrarVentana(){
		this.setVisible(true);
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == volver){
			this.setVisible(false);
			vistaAnterior.setVisible(true);
		}
		
		if (e.getSource() == cargarPartida){
			
			this.dispose();
			Jugador jugador = null;
			try {
				jugador = algoCity.cargarJugador(listaSeleccionableDeJugadores.getSelectedItem().toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			algoCity.establecerJugadorActual(jugador);
			vistaAnterior.visualizarMapa();
			jugador.establecerVista(vistaAnterior);
			algoCity.jugar(jugador);
		}
		
	}
	
}
