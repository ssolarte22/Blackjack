package Modelo.ArbolBinario;

public class ArbolBinario {

    private NodoDecision raiz;

    public ArbolBinario(int limite) {
        raiz = new NodoDecision(limite, "");
        raiz.izquierda = new NodoDecision(0, "PEDIR");
        raiz.derecha = new NodoDecision(0, "PLANTARSE");
    }

    public String decidir(int puntaje) {
        String resultado;

        if (puntaje < raiz.limite) {
            resultado = raiz.izquierda.accion;
        } else {
            resultado = raiz.derecha.accion;
        }

        return resultado;
    }
}
