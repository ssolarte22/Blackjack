package Modelo.ListaEnlazada;

import Modelo.Carta;
import Modelo.Nodo;


public class ListaEnlazada {
    
    private Nodo inicio; //cabeza de la lista

    public ListaEnlazada() {
        inicio = null;
    }

    // Agregar al final para construir la bajara
    public void agregar(Carta carta) {
        Nodo nuevo = new Nodo(carta);
        if (inicio == null) {
            inicio = nuevo;  //el nuevo nodo pasa hacer el primero
            return;
        }
        Nodo actual = inicio;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }

    // Agregar al inicio 
    public void agregarAlInicio(Carta carta) {
        Nodo nuevo = new Nodo(carta);
        nuevo.setSiguiente(inicio); //enlaza el nuevo nodo con el actual
        inicio = nuevo;
    }

    // Retirar la primera carta 
    public Carta retirar() {
        if (inicio == null) {
            return null;
            }
        Carta carta = inicio.getCarta();
        inicio = inicio.getSiguiente();
        return carta;
    }

    // Retirar al final 
    public Carta retirarUltimo() {
        if (inicio == null) {
            return null;
        }
        if (inicio.getSiguiente() == null) { //comprueba si solo tiene un nodo
            Carta carta = inicio.getCarta();
            inicio = null;
            return carta;
        }
        Nodo actual = inicio;  //inicia con el primer nodo de la lista
        while (actual.getSiguiente().getSiguiente() != null)  {
            actual = actual.getSiguiente();
        }
        Carta carta = actual.getSiguiente().getCarta();
        actual.setSiguiente(null);
        return carta;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public Nodo getPrimerNodo() {
        return inicio;
    }

    public void imprimir() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.getCarta());
            actual = actual.getSiguiente();
        }
    }
}
