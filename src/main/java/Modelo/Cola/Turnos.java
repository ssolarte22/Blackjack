package Modelo.Cola;

public class Turnos {

    private String turnoActual;

    public Turnos() {
        turnoActual = "Jugador";
    }

    public String siguiente() {
        String turno = turnoActual;
        if (turnoActual.equals("Jugador")) {
            turnoActual = "Dealer";
        } else {
            turnoActual = "Jugador";
        }
        return turno;
    }
}
