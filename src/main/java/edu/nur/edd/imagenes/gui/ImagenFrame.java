package edu.nur.edd.imagenes.gui;

import edu.nur.edd.imagenes.obj.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    public ImagenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        Imagen modelo = new Imagen(600,400);
        //modelo.todoUnColor();
        modelo.leer();
        modelo.gris();
        ImagenPanel panel = new ImagenPanel(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ImagenFrame obj = new ImagenFrame();
    }
}
