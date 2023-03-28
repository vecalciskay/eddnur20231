package edu.nur.edd.hanoi.gui;

import edu.nur.edd.hanoi.objects.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HanoiPanel extends JPanel
implements PropertyChangeListener {

    private Hanoi modelo;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.modelo = (Hanoi)(evt.getSource());
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null) {
            return;
        }
/*
        DibujoHanoi dibujo = new DibujoHanoi(modelo);
        dibujo.dibujar(g, 20, 350);

 */
    }
}
