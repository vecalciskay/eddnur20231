package edu.nur.edd.arboles;

public class ExpresionAritmetica extends ArbolBinario<ObjetoAritmetico> {
    public ExpresionAritmetica() {
        raiz = null;
    }

    public ExpresionAritmetica(String expresion) {
        raiz = leerExpresion(expresion);
    }

    /**
     * 1. Encontrar el operador principal
     *     Leer caracter x caracter
     *     Si encontramos un operador cuando el conteo de parentesis es 0 --> operador principal
     *      Si no encontramos y expr[0] = '(' y expr[ultimo] = ')' entonces le quitamos los parentesis y volvemos a 1.
     *      Debe ser un numero, tratamos de parsear
     *      ERROR EN LA EXPRESION
     * 2. Expresion izquierda a nodo izquierda
     * 3. Expresion derecha a nodo derecha
     * @param expresionConEspacios
     * @return
     */
    private Nodo<ObjetoAritmetico> leerExpresion(String expresionConEspacios) {
        String expresion = expresionConEspacios.trim();
        String expresionIzquierda = "";
        String expresionDerecha = "";
        int conteoParentesis = 0;
        char operador = '0';
        double numero = 0;
        Nodo<ObjetoAritmetico> resultado = null;
        boolean encontramosOperadorPrincipal = false;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') {
                conteoParentesis++;
                continue;
            }
            if (c == ')') {
                conteoParentesis--;
                continue;
            }
            if (esOperador(c) && conteoParentesis == 0) {
                expresionIzquierda = expresion.substring(0, i);
                expresionDerecha = expresion.substring(i+1);
                operador = c;
                encontramosOperadorPrincipal = true;
                break;
            }
        }

        if (!encontramosOperadorPrincipal &&
            expresion.charAt(0) == '(' &&
                expresion.charAt(expresion.length()-1) == ')') {
            return leerExpresion(
                    expresion.substring(1,expresion.length()-1));
        }

        if (!encontramosOperadorPrincipal) {
            double posibleNumero = 0.0;
            try {
                posibleNumero = Double.parseDouble(expresion);
            } catch(Exception q) {
                posibleNumero = Double.MIN_VALUE;
            }
            if (posibleNumero > Double.MIN_VALUE) {
                numero = Double.parseDouble(expresion);
            }
        }

        if (expresionIzquierda.isEmpty() &&
                expresionDerecha.isEmpty()) {
            resultado = new Nodo<>(new Numero(numero));
        } else {
            resultado = new Nodo<>(new Operador(operador));
            resultado.setIzquierda(leerExpresion(expresionIzquierda));
            resultado.setDerecha(leerExpresion(expresionDerecha));
        }
        return resultado;
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

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
            case Multiplicacion:
                return valorIzquierda * valorDerecha;
            case Division:
                return valorIzquierda / valorDerecha;
            default:
                return 0.0;
        }
    }
}
