package edu.nur.edd.arboles;

public class TestArbol {
    public static void main(String[] args) {
        Arbol<String> arbol = new Arbol<String>();

        String a = "McPato";
        String b1 = "Donald";
        String b2 = "Daisy";
        String c1 = "Hugo";
        String c2 = "Paco";
        String c3 = "Luis";
        arbol.agregarNodo(null, a);
        arbol.agregarNodo(a.hashCode(), b1);
        arbol.agregarNodo(a.hashCode(), b2);
        arbol.agregarNodo(b2.hashCode(), c1);
        arbol.agregarNodo(b2.hashCode(), c2);
        arbol.agregarNodo(b2.hashCode(), c3);

        System.out.println("Arbol: " + arbol);
    }
}
