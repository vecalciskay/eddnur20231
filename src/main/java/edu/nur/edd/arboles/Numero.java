package edu.nur.edd.arboles;

public class Numero extends ObjetoAritmetico {
    private double valor;

    public Numero(double d) {
        valor = d;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }

    public double getValor() {
        return valor;
    }
}
