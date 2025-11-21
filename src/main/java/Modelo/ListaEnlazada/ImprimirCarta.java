package Modelo.ListaEnlazada;

import Modelo.Carta;
import Modelo.Nodo;


public class ImprimirCarta {

    public static void imprimirCarta(Carta carta) {
        if (carta == null) System.out.println("no hay carta que imprimir :(");
        else System.out.println(carta);
    }

    public static void imprimirLista(ListaEnlazada lista) {
        Nodo actual = lista.getPrimerNodo();
        int contador = 1;
        while (actual != null) {
            System.out.println(contador + ". " + actual.getCarta());
            actual = actual.getSiguiente();
            contador++;
        }
        if (contador == 1) System.out.println("la lista esta vacia :(");
    }
}
