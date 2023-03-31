package edu.nur.edd.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComercialAntojo20230213
implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() != "SALDO") {
            return;
        }
        if ((Double) evt.getOldValue() > 400.0) {
            return;
        }
        double saldoAnterior = (Double) evt.getOldValue();
        double saldoNuevo = (Double) evt.getNewValue();
        if (saldoNuevo > saldoAnterior &&
                saldoAnterior < 400 &&
                saldoNuevo > 400) {
            System.out.println("Enviar flores a la persona");
        }
    }
}
