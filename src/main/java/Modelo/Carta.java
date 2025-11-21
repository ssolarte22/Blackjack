package Modelo;

public class Carta {
    private String numero; //  numero de la carta
    private String palo;   // simbolo de la carta
    private int valor;     // valor de la carta 

    public Carta(String numero, String palo, int valor) {
        this.numero = numero;
        this.palo = palo;
        this.valor = valor;
    }

    public String getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    //imprime el valor de la carta
    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}
