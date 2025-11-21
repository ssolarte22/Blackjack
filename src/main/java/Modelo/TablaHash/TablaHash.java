package Modelo.TablaHash;

import Modelo.ListaEnlazada.Jugador;

public class TablaHash {

    private EntradaHash[] celdas;
    private int capacidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.celdas = new EntradaHash[capacidad];
    }

    private int calcularIndice(String clave) {
        int suma = 0;

        for (int i = 0; i < clave.length(); i++) {
            suma += clave.charAt(i);
        }

        int indice = suma % capacidad;
        return indice;
    }

    public void put(String clave, Jugador jugador) {

        int indice = calcularIndice(clave);
        EntradaHash nodoActual = celdas[indice];

        // si esta vacio, guardar ahi
        if (nodoActual == null) {
            celdas[indice] = new EntradaHash(clave, jugador);
            return;
        }

        // buscar si la clave ya existe
        EntradaHash nodoAnterior = null;
        while (nodoActual != null) {

            if (nodoActual.clave.equals(clave)) {
                nodoActual.valor = jugador; // actualizar
                return;
            }

            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        // agregar al final
        nodoAnterior.siguiente = new EntradaHash(clave, jugador);
    }

    public Jugador get(String clave) {

        int indice = calcularIndice(clave);
        EntradaHash nodoActual = celdas[indice];

        while (nodoActual != null) {
            if (nodoActual.clave.equals(clave)) {
                return nodoActual.valor;
            }
            nodoActual = nodoActual.siguiente;
        }

        return null;
    }
}
