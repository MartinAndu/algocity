package aplicacion;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Juego.AlgoCity;

public class FrameJugadorNuevo extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField nombreJugador;
	private JButton jugadorFacil,jugadorMedio,jugadorDificil,volver;
	private JPanel panelBotones;
	private Menu panelImagen;
	private AlgoCity algoCity;
	
	public FrameJugadorNuevo(AlgoCity algoCity){
		super("Menu Nueva Partida");
		this.algoCity = algoCity;
		inicializarVentana();
	}
	
	private void inicializarVentana(){
		this.setBounds(0,0,1024,500);
		
		
    	Container c= getContentPane();
    	
    	crearTextoJugador();
    	crearPanelBotones();
    	inicializarPanelImagen();


    	c.add(nombreJugador);
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
	
	private void crearTextoJugador(){
		nombreJugador = new JTextField();
		nombreJugador.setBounds(430, 0, 300, 50);
		
	}
	
	private void crearPanelBotones(){
		panelBotones = new JPanel();
		panelBotones.setBounds(430,150,200,265);
		panelBotones.setLayout(new GridLayout(4,1));
		
		jugadorFacil = new JButton("Jugador Facil");
		jugadorFacil.addActionListener(this);
		panelBotones.add(jugadorFacil);

		jugadorMedio = new JButton("Jugador Medio");
		jugadorMedio.addActionListener(this);
		panelBotones.add(jugadorMedio);
		

		jugadorDificil = new JButton("Jugador Dificil");
		jugadorDificil.addActionListener(this);
		panelBotones.add(jugadorDificil);
		

		volver = new JButton("Volver");
		volver.addActionListener(this);
		panelBotones.add(volver);
		
	}
	
	public void mostrarVentana(){
		this.setVisible(true);
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
