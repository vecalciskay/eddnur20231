package edu.nur.edd.arboles;

public class Operador extends ObjetoAritmetico {
    private Operacion operacion;

    public Operador(Operacion o) {
        operacion = o;
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
