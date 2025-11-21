package Modelo.TablaHash;

import Modelo.ListaEnlazada.Jugador;


public class EntradaHash {
    String clave;
    Jugador valor;
    EntradaHash siguiente;

    public EntradaHash(String clave, Jugador valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
