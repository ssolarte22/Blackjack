package Modelo.Cola;

import Modelo.Carta;
import Modelo.Nodo;

public class Cola {

    private Nodo inicio;
    private Nodo fin;

    public Cola() {
        inicio = null;
        fin = null;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void encolar(Carta carta) {
        Nodo nuevo = new Nodo(carta);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        if (inicio == null) {
            inicio = nuevo;
        }
    }

    public Carta desencolar() {
        if (esVacia()) {
            return null;
        }
        Carta carta = inicio.getCarta();
        inicio = inicio.getSiguiente();
        if (inicio == null) {
            fin = null;
        }
        return carta;
    }

    public Carta verInicio() {
        if (esVacia()) {
            return null;
        }
        return inicio.getCarta();
    }
}
