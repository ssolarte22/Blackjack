package Modelo.ArbolBinario;

import Modelo.ArbolBinario.ArbolBinario;
import Modelo.Carta;
import Modelo.ListaEnlazada.Baraja;
import Modelo.ListaEnlazada.Jugador;

public class Dealer {

    private ArbolBinario arbol;

    public Dealer() {
        arbol = new ArbolBinario(17);
    }

    public void ejecutarTurno(Jugador dealer, Baraja baraja) {

        while (true) {

            int puntaje = dealer.getPuntaje();

            // para plantar
            if (!"PEDIR".equals(arbol.decidir(puntaje))) {
                System.out.println("Dealer se planta con " + puntaje);
                dealer.setEstado("PLANTADO");
                break;
            }

            // Pide carta
            Carta carta = baraja.robar();
            System.out.println("Dealer pide: " + carta);
            dealer.recibirCarta(carta);

            // Verifica si se paso
            if (dealer.getPuntaje() > 21) {
                System.out.println("Dealer se paso con " + dealer.getPuntaje());
                dealer.setEstado("PASADO");
                break;
            }
        }
    }

}
