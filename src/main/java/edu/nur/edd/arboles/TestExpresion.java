package edu.nur.edd.arboles;

public class TestExpresion {
    public static void main(String[] args) {
        ExpresionAritmetica arbol =
                new ExpresionAritmetica();

        Operador a = new Operador(Operacion.Suma);
        Numero n1 = new Numero(3.0);
        Operador b = new Operador(Operacion.Resta);
        Numero n2 = new Numero(4.0);
        Numero n3 = new Numero(5.0);

        arbol.agregarNodo(null, a, PosicionNodo.Derecha);
        arbol.agregarNodo(a.hashCode(), n1, PosicionNodo.Izquierda);
        arbol.agregarNodo(a.hashCode(), b, PosicionNodo.Derecha);
        arbol.agregarNodo(b.hashCode(), n2, PosicionNodo.Izquierda);
        arbol.agregarNodo(b.hashCode(), n3, PosicionNodo.Derecha);
        System.out.println(arbol);
    }
}
