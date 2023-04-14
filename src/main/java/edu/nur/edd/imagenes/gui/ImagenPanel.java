package edu.nur.edd.imagenes.gui;

import edu.nur.edd.imagenes.obj.Imagen;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ImagenPanel extends JPanel implements PropertyChangeListener {
    private Imagen modelo;

    public ImagenPanel(Imagen img) {
        modelo = img;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(modelo.getAncho(), modelo.getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null) {
            modelo.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
