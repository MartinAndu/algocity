package aplicacion;



import java.awt.Color;
import java.awt.Container;






import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;









import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ConstruccionGeneral.Construccion;
import Juego.AlgoCity;


public class VistaControlador extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelMenu;
	private Menu panelImagen;
	private JButton inicioPartida,continuarPartida,verPuntaje,salir;
	private AlgoCity algoCity;

	
	public VistaControlador() {
		super("AlgoCity");
		inicializarVentana();
	}

	public void arrancar(AlgoCity algoCity){
		this.algoCity = algoCity;
		this.mostrarVentana();
		
	}
	
	public void visualizarMapa(){
		new FramePlano(this.algoCity).mostrarVentana();
	}
	
	private void inicializarVentana() {
		
    	this.setBounds(0,0,1024,500);
    	
    	Container c= getContentPane();
    
    	
    	inicializarPanelMenu();
    	inicializarPanelImagen();
    	
    	c.add(panelMenu);
    	c.add(panelImagen);
    	
    	
    	this.setContentPane(c);

	}
	
	private void inicializarPanelImagen(){
		panelImagen = new Menu();
		panelImagen.setBounds(0,0,1024,500);
		new Imagen();
		panelImagen.setBackground(Imagen.loadImg("Images/Walls/FondoAlgoCity.jpg"));
	}
	
	private void inicializarPanelMenu(){
		panelMenu = new JPanel();
		panelMenu.setBounds(250,150,600,265);
		panelMenu.setLayout(new GridLayout(3,1));
		
		
		inicioPartida = new JButton("Inicio Partida");
		inicioPartida.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonPartidaNueva)));
		inicioPartida.addActionListener(this);
		panelMenu.add(inicioPartida);
		
		continuarPartida = new JButton("Continuar Partida");
		continuarPartida.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonContinuarPartida)));
		panelMenu.add(continuarPartida);
		
		/*
		verPuntaje = new JButton("Ver Puntajes");
		verPuntaje.addActionListener(this);
		verPuntaje.setFont(new Font("Sans Serif", Font.PLAIN, 25));
		verPuntaje.setBackground(marron);
		panelMenu.add(verPuntaje);
		*/
		
		salir = new JButton("Salir");
		salir.setIcon(new ImageIcon(Imagen.loadImg(Archivo.BotonSalir)));
		panelMenu.add(salir);
		
	}
	

	private void mostrarVentana(){
		this.setVisible(true);
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == inicioPartida){
			this.setVisible(false);
			new FrameJugadorNuevo(algoCity,this).mostrarVentana();
		}
		
		if (e.getSource() == salir)
			System.exit(0);
		
	}

	public void graficarCambiosEstadoConstrucciones(
			List<Construccion> construcciones) {
		//encargado de crear; martin: verifica el estado de las construccion y lo grafica;
		
	}
	




}