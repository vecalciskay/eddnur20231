package edu.nur.edd.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CuentaObservada {

    private PropertyChangeSupport observado;
    private double saldo;

    public CuentaObservada() {
        saldo = 0.0;
        observado = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener o) {
        observado.addPropertyChangeListener(o);
    }

    public void depositar(double m) {
        double saldoAnterior = saldo;
        saldo += m;
        observado.firePropertyChange("SALDO",
                saldoAnterior, saldo);
    }

    public void retirar(double m) {
        double saldoAnterior = saldo;
        saldo -= m;
        observado.firePropertyChange("SALDO",
                saldoAnterior, saldo);
    }

    @Override
    public String toString() {
        return "Saldo Cuenta: " + saldo;
    }
}
