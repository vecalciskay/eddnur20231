package edu.nur.edd.hanoi.tests;

import edu.nur.edd.hanoi.objects.Hanoi;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ObservadorHanoiConsola implements
        PropertyChangeListener {

    public static void main(String[] args) {
        int n = 3;
        Hanoi observado = new Hanoi(n);
        ObservadorHanoiConsola observer =
                new ObservadorHanoiConsola();
        observado.adjuntarObservador(observer);
        observado.resolver(0,2,1,n);
    }

    public ObservadorHanoiConsola() {
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Hanoi observado = (Hanoi)(evt.getSource());
        System.out.println("--------------------------");
        System.out.println(observado);
    }
}
