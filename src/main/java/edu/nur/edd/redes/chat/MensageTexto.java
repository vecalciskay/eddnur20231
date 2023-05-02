package edu.nur.edd.redes.chat;

import java.awt.*;

public class MensageTexto extends ItemConversacion{
    private String texto;

    public MensageTexto(String texto, boolean mensajeSalida) {
        this.texto = texto;
        this.mensajeSalida = mensajeSalida;
    }

    public String getTexto() {
        return texto;
    }

    /**
     *  - g.getFontMetrics().stringWidth(texto)
     * @param g
     * @param x
     * @param y
     * @param ancho
     */
    @Override
    public void dibujar(Graphics g, int x, int y, int ancho) {
        if (mensajeSalida)
            g.drawString(texto, x + ancho / 2, y);
        else
            g.drawString(texto, x, y);
    }

    @Override
    public String toString() {
        if (mensajeSalida) {
            return " -> " + texto;
        } else {
            return " <- " + texto;
        }
    }
}
