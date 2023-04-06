package edu.nur.edd.hanoi.objects;

import java.io.Serializable;

public class Anillo implements Serializable {
    private final int tamano;

    public int getTamano() {
        return tamano;
    }

    public Anillo(int t) {
        tamano = t;
    }

    @Override
    public String toString() {
        return String.valueOf(tamano);
    }
}
