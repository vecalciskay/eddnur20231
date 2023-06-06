package edu.nur.edd.arboles.gui;

import edu.nur.edd.arboles.Arbol;

import javax.swing.*;
import java.awt.*;

public class ArbolPanel extends JPanel {
    private Arbol<String> modelo;

    public ArbolPanel(Arbol<String> modelo) {
        this.modelo = modelo;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        DibujoArbol dibujo = new DibujoArbol(modelo);
        dibujo.dibujar(g);
    }
}
