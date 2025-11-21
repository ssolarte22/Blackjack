package Modelo.ListaEnlazada;

import Modelo.Carta;
import Modelo.Nodo;


public class Jugador {
    private String nombre;
    private ListaEnlazada mano;
    private int puntaje;
    private String estado; // plantado,pasado 

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ListaEnlazada();
        this.estado = "JUGANDO";
        this.puntaje = 0;
    }

    public void recibirCarta(Carta carta) {
        mano.agregar(carta);
        calcularPuntaje();
    }

    private void calcularPuntaje() {
        Nodo actual = mano.getPrimerNodo();
        int suma = 0;
        int ases = 0;

        while (actual != null) {
            Carta c = actual.getCarta();
            String numero = c.getNumero();
            if ("A".equals(numero)) {
                suma += 11;
                ases++;
            } else if ("J".equals(numero) || "Q".equals(numero) || "K".equals(numero)) {
                suma += 10;
            } else {
                suma += Integer.parseInt(numero);
            }
            actual = actual.getSiguiente();
        }

        // Ajustar ases de 11 a 1 si es necesario
        while (suma > 21 && ases > 0) {
            suma -= 10;
            ases--;
        }
        this.puntaje = suma;
        if (suma > 21) this.estado = "BUST";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada getMano() {
        return mano;
    }

    public void setMano(ListaEnlazada mano) {
        this.mano = mano;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}

