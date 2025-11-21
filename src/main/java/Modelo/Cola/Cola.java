package Modelo.Cola;

public class Cola {

    private class NodoCola {
        String dato;
        NodoCola siguiente;

        NodoCola(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private NodoCola inicio;
    private NodoCola fin;

    public Cola() {
        inicio = null;
        fin = null;
    }

    public void encolar(String dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (fin != null) fin.siguiente = nuevo;
        fin = nuevo;
        if (inicio == null) inicio = nuevo;
    }

    public String desencolar() {
        if (inicio == null) return null;
        String dato = inicio.dato;
        inicio = inicio.siguiente;
        if (inicio == null) fin = null;
        return dato;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public String verInicio() {
        if (inicio == null) return null;
        return inicio.dato;
    }
}
