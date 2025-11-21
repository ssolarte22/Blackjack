package Modelo.Cola;


public class Turnos {
    private Cola cola;

    public Turnos() {
        cola = new Cola();
        cola.encolar("Jugador");
        cola.encolar("Dealer");
    }

    //devuelve el siguiente turno
    public String siguiente() {
        String t = cola.desencolar();
        if (t != null) cola.encolar(t);
        return t;
    }
}
