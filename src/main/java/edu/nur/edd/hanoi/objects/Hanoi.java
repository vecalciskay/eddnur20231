package edu.nur.edd.hanoi.objects;

import edu.nur.edd.hanoi.tests.ObservadorHanoiConsola;

import java.beans.PropertyChangeSupport;

public class Hanoi {
    private Torre[] torres;

    private PropertyChangeSupport observado;

    public Hanoi(int n) {
        torres = new Torre[3];
        torres[0] = new Torre(n);
        torres[1] = new Torre();
        torres[2] = new Torre();

        observado = new PropertyChangeSupport(this);
    }

    public void resolver(int de, int a, int pp, int n) {
        if (n == 1) {
            moverDeA(de,a);
        } else {
            resolver(de, pp, a, n - 1);
            resolver(de, a, pp, 1);
            resolver(pp, a, de, n - 1);
        }
    }

    private void moverDeA(int de, int a) {
        Anillo anilloAMover = torres[de].sacar();
        torres[a].agregar(anilloAMover);

        observado.firePropertyChange("HANOI",false, true);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        String finDeLinea = "";
        for (int i = 0; i < 3; i++) {
            resultado.append(finDeLinea).append(torres[i]);
            finDeLinea = "\n";
        }
        return resultado.toString();
    }

    public void adjuntarObservador(
            ObservadorHanoiConsola observador) {
        observado.addPropertyChangeListener(observador);
    }
}
