package edu.nur.edd.arboles.gui;

import edu.nur.edd.arboles.Arbol;

import javax.swing.*;
import java.awt.*;

public class ArbolFrame extends JFrame {
    private Arbol<String> modelo;
    public ArbolFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Arbol<>();
        crearArbolTest(modelo);
        ArbolPanel panel = new ArbolPanel(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private void crearArbolTest(Arbol<String> arbol) {
        String a = "McPato";
        String b1 = "Donald";
        String b2 = "Daisy";
        String c1 = "Hugo";
        String c2 = "Paco";
        String c3 = "Luis";

        String d1 = "Maria";
        String d2 = "Lucia";
        String d3 = "Gloria";
        arbol.agregarNodo(null, a);
        arbol.agregarNodo(a.hashCode(), b1);
        arbol.agregarNodo(a.hashCode(), b2);
        arbol.agregarNodo(b2.hashCode(), c1);
        arbol.agregarNodo(b2.hashCode(), c2);
        arbol.agregarNodo(b2.hashCode(), c3);
        arbol.agregarNodo(b1.hashCode(), d1);
        arbol.agregarNodo(b1.hashCode(), d2);
        arbol.agregarNodo(b1.hashCode(), d3);
    }

    public static void main(String[] args) {
        new ArbolFrame();
    }
}
