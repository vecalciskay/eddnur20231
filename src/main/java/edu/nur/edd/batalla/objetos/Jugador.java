package edu.nur.edd.batalla.objetos;

import edu.nur.edd.batalla.gui.JugadorPanel;

import java.awt.*;
import java.beans.PropertyChangeSupport;

public class Jugador {
    private final Color color;
    private Pieza[] piezas;
    private PropertyChangeSupport observed;
    public Jugador(Color c) {
        this.color = c;
        piezas = crearPiezas();
        observed = new PropertyChangeSupport(this);
        notificar();
    }

    private Pieza[] crearPiezas() {
        Pieza[] resultado = new Pieza[7];
        int piezasPuestas = 0;
        boolean completo = false;
        while (!completo) {
            int x = (int) (Math.random() * 285);
            int y = (int) (Math.random() * 385);
            int r = 5 + (int) (Math.random() * 10);

            while (!posiblePiezaOk(x, y, r, resultado)) {
                x = (int) (Math.random() * 285);
                y = (int) (Math.random() * 385);
                r = 5 + (int) (Math.random() * 10);
            }

            resultado[piezasPuestas] = new Pieza(x, y, r);
            piezasPuestas++;
            if (piezasPuestas == 7)
                completo = true;
        }

        return resultado;
    }

    private boolean posiblePiezaOk(int x, int y, int r, Pieza[] resultado) {
        for (int i = 0; i < 7; i++) {
            if (resultado[i] == null) {
                return true;
            }
            Pieza p = resultado[i];
            if (Math.abs(p.getX() - x) < 15 &&
                    Math.abs(p.getY() - y) < 15)
            {
                return false;
            }
        }
        return true;
    }

    public boolean matoPieza(int x, int y) {
        for (int i = 0; i < 7; i++) {
            if (piezas[i].contiene(x,y)) {
                piezas[i].matar();
                return true;
            }
        }
        return false;
    }

    public void dibujar(Graphics g) {
        g.setColor(this.color);
        for (int i = 0; i < 7; i++) {
            if (piezas[i].getEstado() == 0)
                continue;
            piezas[i].dibujar(g);
        }
    }

    public void addListener(JugadorPanel jugadorPanel) {
        observed.addPropertyChangeListener(jugadorPanel);
    }

    /**
     * PIEZAS 50,50,60,60,70,70,80,80,90,90,100,100,110,110
     * @return
     */
    public String getPiezasParaRed() {
        StringBuilder resultado = new StringBuilder();
        String separador = "";
        for (int i = 0; i < 7; i++) {
            resultado.append(separador);
            resultado.append(piezas[i].getX())
                    .append(",")
                    .append(piezas[i].getY())
                    .append(",")
                    .append(piezas[i].getEstado());
            separador = ",";
        }
        return resultado.toString();
    }

    public void posicionPiezaYEstado(int i, int x, int y, int estado) {
        piezas[i].setX(x);
        piezas[i].setY(y);
        piezas[i].setEstado(estado);
    }

    public void notificar() {
        observed.firePropertyChange("JUEGO", true, false);
    }
}
