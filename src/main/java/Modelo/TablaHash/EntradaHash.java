package Modelo.TablaHash;

import Modelo.ListaEnlazada.Jugador;


public class EntradaHash {
    private String clave;
    private Jugador valor;
    private EntradaHash siguiente;

    public EntradaHash(String clave, Jugador valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Jugador getValor() {
        return valor;
    }

    public void setValor(Jugador valor) {
        this.valor = valor;
    }

    public EntradaHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(EntradaHash siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
