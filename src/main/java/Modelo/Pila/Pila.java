package Modelo.Pila;

import Modelo.Carta;
import Modelo.Nodo;

public class Pila {

    private Nodo cima;

    public Pila() {
        cima = null;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public void apilar(Carta carta) {
        Nodo nuevo = new Nodo(carta);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public Carta desapilar() {
        if (esVacia()) {
            return null;
        }
        Carta carta = cima.getCarta();
        cima = cima.getSiguiente();
        return carta;
    }

    public Carta verCima() {
        if (esVacia()) {
            return null;
        } else {
            return cima.getCarta();
        }
    }

}
