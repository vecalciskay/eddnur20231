package edu.nur.edd.arboles.gui;

import edu.nur.edd.arboles.Arbol;

import java.awt.*;

public class DibujoArbol {
    private static final int ESPACIO_HORIZONTAL = 20;
    private static final int ESPACIO_VERTICAL = 50;
    private static final int TAMANO_NODO = 40;
    private final Arbol<String> modelo;

    public DibujoArbol(Arbol<String> modelo) {
        this.modelo = modelo;
    }

    public void dibujar(Graphics g) {
        dibujarNodo(modelo.getRaiz(), 100, 100, g);
    }

    public void dibujarNodo(Arbol.Nodo<String> nodo,
                            int x, int y, Graphics g) {
        int ancho = ancho(nodo);

        int xNodo = x +ancho/2 - (TAMANO_NODO/2);

        int xHijo = x;
        int yHijo = y + TAMANO_NODO + ESPACIO_VERTICAL;
        for(Arbol.Nodo<String> hijo : nodo.getHijos()) {

            int avanzar = ancho(hijo) + ESPACIO_HORIZONTAL;

            g.setColor(Color.black);
            g.drawLine(xNodo + TAMANO_NODO/2,
                    y + TAMANO_NODO / 2,
                    xHijo + (avanzar-ESPACIO_HORIZONTAL)/2,
                    yHijo + TAMANO_NODO/2);

            dibujarNodo(hijo, xHijo, yHijo, g);
            xHijo += avanzar;
        }
        g.setColor(Color.white);
        g.fillOval(xNodo, y,
                TAMANO_NODO, TAMANO_NODO);
        g.setColor(Color.black);
        g.drawOval(xNodo, y,
                TAMANO_NODO, TAMANO_NODO);
        g.drawString(nodo.getContenido(),xNodo + 10, y+20);
    }

    public int ancho(Arbol.Nodo<String> nodo) {
        if (nodo.getHijos().tamano() == 0) {
            return TAMANO_NODO;
        }

        int ancho = 0;
        int espacio = 0;
        for(Arbol.Nodo<String> hijo : nodo.getHijos()) {
            int avanzar = espacio + ancho(hijo);
            ancho += avanzar;
            espacio = ESPACIO_HORIZONTAL;
        }
        return ancho;
    }
}
