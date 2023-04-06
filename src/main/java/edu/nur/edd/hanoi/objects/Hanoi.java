package edu.nur.edd.hanoi.objects;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Hanoi implements Serializable {
    private final Torre[] torres;

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

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public Torre[] getTorres() {
        return torres;
    }
}
