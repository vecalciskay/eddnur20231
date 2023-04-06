package edu.nur.edd.hanoi.objects;

import java.io.Serializable;
import java.util.Stack;

public class Torre implements Serializable {
    private final Stack<Anillo> anillos;

    public Torre() {
        anillos = new Stack<>();
    }
    public Torre(int n) {
        anillos = new Stack<>();
        for (int i = n; i > 0; i--) {
            agregar(new Anillo(i));
        }
    }
    public void agregar(Anillo a) {
        anillos.push(a);
    }

    public Anillo sacar() {
        return anillos.pop();
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("|-");
        for (Anillo a:
             anillos) {
            resultado.append(a).append("-");
        }
        return resultado.toString();
    }

    public Stack<Anillo> getAnillos() {
        return anillos;
    }
}
