package modelo;

import java.util.Observable;

import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import PlanoGeneral.Plano;

public class ModeloObservable extends Observable{
	private Plano plano;
	private Construccion construccion;
	
	public ModeloObservable(int tamanioX,int tamanioY){
		plano = new Plano(tamanioX,tamanioY);
		//construccion = new Construccion(new Posicion(tamanioX,tamanioY));
	}
	
    public void inicializarModeloDato(Posicion posicion) {
    	
        this.notifyObservers();
    }
}
