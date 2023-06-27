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

        ExpresionAritmetica expr1 = new ExpresionAritmetica("5+7");
        System.out.println(expr1);
        ExpresionAritmetica expr2 = new ExpresionAritmetica("   4  - 23");
        System.out.println(expr2);
        ExpresionAritmetica expr3 = new ExpresionAritmetica("((( 3*(74+ 8))))");
        System.out.println(expr3);
        ExpresionAritmetica expr4 = new ExpresionAritmetica("4.5 + (456 / 2)");
        System.out.println(expr4);
        ExpresionAritmetica expr5 = new ExpresionAritmetica("(((5+3)+2)-(5*7))/4");
        System.out.println(expr5);
    }
}
