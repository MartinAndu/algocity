package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Jugador.Jugador;
import vista.VistaModeloDato;


public class ControladorMouse extends MouseAdapter {

	Jugador jugadorModelo;
    VistaModeloDato vista;

    public ControladorMouse(Jugador jugadorModelo, VistaModeloDato vista) {
        this.jugadorModelo = jugadorModelo;
        this.vista = vista;
    }

    public void mousePressed(MouseEvent mouseEvent) {

        // modelo.inicializarModeloDato(new Posicion(mouseEvent.getX(), mouseEvent.getY()));

    }
}
