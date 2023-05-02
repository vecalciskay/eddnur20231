package edu.nur.edd.redes.chat;

import java.awt.*;

public abstract class ItemConversacion {
    protected boolean mensajeSalida;

    public boolean isMensajeSalida() {
        return mensajeSalida;
    }

    public abstract void dibujar(Graphics g, int x, int y, int ancho);
}
