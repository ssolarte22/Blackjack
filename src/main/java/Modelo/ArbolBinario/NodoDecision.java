package Modelo.ArbolBinario;

public class NodoDecision {
    public int limite;
    public String accion;
    public NodoDecision izquierda;
    public NodoDecision derecha;

    public NodoDecision(int limite, String accion) {
        this.limite = limite;
        this.accion = accion;
        this.izquierda = null;
        this.derecha = null;
    }
}
