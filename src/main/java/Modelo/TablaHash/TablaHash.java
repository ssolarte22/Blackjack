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
        return suma % capacidad;
    }

    public void put(String clave, Jugador jugador) {
        int indice = calcularIndice(clave);
        EntradaHash nodoActual = celdas[indice];

        // Si está vacío, insertar directamente
        if (nodoActual == null) {
            celdas[indice] = new EntradaHash(clave, jugador);
            return;
        }

        // Buscar si la clave existe
        EntradaHash nodoAnterior = null;
        while (nodoActual != null) {
            if (nodoActual.getClave().equals(clave)) {
                nodoActual.setValor(jugador); // Actualizar
                return;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente();
        }

        // Agregar al final de la lista
        nodoAnterior.setSiguiente(new EntradaHash(clave, jugador));
    }

    public Jugador get(String clave) {
        int indice = calcularIndice(clave);
        EntradaHash nodoActual = celdas[indice];

        while (nodoActual != null) {
            if (nodoActual.getClave().equals(clave)) {
                return nodoActual.getValor();
            }
            nodoActual = nodoActual.getSiguiente();
        }

        return null;
    }
}
