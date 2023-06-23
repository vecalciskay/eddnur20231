package edu.nur.edd.arboles;

public class ExpresionAritmetica extends ArbolBinario<ObjetoAritmetico> {
    @Override
    public String toString() {
        return super.toString() + " = " + evaluar();
    }

    public double evaluar() {
        return evaluarExpresion(raiz);
    }

    private double evaluarExpresion(Nodo<ObjetoAritmetico> nodo) {
        if (nodo.getContenido() instanceof Numero) {
            return ((Numero)(nodo.getContenido())).getValor();
        }

        double valorIzquierda =
                evaluarExpresion(nodo.getIzquierda());
        double valorDerecha =
                evaluarExpresion(nodo.getDerecha());

        Operacion operacion =
                ((Operador)(nodo.getContenido())).getOperacion();
        switch(operacion) {
            case Suma:
                return valorIzquierda + valorDerecha;
            case Resta:
                return valorIzquierda - valorDerecha;
            default:
                return 0.0;
        }
    }
}
