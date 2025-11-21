package Modelo.ListaEnlazada;

import Modelo.Carta;
import Modelo.Nodo;

public class Baraja {

    private ListaEnlazada lista;

    // Palos y numeros
    private String[] palos = {"Espadas", "Corazon", "Diamante", "Trebol"};
    private String[] numeros = {"A", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "J", "Q", "K"};

    public Baraja() {
        lista = new ListaEnlazada();
        construirBaraja();
        mezclar();
    }

    private void construirBaraja() {
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < numeros.length; j++) {

                String palo = palos[i];
                String numero = numeros[j];

                int valor;
                switch (numero) {
                    case "A":
                        valor = 11;
                        break;
                    case "J":
                        valor = 10;
                        break;
                    case "Q":
                        valor = 10;
                        break;
                    case "K":
                        valor = 10;
                        break;
                    default:
                        valor = Integer.parseInt(numero);
                }

                Carta carta = new Carta(numero, palo, valor);
                lista.agregar(carta);
            }
        }
    }

    // retirar la primera carta
    public Carta robar() {
        return lista.retirar();
    }

    public boolean estaVacia() {
        return lista.esVacia();
    }

    public ListaEnlazada getLista() {
        return lista;
    }

    // Imprime el mazo 
    public void mostrarBaraja() {
        lista.imprimir();
    }

    // Mezcla la barajas
    public void mezclar() {

        // copiar la lista a un arreglo temporal
        Carta[] arreglo = new Carta[52];
        int indice = 0;

        Nodo nodoActual = lista.getPrimerNodo();
        while (nodoActual != null && indice < arreglo.length) {
            arreglo[indice] = nodoActual.getCarta();
            indice++;
            nodoActual = nodoActual.getSiguiente();
        }

        //Mezclar con random
        for (int i = indice - 1; i > 0; i--) {
            int posicionAleatoria = (int) (Math.random() * (i + 1));
            Carta temporal = arreglo[i];
            arreglo[i] = arreglo[posicionAleatoria];
            arreglo[posicionAleatoria] = temporal;
        }

        // reconstruir la lista mezclada
        ListaEnlazada nuevaLista = new ListaEnlazada();
        for (int i = 0; i < indice; i++) {
            nuevaLista.agregar(arreglo[i]);
        }
        lista = nuevaLista;
    }

}
