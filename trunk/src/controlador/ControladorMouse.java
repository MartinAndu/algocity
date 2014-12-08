package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;
import vista.VistaModeloDato;


public class ControladorMouse extends MouseAdapter {

	Jugador jugadorModelo;
    VistaModeloDato vista;
    BotonConstruccion botonConstruccionPresionado;
    

    public ControladorMouse(Jugador jugadorModelo, VistaModeloDato vista) {
        this.jugadorModelo = jugadorModelo;
        this.vista = vista;
    }

    public void establecerBotonConstruccionPresionado(BotonConstruccion botonConstruccionPresionado){
    	this.botonConstruccionPresionado = botonConstruccionPresionado;
    }
    
    public void mousePressed(MouseEvent mouseEvent) {
    	jugadorModelo.obtenerControlador().botonConstruccionPresionado.prepararConstruccion(vista.getPosicion());
    }
}
