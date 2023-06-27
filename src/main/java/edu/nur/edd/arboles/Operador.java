package edu.nur.edd.arboles;

public class Operador extends ObjetoAritmetico {
    private Operacion operacion;

    public Operador(Operacion o) {
        operacion = o;
    }

    public Operador(char operador) {
        switch(operador) {
            case '+':
                operacion = Operacion.Suma;
                break;
            case '-':
                operacion = Operacion.Resta;
                break;
            case '*':
                operacion = Operacion.Multiplicacion;
                break;
            case '/':
                operacion = Operacion.Division;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        switch(operacion) {
            case Suma:
                return "+";
            case Resta:
                return "-";
            case Multiplicacion:
                return "*";
            case Division:
                return "/";
            default:
                return "N";
        }
    }

    public Operacion getOperacion() {
        return operacion;
    }
}
