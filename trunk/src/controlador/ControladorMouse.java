package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;
import vista.VistaModeloDato;


public class ControladorMouse extends MouseAdapter {

	Jugador jugadorModelo;
    VistaModeloDato vista;
    BotonInteraccionPanel botonInteraccionPresionado;
    

    public ControladorMouse(Jugador jugadorModelo, VistaModeloDato vista) {
        this.jugadorModelo = jugadorModelo;
        this.vista = vista;
    }

    public void establecerBotonConstruccionPresionado(BotonInteraccionPanel botonInteraccionPresionado){
    	this.botonInteraccionPresionado = botonInteraccionPresionado;
    }
    
    public void mousePressed(MouseEvent mouseEvent) {
    	jugadorModelo.darControlador().botonInteraccionPresionado.prepararAccion(vista.getPosicion());
    }
}
