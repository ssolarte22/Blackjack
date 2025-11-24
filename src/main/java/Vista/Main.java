package Vista;

import Modelo.ListaEnlazada.ImprimirCarta;
import Modelo.ListaEnlazada.Dealer;
import Modelo.ListaEnlazada.Jugador;
import Modelo.ListaEnlazada.Baraja;
import Modelo.Carta;
import Modelo.Pila.Pila;
import Modelo.Cola.Turnos;
import Modelo.TablaHash.TablaHash;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a Blackjack versión consola");

        boolean seguirJugando = true;

        while (seguirJugando) {

            System.out.print("Ingrese su nombre: ");
            String nombreJugador = scanner.next().trim();
            if (nombreJugador.isEmpty()) nombreJugador = "Jugador";

            // Crear estructuras
            Baraja baraja = new Baraja();
            Pila historial = new Pila();
            Turnos turnos = new Turnos(); // Se crea la cola de turnos
            TablaHash hash = new TablaHash(31);

            // Crear jugadores
            Jugador jugador = new Jugador(nombreJugador);
            Jugador dealer = new Jugador("Dealer");
            Dealer dealerLogica = new Dealer(); // Instancia que contiene el Árbol Binario

            // Guardar jugadores en la Tabla Hash
            hash.put(jugador.getNombre(), jugador);
            hash.put(dealer.getNombre(), dealer);

            // Reparto inicial (2 cartas a cada uno)
            // Se alternan para simular un reparto real
            Carta cartaJugador1 = baraja.robar();
            jugador.recibirCarta(cartaJugador1);
            historial.apilar(cartaJugador1);

            Carta cartaDealer1 = baraja.robar();
            dealer.recibirCarta(cartaDealer1);
            historial.apilar(cartaDealer1);

            Carta cartaJugador2 = baraja.robar();
            jugador.recibirCarta(cartaJugador2);
            historial.apilar(cartaJugador2);

            Carta cartaDealer2 = baraja.robar();
            dealer.recibirCarta(cartaDealer2);
            historial.apilar(cartaDealer2);

            // ================= TURNO DEL JUGADOR =================

            while (!jugador.getEstado().equals("BUST") &&
                   !jugador.getEstado().equals("PLANTADO")) {

                System.out.println();
                System.out.println("Turno de: " + jugador.getNombre());
                System.out.println("Cartas del jugador:");
                ImprimirCarta.imprimirLista(jugador.getMano());
                System.out.println("Puntaje: " + jugador.getPuntaje());

                System.out.print("¿Desea otra carta? (s/n): ");
                String respuesta = scanner.next().toLowerCase();

                if (respuesta.equals("s")) {

                    Carta nuevaCarta = baraja.robar();
                    System.out.println(jugador.getNombre() + " recibe: " + nuevaCarta);
                    jugador.recibirCarta(nuevaCarta);
                    historial.apilar(nuevaCarta);

                    if (jugador.getPuntaje() > 21) {
                        System.out.println("¡Te pasaste!");
                        jugador.setEstado("BUST");
                    }

                } else {
                    jugador.setEstado("PLANTADO");
                    System.out.println(jugador.getNombre() + " se planta.");
                }
            }

            // ================= TURNO DEL DEALER =================

            System.out.println("\n--------------------------");
            System.out.println("Turno del Dealer");
            System.out.println("Cartas iniciales del Dealer:");
            ImprimirCarta.imprimirLista(dealer.getMano());
            System.out.println("Puntaje inicial: " + dealer.getPuntaje());
            System.out.println("--------------------------");

            // CORRECCIÓN PRINCIPAL:
            // Delegamos la inteligencia artificial al objeto 'dealerLogica'.
            // Este objeto usará internamente el Árbol Binario para decidir.
            dealerLogica.ejecutarTurno(dealer, baraja);
            
            // Nota: Las cartas que pida el dealer en su turno automático no se agregarán
            // a la variable 'historial' (Pila) en el Main, porque el método ejecutarTurno
            // no recibe la pila. Si necesitas que aparezcan en el historial final,
            // deberías modificar el método en Dealer.java para aceptar la Pila.

            System.out.println("Turno del Dealer finalizado.");

            // ================= RESULTADOS =================

            int puntajeJugador = jugador.getPuntaje();
            int puntajeDealer = dealer.getPuntaje();

            System.out.println("\n=== RESULTADOS ===");

            System.out.println("Jugador (" + jugador.getNombre() + "):");
            ImprimirCarta.imprimirLista(jugador.getMano());
            System.out.println("Puntaje: " + puntajeJugador + "\n");

            System.out.println("Dealer:");
            ImprimirCarta.imprimirLista(dealer.getMano());
            System.out.println("Puntaje: " + puntajeDealer + "\n");

            if (puntajeJugador > 21 && puntajeDealer > 21) {
                System.out.println("Ambos se pasaron. Empate técnico.");
            } else if (puntajeJugador > 21) {
                System.out.println("Dealer gana (Jugador se pasó).");
            } else if (puntajeDealer > 21) {
                System.out.println(jugador.getNombre() + " gana (Dealer se pasó). 🎉");
            } else if (puntajeJugador > puntajeDealer) {
                System.out.println(jugador.getNombre() + " gana. 🎉");
            } else if (puntajeDealer > puntajeJugador) {
                System.out.println("Dealer gana.");
            } else {
                System.out.println("Empate.");
            }

            // ================= HISTORIAL =================

            System.out.println("\nHistorial de cartas jugadas (Pila LIFO):");
            // Nota: Muestra principalmente las del jugador y el reparto inicial
            // debido a la limitación explicada arriba.
            Carta cartaHistorial;
            while ((cartaHistorial = historial.desapilar()) != null) {
                System.out.println(cartaHistorial);
            }

            // ================= REINICIAR JUEGO =================

            System.out.print("\n¿Desea jugar otra vez? (s/n): ");
            String respuestaRepetir = scanner.next().toLowerCase();

            if (!respuestaRepetir.equals("s")) {
                seguirJugando = false;
                System.out.println("Fin del juego. ¡Gracias por jugar!");
            }
        }
        
        scanner.close();
    }
}