package edu.nur.edd.arboles;

public class TestArbolBinario {
    public static void main(String[] args) {
        ArbolBinario<String> arbol = new ArbolBinario<String>();

        String a = "McPato";
        String b1 = "Donald";
        String b2 = "Daisy";
        String c1 = "Hugo";
        String c2 = "Paco";
        arbol.agregarNodo(null, a, PosicionNodo.Derecha);
        arbol.agregarNodo(a.hashCode(), b1, PosicionNodo.Izquierda);
        arbol.agregarNodo(a.hashCode(), b2, PosicionNodo.Derecha);
        arbol.agregarNodo(b2.hashCode(), c1, PosicionNodo.Izquierda);
        arbol.agregarNodo(b2.hashCode(), c2, PosicionNodo.Derecha);

        System.out.println(arbol);
    }
}
